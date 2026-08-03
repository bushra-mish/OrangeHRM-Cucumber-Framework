package com.qa.hrm.steps;

import org.junit.Assert;

import com.qa.hrm.utils.CommonMethods;
import com.qa.hrm.utils.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

	@When("I enter a valid username")
	public void enter_valid_username() {
		sendText(loginPage.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void enter_valid_password() {
		sendText(loginPage.password, ConfigsReader.getProperty("password"));
	}

	@When("I click the login button")
	public void click_login() { click(loginPage.loginBtn); }

	@Then("I should see the dashboard")
	public void see_dashboard() {
		Assert.assertTrue(dashboardPage.logo.isDisplayed());
	}

	@When("I enter {string} as username")
	public void enter_username(String u) { sendText(loginPage.username, u); }

	@When("I enter {string} as password")
	public void enter_password(String p) { sendText(loginPage.password, p); }

	@Then("I should see {string}")
	public void see_error(String expected) {
		Assert.assertTrue(loginPage.toastMessage.isDisplayed());
	}

	@Then("the logo should be displayed")
	public void logo_displayed() {
		Assert.assertTrue(loginPage.logo.isDisplayed());
	}

}
