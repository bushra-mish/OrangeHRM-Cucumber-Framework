package com.qa.hrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.hrm.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EmployeeListSteps extends CommonMethods {

	@Given("I navigate to the Employee List page")
	public void go_to_list() { goToEmployeeList(); }

	@Then("the table should show {int} rows")
	public void row_count(int expected) {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("Row count: " + rows.size());
	}

	@Then("the table should have these columns:")
	public void columns(DataTable table) {
		List<String> expected = table.asList();
		WebElement tbl = driver.findElement(By.id("employeeListTable"));
		List<String> actual = new ArrayList<>();

		for (WebElement th : tbl.findElements(By.tagName("th"))) {
			String text = th.getText().trim().replace("arrow_upward", "").replace("↑", "").trim();
			if (!text.isEmpty()) actual.add(text);
		}

		Assert.assertEquals(expected, actual);
	}

}
