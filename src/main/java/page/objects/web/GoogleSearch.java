package page.objects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {

    WebDriver driver;

    public GoogleSearch(WebDriver driver) {

        this.driver = driver;
//        PageFactory.initElements();

    }

    By searchBox = By.xpath("//textarea[@class='gLFyf']");
    By searchButton = By.xpath("//input[contains(@aria-label, 'Google Search')]");

    By FacebookLink = By.xpath("//*[contains(text(), 'Facebook - log in or sign up')]");

    public void searchGoogle(String searchKeyword) throws InterruptedException {
        driver.findElement(searchBox).sendKeys(searchKeyword);
        Thread.sleep(5000);

    }

    public void clickOnSearchButton() throws InterruptedException {

        driver.findElement(searchButton).click();
        driver.wait(10000);

    }

    public void clickOnFacebookLink() throws InterruptedException {
        Thread.sleep(10000);

        driver.findElement(FacebookLink).click();
    }

}
