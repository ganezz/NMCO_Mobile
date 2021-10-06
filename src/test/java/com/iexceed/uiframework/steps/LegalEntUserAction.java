package com.iexceed.uiframework.steps;

import com.iexceed.uiframework.PageObjects.Android.*;
import com.iexceed.uiframework.PageObjects.IOS.iLegalEntUserObjects;

import java.util.Map;

public class LegalEntUserAction {
    private String platform;
    iLegalEntUserObjects iLegalEntUserObject;
    LegalEntUserObjects legalEntUserObjects;

    public LegalEntUserAction(String platform){
        this.platform = platform;
    }

    public void isLegalEntityUserDetails() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject = new iLegalEntUserObjects();
            iLegalEntUserObject.isLegalEntUserDetails();
        }else {
            legalEntUserObjects = new LegalEntUserObjects();
            legalEntUserObjects.isLegalEntUserDetails();
        }

    }

    public void clickAddNewButton() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickAddNewButton();
        }else {
            legalEntUserObjects.clickAddNewButton();
        }
    }

    public void enterAllUserDetails(Map<String, String> datalist) {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.enterAllUserDetails();
        }else {
            legalEntUserObjects.enterAllUserDetails(datalist.get("ent.UserName"),datalist.get("ent.Email"),datalist.get("ent.CountryCode"),datalist.get("ent.MobileNumber"),datalist.get("ent.CountryCode.minlenght"),datalist.get("ent.CountryCode.maxlenght"));
        }
    }

    public void clickConfirmButton() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickConfirmButton();
        }else {
            legalEntUserObjects.clickConfirmButton();
        }
    }

    public void isUserListed(String userName) throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.checkUserListed();
        }else {
            legalEntUserObjects.checkUserListed(userName);
        }
    }
    public void isUserNotListed(String userName) throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.checkUserListed();
        }else {
            legalEntUserObjects.checkUserNotListed(userName);
        }
    }

    public void clickEditButton() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickEditButton();
        }else {
            legalEntUserObjects.clickEditButton();
        }
    }

    public void isAddNewScreen() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.isAddNewScreen();
        }else {
            legalEntUserObjects.isAddNewScreen();
        }
    }

    public void isPromptConfirmation() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.isPromptDisplayed();
        }else {
            legalEntUserObjects.isPromptDisplayed();
        }
    }

    public void clickYesButton() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickYesButton();
        }else {
            legalEntUserObjects.clickYesButton();
        }
    }

    public void clickNoButton() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickNoButton();
        }else {
            legalEntUserObjects.clickNoButton();
        }
    }

    public void clickCancelButton() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickCancelButton();
        }else {
            legalEntUserObjects.clickCancelButton();
        }
    }

    public void clickDeleteButton() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickDeleteButton();
        }else {
            legalEntUserObjects.clickDeleteButton();
        }
    }

    public void enterInvalidName() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.enterInvalidUserName();
        }else {
            legalEntUserObjects.enterInvalidUserName();
        }
    }

    public void isProperErrorMessageOnUser(String result, String expectedMessage) {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.isProperErrorMessage();
        }else {
            legalEntUserObjects.isProperErrorMessageOnUser(result,expectedMessage);
        }
    }
    public void isProperErrorMessageOnEmail(String result, String expectedMessage) {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.isProperErrorMessage();
        }else {
            legalEntUserObjects.isProperErrorMessageOnEmail(result,expectedMessage);
        }
    }
    public void isProperErrorMessageOnMobile(String result, String expectedMessage) {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.isProperErrorMessage();
        }else {
            legalEntUserObjects.isProperErrorMessageOnMobile(result,expectedMessage);
        }
    }

    public void inputInvalidEmailAddress() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.enterInvalidEmailAddress();
        }else {
            legalEntUserObjects.enterInvalidEmailAddress();
        }
    }

    public void clickCountryCode() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickCountryCode();
        }else {
            legalEntUserObjects.clickCountryCode();
        }
    }

    public void inputInvalidMobileNumber() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.enterInvalidMobileNumber();
        }else {
            legalEntUserObjects.enterInvalidMobileNumber();
        }
    }

    public void isMessageDisplay() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.isProperErrorMessage();
        }else {
            legalEntUserObjects.isProperErrorMessage();
        }
    }

    public void clickCancelNewUser() {
        if (platform.equalsIgnoreCase("ios")){
            iLegalEntUserObject.clickCancelNewUser();
        }else {
            legalEntUserObjects.clickCancelNewUser();
        }
    }
}
