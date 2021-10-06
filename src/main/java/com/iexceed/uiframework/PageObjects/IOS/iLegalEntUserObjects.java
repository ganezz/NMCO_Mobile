package com.iexceed.uiframework.PageObjects.IOS;

import com.iexceed.uiframework.DomainObjects.IOSUtility;
import org.openqa.selenium.By;


public class iLegalEntUserObjects {

    IOSUtility iosUtility;

    public By title = By.xpath("//XCUIElementTypeStaticText[@name='Entity Details']");

    public By newUserButton =  By.xpath("//XCUIElementTypeButton[@name='Add a New User Button']");

    public By listUser;
    public By addNewButton;
    public By editButton;
    public By deleteButton;
    public By cancelButton;
    public By continueButton;
    public By errorMessage;

    public By userName;
    public By emailAddress;
    public By mobileNumber;
    public By countryCode;
    public By confirmButton;
    public By prompt;
    public By yesButton;
    public By noButton;


    public iLegalEntUserObjects(){
        iosUtility = new IOSUtility();
    }

    public void isLegalEntUserDetails() {
        iosUtility.waitForVisibility(title);
    }
    public void clickAddNewButton() {
        iosUtility.click(addNewButton);
    }

    public void enterAllUserDetails() {
        iosUtility.sendKeys(userName,"");
        iosUtility.sendKeys(emailAddress,"");
        iosUtility.selectDropDown(countryCode,"");
        iosUtility.sendKeys(mobileNumber,"");
    }

    public void clickConfirmButton() {
        iosUtility.click(confirmButton);
    }

    public void checkUserListed() throws InterruptedException {
        iosUtility.checkListContainsValue("");
    }

    public void clickEditButton() {
        iosUtility.click(editButton);
    }

    public void isAddNewScreen() {
        iosUtility.waitForVisibility(userName);
    }

    public void isPromptDisplayed() {
        iosUtility.waitForVisibility(prompt);
    }

    public void clickYesButton() {
        iosUtility.click(yesButton);
    }

    public void clickNoButton() {
        iosUtility.click(noButton);
    }

    public void clickCancelButton() {
        iosUtility.click(cancelButton);
    }

    public void clickDeleteButton() {
        iosUtility.click(deleteButton);
    }

    public void enterInvalidUserName() {
    }

    public void isProperErrorMessage() {
        iosUtility.waitForVisibility(errorMessage);
    }

    public void enterInvalidEmailAddress() {
    }

    public void clickCountryCode() {
        iosUtility.selectDropDown(countryCode,"");
    }

    public void enterInvalidMobileNumber() {

    }

    public void clickCancelNewUser() {
    }
}
