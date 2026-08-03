package com.qa.hrm.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/",
		glue = "com.qa.hrm.steps",
		dryRun = false,
		monochrome = true,
		tags = "@regression",

		plugin = {
				"html:target/cucumber-report.html",
				"json:target/cucumber.json",
				"rerun:target/failed.txt"
		}

)

public class RegressionRunner {

}
