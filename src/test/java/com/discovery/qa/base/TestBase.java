package com.discovery.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

	public static final String PropertyFilePath = "C:/Users/honey.vaswani/eclipse-workspace/DiscoveryBDDFramework/src/main/java/com/discovery/qa/config/config.properties";
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(PropertyFilePath);
			prop.load(fs);
		} catch (FileNotFoundException file) {
			file.printStackTrace();
		} catch (IOException file) {
			file.printStackTrace();
		}
	}

	public static void initialization() {
		String Browser = prop.getProperty("browser");

		if (Browser.equalsIgnoreCase("chrome")) {
			String cwd = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", cwd + prop.getProperty("cromeDriverPath"));
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		} else if (Browser.equalsIgnoreCase("firefox")) {
			String cwd = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", cwd + prop.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("iexplorer")) {
			String cwd = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", cwd + prop.getProperty("ieDriverPath"));
			driver = new InternetExplorerDriver();
		}

		String URL = prop.getProperty("url");
		driver.get(URL);
		driver.manage().window().maximize();

	}
}
