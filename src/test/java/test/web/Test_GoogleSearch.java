package test.web;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.objects.web.GoogleSearch;
import java.util.List;

import java.io.File;
import java.io.IOException;


public class Test_GoogleSearch {

    WebDriver driver;
    GoogleSearch objectRepo;

    @BeforeTest
    public void launchWeb() {
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");


        List<WebElement> links = driver.findElements(By.tagName("a"));
        int lengthOfLinks = links.size();
        System.out.println(lengthOfLinks);

        // Print the URLs of all links
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            System.out.println(url);
        }

//        ButtonClicker

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
