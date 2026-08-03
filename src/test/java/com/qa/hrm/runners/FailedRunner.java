package com.qa.hrm.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "@target/failed.txt",
		glue = "com.qa.hrm.steps",
		dryRun = false,
		monochrome = true,

		plugin = { "rerun:target/failed.txt" }

)

public class FailedRunner {

}
