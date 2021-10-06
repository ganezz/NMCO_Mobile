package com.iexceed.uiframework.DomainObjects;

import com.iexceed.uiframework.appium.GenericMethods;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.iexceed.uiframework.DomainObjects.ConnectionObjects.driver;
import static com.iexceed.uiframework.DomainObjects.ConnectionObjects.errorfree;

public class IOSUtility {

    GenericMethods genericMethods;
    IOSDriver drive;

    public static Logger log = LogManager.getLogger(IOSUtility.class);

    public By picker = By.xpath("//XCUIElementTypePickerWheel");
    public By countrySearch = By.xpath("//XCUIElementTypeSearchField");
    public By countryList = By.xpath("//XCUIElementTypeStaticText");
    public static By DoneBtn;
    public static By CancelBtn;

    public static By keyboardDone = By.xpath("//*[@label='Done']");;

    public By dropdownList = By.xpath("//XCUIElementTypePicker");

    public String[] month = new String[]{"","January", "February","March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};



    public IOSUtility() {
        genericMethods = new GenericMethods(driver);
        drive = (IOSDriver) driver;
    }


    public void click(By elm){
        genericMethods.click(elm);
    }
    public void yesOrNoButton(By yes,By no,String target){
        if (target.equalsIgnoreCase("yes")){
            genericMethods.click(yes);
        }else {
            genericMethods.click(no);
        }
    }

    public void scroll(String name) throws InterruptedException {
        hideKeyboard();
        RemoteWebElement element = (RemoteWebElement) drive.findElement(By.xpath("//*[@name='" + name + "']"));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("toVisible", "not an empty string");
        drive.executeScript("mobile:scroll", scrollObject);
        Thread.sleep(3000);
    }

    public void scrollToElement(By elm) {
        RemoteWebElement element = (RemoteWebElement) drive.findElement(elm);
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("toVisible", "not an empty string");
        drive.executeScript("mobile:scroll", scrollObject);
    }

    public void reStartApp(WebDriver driver, String bundleId) {
        IOSDriver drive = ((IOSDriver<WebElement>) driver);
        System.out.println("terminate app");
        drive.terminateApp(bundleId);
        System.out.println("Relauch App");
        Map<String, Object> retail = new HashMap<String, Object>();
        retail.put("bundleId", bundleId);
        drive.executeScript("mobile: launchApp", retail);
    }

    public void hideKeyboard() throws InterruptedException {
    try {
        List<WebElement> done = drive.findElements(keyboardDone);
        done.get(0).click();
    }catch (Exception e){
    }

    }

    public void chooseFromList(String country, By backBtn) throws InterruptedException {
        boolean isClicked = false;
        if (!country.isEmpty()) {
            waitForVisibility(countrySearch);
            genericMethods.sendKeys(countrySearch, country);
            Thread.sleep(2000);

                List<WebElement> countries = drive.findElements(countryList);
                for (WebElement count : countries) {
                    try {
                    if (count.getAttribute("label").equalsIgnoreCase(country)) {
                        System.out.println("Element Clicked " + count.getAttribute("label"));
                        count.click();
                        isClicked = true;
                        break;
                    }
                }catch(Exception e){
                }
            }
            if (!isClicked) {
                System.out.println("Country is not found");
                log.info("Country is not found");
                genericMethods.click(backBtn);
            }
        }else {
            System.out.println("Please provide country");
            log.info("Please provide country");
            waitForVisibility(backBtn);
            genericMethods.click(backBtn);
        }
    }

    public void setDate(String dob) throws InterruptedException {
        if (!dob.isEmpty()) {
            String[] date = dob.split("-");
            date[1] = month[Integer.parseInt(date[1])];
            date[0] = String.valueOf(Integer.parseInt(date[0]));
            System.out.println(date[0]);
            try {
                waitForVisibility(picker);
                List<WebElement> wheels = drive.findElements(picker);
                System.out.println("Calener type Date Picker");
                System.out.println(wheels.get(0).getText()+wheels.get(1).getText()+wheels.get(2).getText());
                wheels.get(2).sendKeys(date[2]);
                wheels.get(0).sendKeys(date[1].trim());
                wheels.get(1).sendKeys(date[0].trim());
                if (!(wheels.get(2).getText().equals(date[2]) && wheels.get(0).getText().equals(date[1]) && wheels.get(1).getText().equals(date[0]))){
                    System.out.println("Date should within the limit");
                    log.info("Date should within the limit");
                    genericMethods.click(CancelBtn);
                }else {
                    genericMethods.click(DoneBtn);
                }
            } catch (Exception e) {
                System.out.println("Problem with Date");
            }
        }else{
            System.out.println("Date not provided");
            log.info("Date not provided");
            waitForVisibility(CancelBtn);
            genericMethods.click(CancelBtn);
        }
    }



    public void waitForVisibility(By targetElement) {
            WebDriverWait wait = new WebDriverWait(drive, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));

    }

    public void multiSelection(String sources, By backBtn) throws InterruptedException {
        boolean isClicked = false;
        String list[] = sources.split(",");
        if (!list[0].isEmpty()) {
            waitForVisibility(countrySearch);
            for (String options : list) {
                drive.findElement(countrySearch).clear();
                genericMethods.sendKeys(countrySearch, options);
                //genericMethods.hideKeyboard();
                Thread.sleep(2000);
                List<WebElement> selection = drive.findElements(countryList);

                for (WebElement count : selection) {
                    try {
                        if (count.getAttribute("label").equalsIgnoreCase(options)) {
                            System.out.println("Selection Clicked " + count.getAttribute("label"));
                            count.click();
                            break;
                        }
                    } catch (Exception e) { }
                }
            }
            genericMethods.click(DoneBtn);
        }else {
            System.out.println("Selection is not found");
            log.info("Selection is not found");
            genericMethods.click(backBtn);
        }

    }
    public void checkListContainsValue(String key){
        boolean isClicked = false;
        List<WebElement> countries = drive.findElements(countryList);

        for (WebElement count : countries) {
            try {
                if (count.getAttribute("label").equalsIgnoreCase(key)) {
                    System.out.println("Element is Visible" + count.getAttribute("label"));
                    isClicked = true;
                    break;
                }
            } catch (Exception e) {
            }
        }
        if (!isClicked){
            System.out.println("Not Visible");
        }
    }

    public void dropDownSelect(String selection) {
        waitForVisibility(dropdownList);
        genericMethods.sendKeys(dropdownList,selection);
        System.out.println("Drop down selected");
        genericMethods.click(DoneBtn);
    }

    public void displayMessage(By errorMsg) {
        System.out.println("Message :"+drive.findElement(errorMsg).getText());
        log.info("Message :"+drive.findElement(errorMsg).getText());
    }

    public void limitCheck(By text, String target, String limit){
        if (!target.isEmpty()) {
            errorfree = (drive.findElement(text).getText().length() == target.length()) && (drive.findElement(text).getText().length() <= Integer.parseInt(limit));
        }
    }
    public void limitChecker(String text, String target, String limit){
        if (!target.isEmpty())
            errorfree = (text.length() == target.length()) && (text.length() <= Integer.parseInt(limit));
    }

    public void sendKeys(By userName, String s) {
    }

    public void selectDropDown(By countryCode, String s) {
    }
}
