package com.iexceed.uiframework.PageObjects.IOS;

import com.iexceed.uiframework.DomainObjects.IOSUtility;
import org.openqa.selenium.By;

public class iHomePageObjects {


    IOSUtility iosUtility;


    public By registerBtn = By.xpath("//XCUIElementTypeStaticText[@name='Application Details']");

    public By arabicBtn = By.xpath("//XCUIElementTypeStaticText[@name='Arabic']");
    public By englishBtn = By.xpath("//XCUIElementTypeStaticText[@name='English']");

    public By darkMode = By.xpath("//XCUIElementTypeSwitch[@name='DarkModeSwitch']");
    public By menuBtn = By.xpath("//XCUIElementTypeButton[@name='MenuButton']");

    
    public By cancelBtn = By.xpath("//XCUIElementTypeButton[@name='cancelButton']");
    public By cancelBtn1 = By.xpath("//XCUIElementTypeButton[@name='CancelButton']");
    public By continueBtn = By.xpath("//XCUIElementTypeStaticText[@name='Continue']");
    public By continueBtn1 = By.xpath("//XCUIElementTypeButton[@name='ContinueButton']");



    public iHomePageObjects(){
        iosUtility = new IOSUtility();
    }

    public void clickRegisterButton(String language) {
            iosUtility.scrollToElement(registerBtn);
            iosUtility.waitForVisibility(registerBtn);
            iosUtility.click(registerBtn);
    }

    public void isHomeScreen() {
            iosUtility.waitForVisibility(registerBtn);
    }


    public void clickDarkModeButton() throws InterruptedException {
        iosUtility.waitForVisibility(darkMode);
        iosUtility.click(darkMode);
    }
    public void clickArabicButton(){
        iosUtility.waitForVisibility(arabicBtn);
        iosUtility.click(arabicBtn);
    }
    public void clickEnglishButton(){
        iosUtility.waitForVisibility(englishBtn);
        iosUtility.click(englishBtn);
    }
    public void clickContinueBtn() throws InterruptedException {
        try {
            iosUtility.waitForVisibility(continueBtn1);
            iosUtility.click(continueBtn1);
        }catch (Exception e){
            iosUtility.waitForVisibility(continueBtn);
            iosUtility.click(continueBtn);
        }
    }

    public void clickCancelBtn() {
        try {
            iosUtility.waitForVisibility(cancelBtn1);
            iosUtility.click(cancelBtn1);
        }catch (Exception e){
            iosUtility.waitForVisibility(cancelBtn);
            iosUtility.click(cancelBtn);
        }
    }


}
