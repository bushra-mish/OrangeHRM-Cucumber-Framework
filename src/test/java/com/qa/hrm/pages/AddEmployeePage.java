package com.qa.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hrm.testbase.BaseClass;

public class AddEmployeePage {

	@FindBy(id = "first-name-box")
	public WebElement firstName;

	@FindBy(id = "middle-name-box")
	public WebElement middleName;

	@FindBy(id = "last-name-box")
	public WebElement lastName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "location")
	public WebElement location;

	@FindBy(xpath = "//label[@for='hasLoginDetails']")
	public WebElement loginToggle;

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "confirmPassword")
	public WebElement confirmPassword;

	@FindBy(id = "modal-save-button")
	public WebElement saveBtn;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancelBtn;

	public AddEmployeePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
