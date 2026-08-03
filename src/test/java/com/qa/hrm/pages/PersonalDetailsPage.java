package com.qa.hrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hrm.testbase.BaseClass;

public class PersonalDetailsPage {

	@FindBy(id = "pim.navbar.employeeName")
	public WebElement fullName;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "pimPersonalDetailsForm")
	public WebElement form;

	@FindBy(id = "licenseNo")
	public WebElement licenseNo;

	@FindBy(xpath = "//form[@id='pimPersonalDetailsForm']//button[text()='Save']")
	public WebElement saveBtn;

	@FindBy(id = "otherId")
	public WebElement otherId;

	@FindBy(id = "nickName")
	public WebElement nickName;

	@FindBy(id = "militaryService")
	public WebElement militaryService;

	@FindBy(id = "emp_birthday")
	public WebElement birthDateInput;

	// nationality
	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']//input")
	public WebElement nationalityInput;
	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']//li/span")
	public List<WebElement> nationalityOptions;

	// gender
	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/input")
	public WebElement genderInput;
	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']//ul/li/span")
	public List<WebElement> genderOptions;

	// marital status
	@FindBy(xpath = "//div[@id='emp_marital_status_inputfileddiv']")
	public WebElement maritalStatusInput;
	@FindBy(xpath = "//div[@id='emp_marital_status_inputfileddiv']//li")
	public List<WebElement> maritalStatusOptions;

	// ethnicity
	@FindBy(xpath = "//div[@id='eeo_race_ent_inputfileddiv']")
	public WebElement ethnicityInput;
	@FindBy(xpath = "//div[@id='eeo_race_ent_inputfileddiv']//ul/li")
	public List<WebElement> ethnicityOptions;

	// smoker
	@FindBy(xpath = "//label[text()='Smoker']")
	public WebElement smokerCheckbox;

	// calendar
	@FindBy(xpath = "//i[contains(@class, 'date-picker-open-icon')]")
	public WebElement calendarIcon;
	@FindBy(xpath = "//div[@class='select-wrapper picker__select--year']")
	public WebElement yearPicker;
	@FindBy(xpath = "//div[@class='select-wrapper picker__select--year']/ul/li")
	public List<WebElement> yearOptions;
	@FindBy(xpath = "//div[@class='select-wrapper picker__select--month']")
	public WebElement monthPicker;
	@FindBy(xpath = "//div[@class='select-wrapper picker__select--month']/ul/li")
	public List<WebElement> monthOptions;
	@FindBy(xpath = "//table[@class='picker__table']/tbody/tr/td")
	public List<WebElement> dayCells;

	// license expiration date picker
	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//i")
	public WebElement licExpIcon;
	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']/input")
	public WebElement licYearInput;
	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']//li")
	public List<WebElement> licYearOptions;
	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']/input")
	public WebElement licMonthInput;
	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']//li")
	public List<WebElement> licMonthOptions;
	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//td")
	public List<WebElement> licDayCells;

	// validation
	@FindBy(xpath = "//*[contains(@class, 'toast-message')]")
	public WebElement toastMessage;
	@FindBy(xpath = "//span[text()='Should not exceed 30 characters']")
	public WebElement charLimitError;
	@FindBy(xpath = "//span[text()='Expected format: D, dd M yyyy']")
	public WebElement dateFormatError;

	public PersonalDetailsPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
