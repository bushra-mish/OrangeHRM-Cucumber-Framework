package com.qa.hrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hrm.testbase.BaseClass;

public class DashboardPage {

	@FindBy(id = "ohrm-small-logo")
	public WebElement logo;

	@FindBy(id = "account-name")
	public WebElement accountName;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pimMenu;

	@FindBy(linkText = "Add Employee")
	public WebElement addEmployeeLink;

	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement employeeListLink;

	@FindBy(id = "menu_pim_viewMyDetails")
	public WebElement myInfoLink;

	@FindBy(xpath = "//li[@id='menu_news_More']/a")
	public WebElement moreMenuItem;

	@FindBy(xpath = "//div[@id='menu-content']/ul/li")
	public List<WebElement> menuItems;

	@FindBy(id = "menu_discipline_defaultDisciplinaryView")
	public WebElement disciplineMenu;

	@FindBy(id = "menu_discipline_viewDisciplinaryCases")
	public WebElement disciplinaryCasesLink;

	@FindBy(xpath = "//a[@id='top-menu-trigger']")
	public WebElement moreDropdown;

	@FindBy(xpath = "//ul[@id='top-menu-overflow']//span[text()='Memberships']")
	public WebElement membershipsLink;

	@FindBy(id = "employee_name_quick_filter_employee_list")
	public WebElement searchByName;

	@FindBy(id = "quick_search_icon")
	public WebElement searchBtn;

	public DashboardPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
