package com.iexceed.uiframework.PageObjects.Android;

import com.iexceed.uiframework.DomainObjects.AndroidUtility;
import com.iexceed.uiframework.appium.GenericMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static com.iexceed.uiframework.DomainObjects.ConnectionObjects.driver;

public class HomePageObjects {


    AndroidUtility androidUtility;

    public By cancelBtn = By.xpath("//android.widget.TextView[@content-desc='Cancel']");
    public By continueBtn = By.xpath("//android.widget.Button[@content-desc='Continue']");

    public By registerBtn = By.id("com.iexceed.applicationapp:id/btn_userconact_ui");
    public By registerBtn1 = By.id("com.iexceed.applicationapp:id/btn_userconact_ui_users");
    public By ArabicBtn = By.id("com.iexceed.applicationapp:id/btn_arabic");
    public By EnglishBtn = By.id("com.iexceed.applicationapp:id/btn_english");
    public By menuBtn = By.id("com.iexceed.retailonboarding.debug:id/appbar_menu_icon");
    public By darkthemeBtn = By.id("com.iexceed.applicationapp:id/btn_dark_theme");
    public By lighthemeBtn = By.id("com.iexceed.applicationapp:id/btn_light_theme");


    public HomePageObjects(){
        androidUtility = new AndroidUtility();
    }

    public void clickRegisterBtn() throws InterruptedException {
        androidUtility.scrollToElement(registerBtn);
        androidUtility.waitForVisibility(registerBtn);
        androidUtility.click(registerBtn);

    }

    public void clickContinueBtn() {
        androidUtility.waitForVisibility(continueBtn);
        androidUtility.click(continueBtn);
    }


    public void clickCancelBtn() {
        androidUtility.waitForVisibility(cancelBtn);
        androidUtility.click(cancelBtn);
    }


    public void isHomePage() throws InterruptedException {
            androidUtility.scrollToElement(registerBtn);
            androidUtility.waitForVisibility(registerBtn);
    }


    public void clickDarkModeButton(){
        androidUtility.waitForVisibility(darkthemeBtn);
        androidUtility.click(darkthemeBtn);
    }
    public void clickArabicButton(){
        androidUtility.waitForVisibility(ArabicBtn);
        androidUtility.click(ArabicBtn);
    }
    public void clickEnglishButton(){
        androidUtility.waitForVisibility(EnglishBtn);
        androidUtility.click(EnglishBtn);
    }


}
