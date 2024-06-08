package page.objects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    AndroidDriver driver;
    public FormPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(id="")
    private WebElement nameField;

    @AndroidFindBy(id = "")
    private WebElement gender;


    public void setNameField() {
        nameField.sendKeys("Danny");
    }

}
