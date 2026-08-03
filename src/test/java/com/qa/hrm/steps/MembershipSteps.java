package com.qa.hrm.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.qa.hrm.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MembershipSteps extends CommonMethods {

	@Given("I go to My Info > Memberships")
	public void go_to_memberships() {
		click(dashboardPage.pimMenu);
		click(dashboardPage.myInfoLink);
		wait(5);
		click(dashboardPage.moreDropdown);
		click(dashboardPage.membershipsLink);
	}

	@When("I click the add membership button")
	public void click_add() { click(membershipPage.addBtn); wait(2); }

	@When("I select membership type {string}")
	public void select_type(String type) {
		jsClick(membershipPage.typeDropdown);
		for (WebElement el : membershipPage.typeOptions) {
			if (el.getText().equals(type)) { click(el); break; }
		}
	}

	@When("I select paid by {string}")
	public void select_paid_by(String val) { selectDropdown(membershipPage.paidBy, val); }

	@When("I enter fee {string}")
	public void enter_fee(String fee) { sendText(membershipPage.fee, fee); }

	@When("I select currency {string}")
	public void select_currency(String cur) { selectDropdown(membershipPage.currency, cur); }

	@When("I set commence date to {string}")
	public void commence_date(String date) {
		pickDate(membershipPage.commenceDate, membershipPage.cal1,
				membershipPage.cal1Year, membershipPage.cal1YearOptions,
				membershipPage.cal1Month, membershipPage.cal1MonthOptions,
				membershipPage.cal1Days, date);
	}

	@When("I set renewal date to {string}")
	public void renewal_date(String date) {
		pickDate(membershipPage.renewalDate, membershipPage.cal2,
				membershipPage.cal2Year, membershipPage.cal2YearOptions,
				membershipPage.cal2Month, membershipPage.cal2MonthOptions,
				membershipPage.cal2Days, date);
	}

	@Then("I click the membership Save button")
	public void save_membership() { click(membershipPage.saveBtn); }

	@Then("the membership table should be visible")
	public void table_visible() {
		Assert.assertTrue(membershipPage.table.isDisplayed());
	}

	// ---- helper ----

	private void pickDate(WebElement field, WebElement calIcon,
			WebElement yearInput, java.util.List<WebElement> yearOpts,
			WebElement monthInput, java.util.List<WebElement> monthOpts,
			java.util.List<WebElement> days, String date) {
		String[] parts = date.split("-");
		click(field);
		jsClick(calIcon);

		int yr = Integer.parseInt(parts[0]);
		if (!yearInput.getText().equals(String.valueOf(yr))) {
			click(yearInput);
			click(yearOpts.get(yr));
		}

		int mo = Integer.parseInt(parts[1]);
		if (!monthInput.getText().equals(String.valueOf(mo))) {
			click(monthInput);
			click(monthOpts.get(mo - 1));
		}

		click(days.get(Integer.parseInt(parts[2]) - 1));
	}

}
