package com.test.classes;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class WiFiSettings extends BaseClass{

    @Test
    public void wifiSettings() throws MalformedURLException, InterruptedException {

         driver.findElement(AppiumBy.accessibilityId("Preference")).click();


    }

}
