package com.iexceed.uiframework.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = {"com.iexceed.uiframework.stepdefinitions"},
        tags= "@retest",
        monochrome = true,
        plugin= {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/jsonReports/cucumber-reports.json","html:target/cucumber-ui-reports.html",
                "rerun:target/failedrerun.txt"
        }
)
public class TestRunner {
        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true)
        public void setUpClass() throws Exception {
                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @Test(dataProvider = "features")
        public void feature(PickleWrapper eventwrapper, FeatureWrapper cucumberFeature) throws Throwable {
                //testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
                testNGCucumberRunner.runScenario(eventwrapper.getPickle());
        }

        @DataProvider//(parallel=true)
        public Object[][] features() {
                // return testNGCucumberRunner.provideFeatures();
                return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() throws Exception {
                testNGCucumberRunner.finish();
        }

}

