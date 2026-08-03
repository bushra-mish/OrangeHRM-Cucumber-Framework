package com.qa.hrm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hrm.testbase.BaseClass;
import com.qa.hrm.testbase.PageInitializer;

/**
 * Reusable Selenium action methods shared by all step definitions. Also
 * contains higher-level business shortcuts for common workflows.
 */
public class CommonMethods extends PageInitializer {

	// ---------- basic Selenium wrappers ----------

	public static void sendText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}

	public static void click(WebElement el) {
		waitForClickability(el);
		el.click();
	}

	public static void jsClick(WebElement el) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", el);
	}

	public static void wait(int sec) {
		try { Thread.sleep(sec * 1000L); } catch (InterruptedException e) { e.printStackTrace(); }
	}

	// ---------- dropdown helpers ----------

	public static void selectDropdown(WebElement el, String visibleText) {
		try { new Select(el).selectByVisibleText(visibleText); } catch (Exception e) { e.printStackTrace(); }
	}

	public static void selectDropdown(WebElement el, int index) {
		try { new Select(el).selectByIndex(index); } catch (Exception e) { e.printStackTrace(); }
	}

	public static void selectDropdownByClicking(WebElement input, List<WebElement> options, String value) {
		click(input);
		wait(1);
		for (WebElement opt : options) {
			if (opt.getText().equals(value)) { click(opt); break; }
		}
	}

	// ---------- waits ----------

	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
	}

	public static WebElement waitForVisibility(WebElement el) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(el));
	}

	public static WebElement waitForClickability(WebElement el) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(el));
	}

	// ---------- alert / frame / window ----------

	public static void acceptAlert() {
		try { driver.switchTo().alert().accept(); } catch (NoAlertPresentException e) { e.printStackTrace(); }
	}

	public static void switchToFrame(WebElement el) {
		try { driver.switchTo().frame(el); } catch (NoSuchFrameException e) { e.printStackTrace(); }
	}

	public static void switchToChildWindow() {
		String main = driver.getWindowHandle();
		for (String h : driver.getWindowHandles()) {
			if (!h.equals(main)) { driver.switchTo().window(h); }
		}
	}

	// ---------- scroll ----------

	public static void scrollToElement(WebElement el) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", el);
	}

	// ---------- calendar ----------

	public static void selectCalendarDate(List<WebElement> days, String date) {
		for (WebElement day : days) {
			if (day.getText().equals(date) && day.isEnabled()) { day.click(); break; }
		}
	}

	// ---------- screenshot ----------

	public static byte[] takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = Constants.SCREENSHOT_PATH + fileName + getTimestamp() + ".png";
		try { FileUtils.copyFile(src, new File(dest)); } catch (IOException e) { e.printStackTrace(); }
		return ts.getScreenshotAs(OutputType.BYTES);
	}

	public static String getTimestamp() {
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	}

	// ==================== shared business shortcuts ====================

	public static void login() {
		sendText(PageInitializer.loginPage.username, ConfigsReader.getProperty("username"));
		sendText(PageInitializer.loginPage.password, ConfigsReader.getProperty("password"));
		click(PageInitializer.loginPage.loginBtn);
	}

	public static void goToAddEmployee() {
		click(PageInitializer.dashboardPage.pimMenu);
		click(PageInitializer.dashboardPage.addEmployeeLink);
	}

	public static void goToEmployeeList() {
		click(PageInitializer.dashboardPage.pimMenu);
		click(PageInitializer.dashboardPage.employeeListLink);
	}

	public static void fillName(String first, String last) {
		sendText(PageInitializer.addEmployeePage.firstName, first);
		sendText(PageInitializer.addEmployeePage.lastName, last);
	}

	public static void fillName(String first, String middle, String last) {
		sendText(PageInitializer.addEmployeePage.firstName, first);
		sendText(PageInitializer.addEmployeePage.middleName, middle);
		sendText(PageInitializer.addEmployeePage.lastName, last);
	}

	public static void assertNameVisible(String expected) {
		waitForVisibility(PageInitializer.personalDetailsPage.fullName);
		String actual = PageInitializer.personalDetailsPage.fullName.getText();
		org.junit.Assert.assertEquals("Employee name mismatch", expected, actual);
	}

}
