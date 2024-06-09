package test.web;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.objects.web.GoogleSearch;

import java.io.File;
import java.io.IOException;


public class Test_GoogleSearch {

    WebDriver driver;
    GoogleSearch objectRepo;

    @BeforeTest
    public void launchWeb() {
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");


    }

    @Test
    public void googleSearch() throws InterruptedException, IOException {

        GoogleSearch search = new GoogleSearch(driver);
        search.searchGoogle("Facebook");

        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("target/Screenshots/ss.jpg");
        FileHandler.copy(srcFile,destFile);


        search.clickOnSearchButton();
    }


    @AfterTest
    public void tearDown()  {
        driver.quit();

    }

}
