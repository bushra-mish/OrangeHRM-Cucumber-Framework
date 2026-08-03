package com.qa.hrm.steps;

import com.qa.hrm.testbase.BaseClass;
import com.qa.hrm.utils.CommonMethods;
import com.qa.hrm.utils.VideoRecorder;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

	@Before
	public void start(Scenario scenario) {
		BaseClass.setUp();
		VideoRecorder.start(scenario.getName());
	}

	@After
	public void end(Scenario scenario) {
		String folder = scenario.isFailed() ? "failed/" : "passed/";
		scenario.attach(takeScreenshot(folder + scenario.getName()), "image/png", scenario.getName());
		VideoRecorder.stop();
		BaseClass.tearDown();
	}

}
