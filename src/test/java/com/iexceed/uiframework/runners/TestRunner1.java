package com.iexceed.uiframework.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static com.iexceed.uiframework.stepdefinitions.HomePageDefinition.deviceName;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/LegalEntAddNewUser.feature",
        glue = {"com.iexceed.uiframework.stepdefinitions"},
        //tags= "@firstScreen",
        monochrome = true,
        plugin= {"pretty",
                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/jsonReports/cucumber-reports.json","html:target/cucumber-ui-reports.html",
                "rerun:target/failedrerun.txt"
        }
)

public class TestRunner1 extends AbstractTestNGCucumberTests {
        @BeforeTest
        @Parameters({ "device" })
        public void beforeTest(String device) {
                System.out.println("Before test "+device);
                deviceName = device;

        }
}
