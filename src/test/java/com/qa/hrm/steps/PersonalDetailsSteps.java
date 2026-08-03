package com.qa.hrm.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.hrm.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalDetailsSteps extends CommonMethods {

	@When("I fill all personal details: otherId={string}, dob={string}, marital={string}, gender={string}, nationality={string}, license={string}, licExp={string}, nickname={string}, military={string}, smoker={string}")
	public void fill_all(String otherId, String dob, String marital, String gender,
			String nationality, String license, String licExp, String nickname,
			String military, String smoker) {

		sendText(personalDetailsPage.otherId, otherId);

		// DOB via calendar picker
		String[] dobParts = dob.split("-");
		click(personalDetailsPage.calendarIcon);
		jsClick(personalDetailsPage.yearPicker);
		selectDropdownByClicking(personalDetailsPage.yearPicker, personalDetailsPage.yearOptions, dobParts[0]);
		int m = Integer.parseInt(dobParts[1]);
		click(personalDetailsPage.monthPicker);
		click(personalDetailsPage.monthOptions.get(m - 1));
		selectCalendarDate(personalDetailsPage.dayCells, dobParts[2]);

		selectDropdownByClicking(personalDetailsPage.maritalStatusInput, personalDetailsPage.maritalStatusOptions, marital);
		selectDropdownByClicking(personalDetailsPage.genderInput, personalDetailsPage.genderOptions, gender);

		// nationality
		click(personalDetailsPage.nationalityInput);
		for (WebElement opt : personalDetailsPage.nationalityOptions) {
			if (opt.getText().equalsIgnoreCase(nationality)) { jsClick(opt); break; }
		}

		sendText(personalDetailsPage.licenseNo, license);

		// license expiration
		String[] lic = licExp.split("-");
		click(personalDetailsPage.licExpIcon);
		selectDropdownByClicking(personalDetailsPage.licYearInput, personalDetailsPage.licYearOptions, lic[0]);
		int lm = Integer.parseInt(lic[1]);
		click(personalDetailsPage.licMonthInput);
		click(personalDetailsPage.licMonthOptions.get(lm - 1));
		selectCalendarDate(personalDetailsPage.licDayCells, lic[2]);

		sendText(personalDetailsPage.nickName, nickname);
		sendText(personalDetailsPage.militaryService, military);

		if (smoker.equalsIgnoreCase("yes") && !personalDetailsPage.smokerCheckbox.isSelected())
			personalDetailsPage.smokerCheckbox.click();
		wait(1);
	}

	@When("I click the Personal Details Save button")
	public void save_details() {
		waitForClickability(personalDetailsPage.saveBtn);
		jsClick(personalDetailsPage.saveBtn);
		wait(5);
	}

	@Then("I should see {string} toast")
	public void see_toast(String msg) {
		Assert.assertTrue(personalDetailsPage.toastMessage.isDisplayed());
	}

	@When("I enter an invalid birthdate {string}")
	public void invalid_bday(String bday) {
		sendText(personalDetailsPage.birthDateInput, bday + Keys.ENTER);
	}

	@Then("I should see the date format error")
	public void date_error() {
		Assert.assertEquals("Expected format: D, dd M yyyy", personalDetailsPage.dateFormatError.getText());
	}

	@When("I enter a license number {string} longer than 30 chars")
	public void long_license(String lic) {
		sendText(personalDetailsPage.licenseNo, lic);
	}

	@Then("I should see the character limit error")
	public void char_limit_error() {
		Assert.assertEquals("Should not exceed 30 characters", personalDetailsPage.charLimitError.getText());
	}

	// ---- modify existing details ----

	@Then("I modify details: license={string}, licExp={string}, smoker={string}, gender={string}, nationality={string}")
	public void modify_details(String license, String licExp, String smoker, String gender, String nationality) {
		sendText(personalDetailsPage.licenseNo, license);

		String[] lic = licExp.split("-");
		click(personalDetailsPage.licExpIcon);
		selectDropdownByClicking(personalDetailsPage.licYearInput, personalDetailsPage.licYearOptions, lic[0]);
		int lm = Integer.parseInt(lic[1]);
		click(personalDetailsPage.licMonthInput);
		click(personalDetailsPage.licMonthOptions.get(lm - 1));
		selectCalendarDate(personalDetailsPage.licDayCells, lic[2]);

		selectDropdownByClicking(personalDetailsPage.genderInput, personalDetailsPage.genderOptions, gender);
		if (smoker.equalsIgnoreCase("yes")) click(personalDetailsPage.smokerCheckbox);

		click(personalDetailsPage.nationalityInput);
		for (WebElement opt : personalDetailsPage.nationalityOptions) {
			if (opt.getText().equalsIgnoreCase(nationality)) { jsClick(opt); break; }
		}

		// ethnicity (hardcoded for demo)
		click(personalDetailsPage.ethnicityInput);
		for (WebElement opt : personalDetailsPage.ethnicityOptions) {
			if (opt.getText().equalsIgnoreCase("White")) { jsClick(opt); break; }
		}
	}

}
