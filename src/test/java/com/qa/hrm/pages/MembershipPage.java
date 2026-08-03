package com.qa.hrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hrm.testbase.BaseClass;

public class MembershipPage {

	@FindBy(xpath = "//a[@ng-click='memberships.addMembership()']")
	public WebElement addBtn;

	@FindBy(xpath = "(//button//i)[1]")
	public WebElement typeDropdown;

	@FindBy(xpath = "//a[@class='dropdown-item']")
	public List<WebElement> typeOptions;

	@FindBy(id = "subscriptionPaidBy")
	public WebElement paidBy;

	@FindBy(id = "subscriptionFee")
	public WebElement fee;

	@FindBy(id = "subscriptionCurrency")
	public WebElement currency;

	@FindBy(id = "modal-save-button")
	public WebElement saveBtn;

	@FindBy(xpath = "//table[@class='highlight bordered']//tbody/tr")
	public WebElement table;

	@FindBy(xpath = "//input[@id='subscriptionCommenceDate']")
	public WebElement commenceDate;

	@FindBy(xpath = "//input[@id='subscriptionRenewalDate']")
	public WebElement renewalDate;

	// calendar 1
	@FindBy(xpath = "//button[contains(@class, 'date-picker-button')]")
	public WebElement cal1;
	@FindBy(xpath = "//select[contains(@class,'picker__select--month')]//following-sibling::button")
	public WebElement cal1Month;
	@FindBy(xpath = "//select[contains(@class,'picker__select--month')]/option")
	public List<WebElement> cal1MonthOptions;
	@FindBy(xpath = "//select[contains(@class,'picker__select--year')]//following-sibling::button")
	public WebElement cal1Year;
	@FindBy(xpath = "//select[contains(@class,'picker__select--year')]/option")
	public List<WebElement> cal1YearOptions;
	@FindBy(xpath = "//table[@class='picker__table']//tbody/tr/td/div[contains(@class,'picker__day--infocus')]")
	public List<WebElement> cal1Days;

	// calendar 2
	@FindBy(xpath = "(//button[contains(@class, 'date-picker-button')])[2]")
	public WebElement cal2;
	@FindBy(xpath = "(//select[contains(@class,'picker__select--month')]//following-sibling::button)[2]")
	public WebElement cal2Month;
	@FindBy(xpath = "(//select[contains(@class,'picker__select--month')])[2]/option")
	public List<WebElement> cal2MonthOptions;
	@FindBy(xpath = "(//select[contains(@class,'picker__select--year')])[2]//following-sibling::button")
	public WebElement cal2Year;
	@FindBy(xpath = "(//select[contains(@class,'picker__select--year')])[2]/option")
	public List<WebElement> cal2YearOptions;
	@FindBy(xpath = "(//table[@class='picker__table'])[2]//tbody/tr/td/div[contains(@class,'picker__day')]")
	public List<WebElement> cal2Days;

	public MembershipPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
