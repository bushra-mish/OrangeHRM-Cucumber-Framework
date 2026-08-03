package com.qa.hrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hrm.testbase.BaseClass;

public class DisciplinaryCasesPage {

	@FindBy(id = "noncoreIframe")
	public WebElement iframe;

	@FindBy(xpath = "//a[@id='addItemBtn']")
	public WebElement addBtn;

	@FindBy(id = "addEditDisciplineCase")
	public WebElement modal;

	@FindBy(xpath = "//form[@id='frmSaveDisciplinaryCase']//input[@id='addCase_employeeName_empName']")
	public WebElement employeeName;

	@FindBy(id = "addCase_caseName")
	public WebElement caseName;

	@FindBy(id = "addCase_description")
	public WebElement description;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	@FindBy(id = "btnBack")
	public WebElement cancelBtn;

	@FindBy(id = "btnEdit")
	public WebElement editBtn;

	@FindBy(xpath = "//div[@class='modal-footer']/a[@id='btnSave']")
	public WebElement footerSaveBtn;

	@FindBy(xpath = "//div[contains(@class, 'modal-content')]//label[text()]")
	public List<WebElement> labels;

	@FindBy(xpath = "//table[@id='resultTable']//tbody/tr")
	public List<WebElement> caseTable;

	@FindBy(id = "addCase_employeeName_empName-error")
	public WebElement empNameError;

	@FindBy(id = "addCase_caseName-error")
	public WebElement requiredError;

	@FindBy(id = "createDateCase")
	public WebElement createdOn;

	@FindBy(name = "addCase[createBy][empName]")
	public WebElement createdBy;

	@FindBy(xpath = "//div[@class='ac_results']")
	public WebElement autoCompleteDropdown;

	public DisciplinaryCasesPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
