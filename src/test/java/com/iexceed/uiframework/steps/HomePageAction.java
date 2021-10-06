package com.iexceed.uiframework.steps;

import com.iexceed.uiframework.PageObjects.Android.HomePageObjects;
import com.iexceed.uiframework.PageObjects.IOS.iHomePageObjects;

public class HomePageAction {

    HomePageObjects homePageObjects;
    iHomePageObjects ihomePageObjects;
    public String platform;

    public HomePageAction(String platform) {
        this.platform = platform;
    }

    public void IsHomePage() throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")){
            ihomePageObjects = new iHomePageObjects();
            ihomePageObjects.isHomeScreen();
        }else {
            homePageObjects = new HomePageObjects();
            homePageObjects.isHomePage();
        }

    }


    public void clickEnglishButton() {
        if (platform.equalsIgnoreCase("ios")){
            ihomePageObjects.clickEnglishButton();
        }else {
            homePageObjects.clickEnglishButton();
        }
    }

    public void clickArabicButton() {
        if (platform.equalsIgnoreCase("ios")){
            ihomePageObjects.clickArabicButton();
        }else {
            homePageObjects.clickArabicButton();
        }
    }

    public void clickRegisterButton(String language) throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")){
                ihomePageObjects.clickRegisterButton(language);
        }else {
            homePageObjects.clickRegisterBtn();
        }
    }

    public void clickDarkThemeButton() throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")){
            ihomePageObjects.clickDarkModeButton();
        }else {
            homePageObjects.clickDarkModeButton();
        }
    }

    public void clickContinueButton() throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")){
            ihomePageObjects.clickContinueBtn();
        }else {
            homePageObjects.clickContinueBtn();
        }

    }
    public void clickCancelbutton() {
        if (platform.equalsIgnoreCase("ios")) {
            ihomePageObjects.clickCancelBtn();
        }else {
            homePageObjects.clickCancelBtn();
        }
    }
}
