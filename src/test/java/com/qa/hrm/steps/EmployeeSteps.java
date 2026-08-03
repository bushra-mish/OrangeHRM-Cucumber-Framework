package com.qa.hrm.steps;

import java.util.Map;

import com.qa.hrm.utils.CommonMethods;
import com.qa.hrm.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps extends CommonMethods {

	@Given("I am on the Add Employee page")
	public void go_to_add_employee() { goToAddEmployee(); }

	@When("I enter first name {string} and last name {string}")
	public void enter_names(String first, String last) { fillName(first, last); }

	@When("I enter first name {string}, middle name {string}, and last name {string}")
	public void enter_full_name(String first, String middle, String last) { fillName(first, middle, last); }

	@When("I select location {string}")
	public void select_location(String loc) { selectDropdown(addEmployeePage.location, loc); }

	@When("I click Save")
	public void click_save() { click(addEmployeePage.saveBtn); }

	@Then("the employee {string} should be saved")
	public void verify_saved(String expected) { assertNameVisible(expected); }

	// ---- login details ----

	@When("I toggle Create Login Details")
	public void toggle_login() { jsClick(addEmployeePage.loginToggle); }

	@When("I enter username {string} and password {string}")
	public void enter_creds(String user, String pass) {
		sendText(addEmployeePage.username, user);
		sendText(addEmployeePage.password, pass);
		sendText(addEmployeePage.confirmPassword, pass);
	}

	// ---- data table ----

	@When("I add the following employees:")
	public void add_from_datatable(DataTable table) {
		for (Map<String, String> row : table.asMaps()) {
			fillName(row.get("FirstName"), row.get("LastName"));
			click(addEmployeePage.saveBtn);
			assertNameVisible(row.get("FirstName") + " " + row.get("LastName"));
			wait(1);
			goToAddEmployee();
		}
	}

	// ---- excel ----

	@When("I add employees from the {string} Excel sheet")
	public void add_from_excel(String sheet) {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/TestData.xlsx";
		for (Map<String, String> row : ExcelUtility.sheetToList(path, sheet)) {
			fillName(row.get("FirstName"), row.get("LastName"));
			selectDropdown(addEmployeePage.location, row.get("Location"));
			click(addEmployeePage.saveBtn);
			assertNameVisible(row.get("FirstName") + " " + row.get("LastName"));
			goToAddEmployee();
		}
	}

}
