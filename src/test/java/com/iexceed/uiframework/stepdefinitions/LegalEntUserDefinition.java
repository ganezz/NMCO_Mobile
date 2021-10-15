package com.iexceed.uiframework.stepdefinitions;

import com.iexceed.uiframework.steps.LegalEntUserAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.iexceed.uiframework.stepdefinitions.HomePageDefinition.datalist;
import static com.iexceed.uiframework.stepdefinitions.HomePageDefinition.deviceConfig;

public class LegalEntUserDefinition {
    LegalEntUserAction legalEntUserAction;

    @Then("user will landed on Legal Entity User Details")
    public void app_will_change_to_dark_theme() throws InterruptedException {
        legalEntUserAction = new LegalEntUserAction(deviceConfig.get("platform").toLowerCase());
        legalEntUserAction.isLegalEntityUserDetails();
        System.out.println("User landed on Legal Entity User Details");
    }

    @When("clicks + Add A New User button")
    public void clicks_add_a_new_user_button() throws InterruptedException {
        legalEntUserAction.clickAddNewButton();
    }


    @Then("user will land on User Contact Details")
    public void user_will_land_on_user_contact_details() {
        legalEntUserAction.isLegalEntityUserDetails();
    }

    @Then("user will be listed on the User list")
    public void user_will_be_listed_on_the_user_list() throws InterruptedException {
        legalEntUserAction.isUserListed(datalist.get("ent.UserName"));
    }
    @When("clicks Edit button on the user list")
    public void clicks_edit_button_on_the_user_list() {
        legalEntUserAction.clickEditButton();
    }

    @When("user will landed on the New User screen")
    public void user_will_landed_on_the_new_user_screen() {
        legalEntUserAction.isAddNewScreen();
    }
    @When("clicks Edit button")
    public void clicks_edit_button() {
        legalEntUserAction.clickEditButton();
    }
    @Then("user will prompt to ask about confirmation")
    public void user_will_prompt_to_ask_about_confirmation() {
        legalEntUserAction.isPromptConfirmation();
    }

    @Then("clicks Yes button")
    public void clicks_yes_button() {
        legalEntUserAction.clickYesButton();
    }

    @Then("user will be deleted and removed from the list")
    public void user_will_be_deleted_and_removed_from_the_list() throws InterruptedException {
        legalEntUserAction.isUserNotListed(datalist.get("ent.UserName"));
    }
    @Then("clicks No button")
    public void clicks_no_button() {
        legalEntUserAction.clickNoButton();
    }

    @Then("user will be listed on the list")
    public void user_will_be_listed_on_the_list() throws InterruptedException {
        legalEntUserAction.isUserListed(datalist.get("ent.UserName"));
    }
    @When("clicks Cancel button")
    public void clicks_cancel_button() {
        legalEntUserAction.clickCancelButton();
    }
    @When("clicks Cancel in New User")
    public void clicks_cancel_in_new_user() {
        legalEntUserAction.clickCancelNewUser();
    }
    @When("clicks Delete button")
    public void clicks_delete_button() {
        legalEntUserAction.clickDeleteButton();
    }

    //in Dash Board has developed the Dashboard will change
    @Then("user will land on Dashboard screen")
    public void user_will_land_on_dashboard_screen() {
      //  legalEntUserAction.isLegalEntityUserDetails();
    }
    @Then("user will stay on User Contact Details screen")
    public void user_will_stay_on_user_contact_details_screen() {
        legalEntUserAction.isLegalEntityUserDetails();
    }
    @When("enters all details in Add A New User screen")
    public void enters_all_details_in_add_a_new_user_screen() throws InterruptedException {
        legalEntUserAction.enterAllUserDetails(datalist);
    }

    @When("user input invalid Name")
    public void user_input_invalid_name() {
        System.out.println(datalist.get("ent.UserName"));
        legalEntUserAction.enterInvalidName();
    }

    @When("clicks Confirm button")
    public void clicks_confirm_button() {
        legalEntUserAction.clickConfirmButton();
    }

    @Then("proper error message should display under User Name field")
    public void proper_error_message_should_display_under_user_name() {
        legalEntUserAction.isProperErrorMessageOnUser(datalist.get("result"),datalist.get("expectedMessage"),datalist.get("ent.UserName"));
    }
    @Then("proper error message should display under Email field")
    public void proper_error_message_should_display_under_email() {
        legalEntUserAction.isProperErrorMessageOnEmail(datalist.get("result"),datalist.get("expectedMessage"),datalist.get("ent.Email"));
    }
    @Then("proper error message should display under Mobile field")
    public void proper_error_message_should_display_under_mobile() {
        legalEntUserAction.isProperErrorMessageOnMobile(datalist.get("result"),datalist.get("expectedMessage"),datalist.get("ent.MobileNumber"));
    }
    @When("user input invalid Email Address")
    public void user_input_invalid_email_address() {
        System.out.println(datalist.get("ent.Email"));
        legalEntUserAction.inputInvalidEmailAddress();
    }
    @When("user selects Country Code")
    public void user_selects_country_code() {
        legalEntUserAction.clickCountryCode();
    }
    @When("user input invalid Mobile Number")
    public void user_input_invalid_mobile_number() {
        System.out.println(datalist.get("ent.MobileNumber"));
        legalEntUserAction.inputInvalidMobileNumber();
    }
    @Then("user will stay on Add A New User screen")
    public void user_will_stay_on_add_a_new_user_screen() {
        legalEntUserAction.isAddNewScreen();
    }
    @Then("user given details will display on User Contact Details screen")
    public void user_given_details_will_display_on_user_contact_details_screen() throws InterruptedException {
        legalEntUserAction.isUserListed(datalist.get("ent.UserName"));
    }

    @Then("message will be appear on the bottom")
    public void a_message_appears_as_user_has_been_successfully_added() {
        legalEntUserAction.isMessageDisplay();
    }
    @And("user fills all new user details")
    public void user_fills_all_user_details() throws InterruptedException {
        legalEntUserAction.isAddNewScreen();
        legalEntUserAction.enterAllUserDetails(datalist);
        legalEntUserAction.clickConfirmButton();
        legalEntUserAction.isMessageDisplay();
    }

}
