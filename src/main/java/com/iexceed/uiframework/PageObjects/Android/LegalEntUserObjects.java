package com.iexceed.uiframework.PageObjects.Android;

import com.iexceed.uiframework.DomainObjects.AndroidUtility;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LegalEntUserObjects {
    AndroidUtility androidUtility;

    public By title = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.view.View[4]/android.widget.ScrollView/android.view.View[1]");
                                   //android.view.View[@content-desc="UserContactDetailsView"]/android.view.View[4]/android.widget.ScrollView/android.view.View/android.view.View[5]

    public By listUser = By.xpath("//android.view.View[@content-desc='UserContactDetailsView']/android.view.View[4]/android.view.View[4]/android.widget.ScrollView/android.view.View");
    public By addNewButton = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.view.View[4]/android.widget.ScrollView/android.view.View[4]/android.view.View[4]");
    public By editButton = By.xpath("//android.widget.ImageView[@content-desc='Edit Icon']");
    public By deleteButton = By.xpath("//android.widget.ImageView[@content-desc='Delete Icon']");
    public By cancelButton = By.xpath("//android.view.View[@content-desc='UserContactDetailsView']/android.view.View[2]/android.view.View[1]");
    public By continueButton = By.xpath("//android.view.View[@content-desc='UserContactDetailsView']/android.view.View[2]/android.view.View[2]");
    public By errorMessage = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.view.View[3]/android.view.View[1]");
    public By errorMessageOk = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.view.View[3]/android.view.View[2]");

    public By userName = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.widget.ScrollView/android.view.View/android.widget.EditText[1]");
    public By errorUserName = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.widget.ScrollView/android.view.View[3]/android.view.View[2]") ;
    public By emailAddress = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.widget.ScrollView/android.view.View/android.widget.EditText[2]");
    public By mobileNumber = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.widget.ScrollView/android.view.View/android.widget.EditText[3]");
    public By countryCode = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.widget.ScrollView/android.view.View/android.view.View/android.view.View[4]");
    public By confirmButton = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.view.View[1]/android.view.View[2]");
    public By cancelNewUser = By.xpath("//android.view.View[@content-desc=\"UserContactDetailsView\"]/android.view.View[1]/android.view.View[1]");
    public By backButton = By.xpath("//android.widget.ImageView[@content-desc='Back Icon']");
    public By prompt = By.xpath("//android.view.View[1]");
    public By yesButton = By.xpath("//android.view.View[4]");
    public By noButton = By.xpath("//android.view.View[3]");


    public LegalEntUserObjects(){
        androidUtility = new AndroidUtility();
    }

    public void isLegalEntUserDetails() {
        androidUtility.waitForVisibility(title);
    }
    public void clickAddNewButton() {
        androidUtility.click(addNewButton);
    }

    public void enterAllUserDetails(String user, String email, String countrycode, String phone, String phoneMinLenght, String phoneMaxLenght) {

        androidUtility.sendKeys(userName,user);
        androidUtility.sendKeys(emailAddress,email);
      //  androidUtility.selectDropDown(countryCode,countrycode);
        androidUtility.sendKeys(mobileNumber,phone);
    }

    public void clickConfirmButton() {
        androidUtility.click(confirmButton);
    }

    public void checkUserListed(String userName) throws InterruptedException {
        if (androidUtility.checkListContainsValue(listUser,userName)){
            System.out.println("Available");
        }else {
            System.out.println("Not Available");
        }
    }

    public void clickEditButton() {
        androidUtility.click(editButton);
    }

    public void isAddNewScreen() {
        androidUtility.waitForVisibility(userName);
    }

    public void isPromptDisplayed() {
        androidUtility.waitForVisibility(yesButton);
    }

    public void clickYesButton() {
        androidUtility.click(yesButton);
    }

    public void clickNoButton() {
        androidUtility.click(noButton);
    }

    public void clickCancelButton() {
        androidUtility.click(cancelButton);
    }

    public void clickDeleteButton() {
        androidUtility.click(deleteButton);
    }

    public void enterInvalidUserName() {
    }

    public void isProperErrorMessage() {
        androidUtility.waitForVisibility(errorMessage);
        System.out.println(androidUtility.getText(errorMessage));
        androidUtility.click(errorMessageOk);
    }

    public void enterInvalidEmailAddress() {
    }

    public void clickCountryCode() {
        androidUtility.sendKeys(countryCode,"+91");
    }

    public void enterInvalidMobileNumber() {
    }

    public void isProperErrorMessageOnUser(String result, String expectedMessage) {
        if (result.equalsIgnoreCase("fail")){
            try {
                  androidUtility.waitForVisibility(errorUserName);
            }catch (Exception e){
                Assert.fail("Test Case Failed");
            }
            Assert.assertEquals(expectedMessage,androidUtility.getText(errorUserName));
        }
    }

    public void isProperErrorMessageOnEmail(String result, String expectedMessage) {
        if (result.equalsIgnoreCase("fail")){
            try {
                androidUtility.waitForVisibility(errorUserName);
            }catch (Exception e){
                Assert.fail("Test Case Failed");
            }
            Assert.assertEquals(expectedMessage, androidUtility.getText(errorUserName));
        }
    }

    public void isProperErrorMessageOnMobile(String result, String expectedMessage) {

        if (result.equalsIgnoreCase("fail")){
            try {
                androidUtility.waitForVisibility(errorUserName);
            }catch (Exception e){
                Assert.fail("Test Case Failed");
            }
            System.out.println(expectedMessage);
            Assert.assertEquals(expectedMessage,androidUtility.getText(errorUserName));
        }
    }

    public void checkUserNotListed(String userName) throws InterruptedException {
        if (androidUtility.checkListContainsValue(listUser,userName)){
            System.out.println("Available");
        }else {
            System.out.println("Not Available");
        }
    }

    public void clickCancelNewUser() {
        androidUtility.click(cancelNewUser);
    }
}
