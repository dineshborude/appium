package test.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.objects.web.GoogleSearch;


public class Test_GoogleSearch {

    WebDriver driver;
    GoogleSearch objectRepo;

    @BeforeTest
    public void launchWeb() {
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");


    }

    @Test
    public void googleSearch() throws InterruptedException {

        GoogleSearch search = new GoogleSearch(driver);
        search.searchGoogle("Facebook");
        search.clickOnSearchButton();
    }

    @Test
    public void fbVerifyAndAccess() throws InterruptedException {

        objectRepo = new GoogleSearch(driver);
        objectRepo.clickOnFacebookLink();

    }

    @AfterTest
    public void tearDown()  {
        driver.quit();

    }

}
