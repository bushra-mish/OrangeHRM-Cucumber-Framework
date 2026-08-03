package com.qa.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hrm.testbase.BaseClass;
import com.qa.hrm.utils.CommonMethods;

public class LoginPage {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement loginBtn;

	@FindBy(id = "txtUsername-error")
	public WebElement usernameError;

	@FindBy(id = "txtPassword-error")
	public WebElement passwordError;

	@FindBy(css = "div.toast-message")
	public WebElement toastMessage;

	@FindBy(css = "img[src*='logo']")
	public WebElement logo;

	@FindBy(xpath = "//div[text()='Retry Login']")
	public WebElement retryLogin;

	public LoginPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void doLogin(String user, String pass) {
		CommonMethods.sendText(username, user);
		CommonMethods.sendText(password, pass);
		CommonMethods.click(loginBtn);
	}

}
