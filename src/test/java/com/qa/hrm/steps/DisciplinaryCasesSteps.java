package com.qa.hrm.steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.qa.hrm.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisciplinaryCasesSteps extends CommonMethods {

	@And("I go to Discipline > Disciplinary Cases")
	public void go_to_discipline() {
		click(dashboardPage.disciplineMenu);
		waitForClickability(dashboardPage.disciplinaryCasesLink);
		click(dashboardPage.disciplinaryCasesLink);
	}

	@Then("I click the add button")
	public void click_add() {
		switchToFrame(disciplinaryPage.iframe);
		click(disciplinaryPage.addBtn);
	}

	@Then("the modal should be visible")
	public void modal_visible() {
		Assert.assertTrue(disciplinaryPage.modal.isDisplayed());
	}

	@When("I enter case: employee={string}, name={string}, description={string}")
	public void enter_case(String emp, String name, String desc) {
		if (!emp.isEmpty()) {
			disciplinaryPage.employeeName.sendKeys(emp);
			wait(1);
			disciplinaryPage.autoCompleteDropdown.click();
		}
		if (!name.isEmpty()) sendText(disciplinaryPage.caseName, name);
		if (!desc.isEmpty()) sendText(disciplinaryPage.description, desc);
	}

	@And("I click Save on the case")
	public void save_case() { click(disciplinaryPage.saveBtn); }

	@Then("the case {string} should appear in the table")
	public void case_in_table(String name) {
		boolean found = disciplinaryPage.caseTable.stream().anyMatch(r -> r.getText().contains(name));
		Assert.assertTrue("Case not found: " + name, found);
	}

	@Then("the modal labels should be:")
	public void modal_labels(DataTable table) {
		List<String> expected = new ArrayList<>(table.asList());
		List<String> actual = new ArrayList<>();
		jsClick(disciplinaryPage.addBtn);

		for (WebElement label : disciplinaryPage.labels) {
			String t = label.getText().trim();
			if (!t.isEmpty()) actual.add(t);
		}

		Collections.sort(expected);
		Collections.sort(actual);
		Assert.assertEquals(expected, actual);
	}

	@When("I save the case via footer button")
	public void footer_save() {
		try {
			click(disciplinaryPage.footerSaveBtn);
		} catch (NoSuchElementException e) {
			click(disciplinaryPage.editBtn);
			click(disciplinaryPage.footerSaveBtn);
		}
	}

}
