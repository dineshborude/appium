package page.objects.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import static Resource.Swipe.SwipeDirection.*;
import static page.objects.android.Swipe.SwipeDirection.SWIPE_LEFT;
import static page.objects.android.Swipe.SwipeDirection.SWIPE_RIGHT;

public class Swipe {
    private final AppiumDriver driver;

    public Swipe(AppiumDriver driver) {
        this.driver = driver;
    }

    private final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    public void swipe(SwipeDirection direction) {

        WebElement ele;
        if (driver instanceof AndroidDriver) {
            ele = driver.findElement(AppiumBy.xpath(TestElement.ANDROID_GEN_LOCATOR));
        } else if (driver instanceof IOSDriver && (direction == SWIPE_RIGHT || direction == SWIPE_LEFT)) {
            ele = driver.findElement(AppiumBy.xpath(TestElement.IOS_GEN_LOCATOR_02));
        } else {
            ele = driver.findElement(AppiumBy.accessibilityId(TestElement.IOS_GEN_LOCATOR));
        }

        Sequence dragNDrop = new Sequence(finger, 1);
        int startX, startY, endX, endY;
        switch (direction) {
            case SWIPE_RIGHT:
                startX = ele.getRect().x + (ele.getSize().width / 4);
                startY = ele.getRect().y + (ele.getSize().height / 2);
                endX = ele.getRect().x + (ele.getSize().width * 3 / 4);
                endY = ele.getRect().y + (ele.getSize().height / 2);
                break;
            case SWIPE_LEFT:
                startX = ele.getRect().x + (ele.getSize().width * 3 / 4);
                startY = ele.getRect().y + (ele.getSize().height / 2);
                endX = ele.getRect().x + (ele.getSize().width / 4);
                endY = ele.getRect().y + (ele.getSize().height / 2);
                break;
            case SWIPE_DOWN:
                startX = ele.getRect().x + (ele.getSize().width / 2);
                startY = ele.getRect().y + (ele.getSize().height / 4);
                endX = ele.getRect().x + (ele.getSize().width / 2);
                endY = ele.getRect().y + (ele.getSize().height * 3 / 4);
                break;
            case SWIPE_UP:
                startX = ele.getRect().x + (ele.getSize().width / 2);
                startY = ele.getRect().y + (ele.getSize().height * 3 / 4);
                endX = ele.getRect().x + (ele.getSize().width / 2);
                endY = ele.getRect().y + (ele.getSize().height / 4);
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startX, startY));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), endX, endY));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));
    }

    public void tap(int x, int y) {
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }
    public enum SwipeDirection {
        SWIPE_RIGHT,
        SWIPE_LEFT,
        SWIPE_DOWN,
        SWIPE_UP
    }
}