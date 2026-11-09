package com.todos.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BasePage {

	public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
	public static Properties prop;

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\java\\com\\todos\\configs\\config.properties");
		prop.load(fis);
	}

	public static void initialization(String browser) {

		if (browser == null || browser.trim().isEmpty()) {
			throw new IllegalArgumentException("Le navigateur ne doit pas être null ou vide.");
		}

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			driverThread.set(new ChromeDriver(chromeOptions));

		} else if (browser.equalsIgnoreCase("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProfile(profile);
			driverThread.set(new FirefoxDriver(firefoxOptions));

		} else if (browser.equalsIgnoreCase("edge")) {

			driverThread.set(new EdgeDriver());

		} else {

			throw new IllegalArgumentException("Navigateur non reconnu : " + browser);
		}
	}    /* GETTER */
    public static WebDriver getDriver() {
        return driverThread.get();
    }
}