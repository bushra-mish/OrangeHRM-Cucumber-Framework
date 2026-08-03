package com.qa.hrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.qa.hrm.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashboardSteps extends CommonMethods {

	@Given("I am logged in")
	public void logged_in() { login(); }

	@Then("the dashboard menu should contain:")
	public void menu_items(DataTable table) {
		List<String> expected = table.asList();
		List<String> actual = new ArrayList<>();

		click(dashboardPage.moreMenuItem);
		wait(3);

		for (WebElement el : dashboardPage.menuItems) {
			actual.add(el.getText());
		}

		Assert.assertEquals(expected, actual);
	}

}
