package com.iexceed.uiframework.DomainObjects;

import com.iexceed.uiframework.appium.GenericMethods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static com.iexceed.uiframework.DomainObjects.ConnectionObjects.driver;
import static com.iexceed.uiframework.DomainObjects.ConnectionObjects.errorfree;


public class AndroidUtility {

    GenericMethods genericMethods;
    AndroidDriver drive;
    public static Logger log = LogManager.getLogger(AndroidUtility.class);

    public By relativelayout = By.xpath("//android.widget.RelativeLayout");

    //Removel of write data
    public By monthview = By.id("com.iexceed.retailonboarding.debug:id/month_navigation_fragment_toggle");
    public By yearList = By.className("android.widget.TextView");
    public By prevmonth = By.id("com.iexceed.retailonboarding.debug:id/month_navigation_previous");
    public By nextmonth = By.id("com.iexceed.retailonboarding.debug:id/month_navigation_next");


    public By DateOk = By.id("com.iexceed.retailonboarding.debug:id/confirm_button");
    public By DateCancel = By.id("com.iexceed.retailonboarding.debug:id/cancel_button");

    public By countrySearch = By.id("com.iexceed.retailonboarding.debug:id/search_edittext");
    public By countryList = By.id("com.iexceed.retailonboarding.debug:id/list_textview");
    public By backBtn = By.id("com.iexceed.retailonboarding.debug:id/search_toolbar_imageView");
    public By DoneBtn = By.id("com.iexceed.retailonboarding.debug:id/search_toolbar_done");


    public AndroidUtility( ){
        genericMethods = new GenericMethods(driver);
        drive = (AndroidDriver) driver;
    }

    public void clearText(By elm){
        drive.findElement(elm).clear();
    }
    public void yesOrNoButton(By yes,By no,String target){
        if (target.equalsIgnoreCase("yes") || target.equalsIgnoreCase("نعم")){
            genericMethods.click(yes);
        }else {
            genericMethods.click(no);
        }
    }
    public void click(By elm) {
        scrollToElement(elm);
        genericMethods.click(elm);
    }
    public String getText(By elm){
        return genericMethods.getText(elm);
    }

    public void sendKeys(By elm,String text)  {
        scrollToElement(elm);
        clearText(elm);
        genericMethods.sendKeys(elm,text);
    }

    public void chooseFromList(String search) {
        boolean errorflag = true;
        waitForVisibility(countrySearch);
        genericMethods.sendKeys(countrySearch,search);
        try {
            waitForVisibility(countryList);
            List<WebElement> countires = driver.findElements(countryList);
            for (WebElement country : countires) {
                if (country.getAttribute("text").equalsIgnoreCase(search)) {
                    System.out.println("List Value clicked :" + country.getAttribute("text"));
                    country.click();
                    errorflag = false;
                    break;
                }
            }
        }catch (Exception e){   }
        if (errorflag){
            System.out.println("Selection Not provided or not proper");
            log.info("Selection Not provided or not proper");
            genericMethods.click(backBtn);
        }
    }

    public void setDate1(String dob) throws InterruptedException {
        boolean clicked = false ;
        if (!dob.isEmpty()) {
            System.out.println(dob);

            String list[] = dob.split(" ");

            waitForVisibility(monthview);
            // year setting
            if (!drive.findElement(monthview).getText().toUpperCase().contains(list[2])) {
                waitForVisibility(monthview);
                genericMethods.click(monthview);
                waitForVisibility(yearList);
                clicked = checkListContainsValue(yearList, list[2]);
            }else {
                clicked = true;
                System.out.println("Year is same");
            }
            if (clicked) {

                //month setting
                String duplicate = "";
                waitForVisibility(monthview);
                while (!(drive.findElement(monthview).getText().toUpperCase().contains("JANUARY") || drive.findElement(monthview).getText().toUpperCase().contains(list[1].toUpperCase()))) {
                    genericMethods.click(prevmonth);
                    if (drive.findElement(monthview).getText().toUpperCase().equals(duplicate)) {
                        duplicate = "";
                        break;
                    }
                    duplicate = drive.findElement(monthview).getText().toUpperCase();
                }
                while (!(drive.findElement(monthview).getText().toUpperCase().contains("DECEMBER") || drive.findElement(monthview).getText().toUpperCase().contains(list[1].toUpperCase()))) {
                    genericMethods.click(nextmonth);
                    if (drive.findElement(monthview).getText().toUpperCase().equals(duplicate)) {
                        duplicate="";
                        break;
                    }
                    duplicate = drive.findElement(monthview).getText().toUpperCase();
                }

                //Date Set
                if (!duplicate.isEmpty() || drive.findElement(monthview).getText().toUpperCase().contains(list[1].toUpperCase()) ) {
                    waitForVisibility(yearList);
                    checkListContainsValue(yearList, list[0]);
                    System.out.println("Date Clicked");
                    genericMethods.click(DateOk);
                }else {
                    System.out.println("Date Should within the limit");
                    log.info("Date Should within the limit");
                    genericMethods.click(DateCancel);
                }
            }else {
                System.out.println("Date Should within the limit");
                log.info("Date Should within the limit");
                genericMethods.click(DateCancel);
            }
        }else {
            System.out.println("Date not provided");
            log.info("Date not provided");
            genericMethods.click(DateCancel);
        }
    }

    public void setDate(String dob) throws InterruptedException {
            waitForVisibility(DateOk);
            genericMethods.click(DateOk);
            System.out.println("Date Ok");
    }

    public  void scroll(String text) throws InterruptedException {
        drive.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
        Thread.sleep(2000);
    }
    public void scrollUp(String text) throws InterruptedException {
        drive.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).setAsVerticalList().scrollForward");
        Thread.sleep(2000);
    }


    public void waitForVisibility(By targetElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
    }
    public void hideKeyboard(){
        //drive.hideKeyboard();
    }
    public void scrollToEnd(){
        int count = 0;
        while (count < 4){
            Dimension size =drive.manage().window().getSize();
            int starty = (int) (size.height * 0.75);
            int endy = (int) (size.height * 0.25);
            int startx = size.width -2;
            TouchAction tc = new TouchAction(driver);
            tc.press(PointOption.point(startx,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startx,endy)).perform();
            count++;
        }
    }

    public void scrollToElement(By elm) {
        System.out.println(driver.findElements(elm).size());
        while (driver.findElements(elm).size()==0){
            Dimension size =drive.manage().window().getSize();
            int starty = (int) (size.height * 0.75);
            int endy = (int) (size.height * 0.25);
            int startx = size.width -2;
            TouchAction tc = new TouchAction(driver);
            tc.press(PointOption.point(startx,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startx,endy)).perform();
        }
    }
    public void scrollToElementup(By elm) throws InterruptedException {
        while (driver.findElements(elm).size()==0){
            Dimension size =drive.manage().window().getSize();
            int starty = (int) (size.height * 0.20);
            int endy = (int) (size.height * 0.70);
            int startx = size.width -2;
            TouchAction tc = new TouchAction(driver);
            tc.press(PointOption.point(startx,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startx,endy)).perform();
        }
    }
    public void multiSelection(String sources) throws InterruptedException {
        boolean isClicked = false;
        String list[] = sources.split(",");
        int x = list.length,j=0;
        if (!list[0].isEmpty()) {
            waitForVisibility(countrySearch);
            for (String options : list) {
                drive.findElement(countrySearch).clear();
                genericMethods.sendKeys(countrySearch, options);
                System.out.println(options);
                //genericMethods.hideKeyboard();
                Thread.sleep(2000);
                List<WebElement> selection = drive.findElements(countryList);

                for (WebElement count : selection) {
                    try {
                        if (count.getAttribute("text").equalsIgnoreCase(options)) {
                            System.out.println("Selection Clicked " + count.getAttribute("text"));
                            count.click();
                            j++;
                            break;
                        }
                    } catch (Exception e) { }
                }
            }
            if (x!=j)
                System.out.println("Not fully clicked");
                log.info("All Seletion Not found");
                genericMethods.click(DoneBtn);
        }else {
            System.out.println("Selection is not found");
            log.info("Seletion Not found");
            waitForVisibility(backBtn);
            genericMethods.click(backBtn);
        }

    }
    public boolean checkListContainsValue(By list,String key) throws InterruptedException {
        boolean isClicked = false;
        List<WebElement> lists = drive.findElements(list);
        for (WebElement target : lists) {
            try {
                System.out.println(target.getAttribute("text"));
                if (target.getAttribute("text").contains(key)) {
                    System.out.println("Key  :"+key);
                    isClicked = true;
                    break;
                }
            } catch (Exception e) {
            }
        }
        return isClicked;
    }

    public void displayMessage(By errorMsg) {
        System.out.println("Message :"+drive.findElement(errorMsg).getText());
        log.info("Message : "+drive.findElement(errorMsg).getText());
    }

    public void limitChecker(String text, String target, String limit){
        if (!target.isEmpty())
            errorfree = (text.length() == target.length()) && (text.length() <= Integer.parseInt(limit));
    }


    public String elementFinder(By screen , By elm){
        String target = null;
        WebElement layout = drive.findElement(screen);
            try {
                    System.out.println(layout.findElement(By.xpath("//android.widget.TextView")).getText());
                    System.out.println(layout.findElement(elm).getText());
                    target = layout.findElement(elm).getText();
                }
            catch (Exception e){

            }
        return target;
    }


    public void selectDropDown(By countryCode, String s) {
    }
    public void scrollToElement(String elementName, boolean scrollDown){
        String listID = ((RemoteWebElement) drive.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")).getId();
        String direction;
        if (scrollDown) {
            direction = "down";
        } else {
            direction = "up";
        }
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        scrollObject.put("element", listID);
        scrollObject.put("text", elementName);
        driver.executeScript("mobile: scrollTo", scrollObject);
    }
}
