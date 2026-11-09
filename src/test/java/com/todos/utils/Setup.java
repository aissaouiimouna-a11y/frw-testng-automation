package com.todos.utils;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Setup extends BasePage {

	public Setup() throws IOException {
		super();
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setupTest(@Optional("chrome") String browser) {
		initialization(browser);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
	}

	@AfterMethod
	public void cleanTest() {
	
		WebDriver driver = getDriver();

		if (driver != null) {
			try {
				driver.quit();
			} finally {
				driverThread.remove();
			}
		}
	}
}
