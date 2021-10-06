package com.iexceed.uiframework.DomainObjects;

import com.iexceed.uiframework.appium.PcloudyConnection;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

public class ConnectionObjects {
    public static boolean errorfree = true;


    PcloudyConnection createConnection;
    public static AppiumDriver driver;
    public ConnectionObjects(){
        createConnection = new PcloudyConnection();
    }


    public void setRemoteDeviceCapabilities(String pcloudy_username, String pcloudy_api, String platform, String version, String deviceName, String automationName, String applicationName, String androidActivity, String androidPackage, String bundleID, String maxDuration, String deviceURL, String orientation, String isTrusted, By targetCompanyName, By trustCompanyName, By trustBtn) throws MalformedURLException, InterruptedException {
        System.out.println(androidActivity+androidPackage+applicationName);
        createConnection.setRemoteDeviceCapabilities(pcloudy_username,pcloudy_api,platform,version,deviceName,automationName,applicationName,androidActivity,androidPackage,bundleID,maxDuration,deviceURL,orientation,Boolean.valueOf(isTrusted),targetCompanyName,trustCompanyName,trustBtn);
        driver = appiumDriver;
    }

    public void setRealDeviceCapabilities(String platform, String deviceName, String automationName, String applicationName, String androidActivity, String androidPackage, String deviceURL, String noReset, String orientation) throws Exception {
        createConnection.setRealDeviceCapabilities(platform,deviceName,automationName,applicationName,androidActivity,androidPackage,deviceURL,noReset,orientation);
        driver = appiumDriver;
    }
}
