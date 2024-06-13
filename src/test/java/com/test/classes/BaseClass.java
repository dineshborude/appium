package com.test.classes;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseClass {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void startServerAndLaunchApp() throws MalformedURLException, InterruptedException {

         service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\dines\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel3");
        options.setApp("C:\\Users\\dines\\IdeaProjects\\appium-project\\src\\test\\java\\com\\app\\resourses\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        

    }

//    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }


}