package com.discovery.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {
	
	public static final String PropertyFilePath = "C:/Users/honey.vaswani/eclipse-workspace/DiscoveryBDDFramework/src/main/java/com/discovery/qa/config/config.properties";
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
	
		try {
		prop = new Properties();
		FileInputStream fs = new FileInputStream(PropertyFilePath);
		prop.load(fs);
		}
		catch (FileNotFoundException file)
		{
			file.printStackTrace();
		}
		catch (IOException file)
		{
			file.printStackTrace();
		}	
	}
	
	public static void initialization() {
	String Browser = prop.getProperty("browser");
	
	if(Browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/honey.vaswani/eclipse-workspace/DiscoveryBDDFramework/src/test/resources/BrowserExecutables/chromedriver_win32 (3)/chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver","C:/Users/honey.vaswani/eclipse-workspace/DiscoveryBDDFramework/src/test/resources/BrowserExecutables/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else if(Browser.equalsIgnoreCase("iexplorer")) {
		System.setProperty("webdriver.ie.driver","C:/Users/honey.vaswani/eclipse-workspace/DiscoveryBDDFramework/src/test/resources/BrowserExecutables/IEDriverServer_x64_3.14.0/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
		
	String URL = prop.getProperty("url");
	driver.get(URL);

//	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();

	
	}
}
