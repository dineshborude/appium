package com.test.classes;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class AppiumBasics {

    @Test
    public void AppiumTest() throws MalformedURLException {

    //Appium Code --> Appium Server Via W3C Protocol --> Mobile App

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel3");
        options.setApp("C:\\Users\\dines\\IdeaProjects\\appium-project\\src\\test\\java\\com\\app\\resourses\\ApiDemos-debug.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        androidDriver.quit();

    }

}
