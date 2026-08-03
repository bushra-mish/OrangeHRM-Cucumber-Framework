package com.qa.hrm.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hrm.utils.ConfigsReader;
import com.qa.hrm.utils.Constants;

/**
 * Base class managing WebDriver lifecycle. Reads browser choice from
 * configuration and initializes the driver before each test.
 */
public class BaseClass {

	public static WebDriver driver;

	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIG_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Unsupported browser: " + ConfigsReader.getProperty("browser"));
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.get(ConfigsReader.getProperty("url"));
		PageInitializer.initialize();
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
