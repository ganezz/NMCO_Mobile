package com.iexceed.uiframework.stepdefinitions;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.HomePageAction;
import com.iexceed.uiframework.utilites.readexcel.ExcelHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static com.iexceed.uiframework.DomainObjects.ConnectionObjects.errorfree;

public class HomePageDefinition extends TestBase {
    HomePageAction homePageAction;
    public static Map<String, String> datalist;
    Capabilities capabilities;
    public static Map<String, String> deviceConfig;
    public static Logger log = LogManager.getLogger(HomePageDefinition.class);


    @Given("user opens the App (.+)$")
    public void user_open_the_app_in_device(String testcase) throws Exception {
        capabilities = new Capabilities();
        errorfree=true;
        deviceConfig = ExcelHandler.getTestDataInMap(props.getProperty("appSheetPath"), props.getProperty("deviceSheetName"),props.getProperty(testcase));
        System.out.println("User Opens Application in "+deviceConfig.get("deviceName").toUpperCase());
        capabilities.setCapabilities(deviceConfig,props.getProperty("targetCompanyName"),props.getProperty("trustCompanyName"),props.getProperty("trustBtn"),props.getProperty("isResigned"));
        log.info("\n");
        log.info("User Opens Application in "+deviceConfig.get("deviceName").toUpperCase());
        log.info("Orientation IN : "+deviceConfig.get("orientation").toUpperCase());
    }


    @When("user in Home screen (.+)$")
    public void user_in_home_screen(String testcase) throws Exception {
        datalist = ExcelHandler.getTestDataInMap(props.getProperty("appSheetPath"), props.getProperty("appSheetName"),testcase);
        System.out.println(" User Enter the Details in Page Test Case :"+datalist.get("TestCaseName"));
        homePageAction = new HomePageAction(deviceConfig.get("platform").toLowerCase());
        homePageAction.IsHomePage();
        System.out.println("User in Home Screen");
        log.info("Test Case :"+datalist.get("TestCaseName"));
        log.info("User in Home page");
    }


    @When("clicks English Button")
    public void click_english() {
        homePageAction.clickEnglishButton();
        System.out.println("Choosing English");
        log.info("Choosing English");
    }
    @When("clicks Arabic Button")
    public void click_arabic() {
        homePageAction.clickArabicButton();
        System.out.println("Choosing Arabic");
        log.info("Choosing Arabic");
    }
    @When("clicks Register Button")
    public void click_register() throws InterruptedException {
        homePageAction.clickRegisterButton(datalist.get("language"));
        System.out.println("Clicking Register Button");
        log.info("Clicking Register Button");
    }
    @When("user clicks Dark theme")
    public void user_click_dark_theme() throws InterruptedException {
        homePageAction.clickDarkThemeButton();
        System.out.println("Choose Dark Theme");
        log.info("Choose Dark Theme");
    }
    @Then("app language change to English")
    public void app_language_change_to_english() {
        System.out.println("Application Language change to English");
        log.info("Application Language change to English");
    }
    @Then("app language change to Arabic")
    public void app_language_change_to_arabic() {
        System.out.println("Application Language change to Arabic");
        log.info("Application Language change to Arabic");
    }

    @Then("app will change to Dark theme")
    public void app_will_change_to_dark_theme() {
        System.out.println("Application change to Dark theme");
        log.info("Application change to Dark theme");
    }

    @When("clicks Continue")
    public void click_continue() throws InterruptedException {
        homePageAction.clickContinueButton();
        System.out.println("User Clicking Continue Button");
        log.info("User Clicking Continue Button");
    }
    @Given("clicks Cancel")
    public void click_cancel() {
        System.out.println("Clicking Cancel");
        homePageAction.clickCancelbutton();
        log.info("Clicking Cancel");
    }
    @Then("user will landed on Home screen")
    public void user_will_landed_on_home_screen() throws InterruptedException {
        System.out.println("User in Home Screen");
        homePageAction.IsHomePage();
        log.info("User in Home Screen ");

    }


}
