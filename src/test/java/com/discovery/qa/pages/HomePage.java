package com.discovery.qa.pages;

import org.junit.rules.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.discovery.qa.base.TestBase;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//img[contains(@class,'headerLogo__logo ')]")
	public WebElement discoveryLogo;
	
	@FindBy(xpath="//span[contains(text(),'Watch Live Now')]")
	public WebElement watchLiveNow;

	@FindBy(xpath="//span[contains(text(),'Shows')]")
	public WebElement shows;
	
	@FindBy(xpath="//span[contains(text(),'Schedule')]")
	public WebElement schedule;
	
	@FindBy(xpath="(//a[contains(text(),'See All Shows')])[1]")
	public WebElement seeAllShows;
	
	
	public HomePage() {
		//To initialize page factory/page objects by PageFactory class and initElements Method
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public void verifyHomePageElements() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(discoveryLogo));	
		wait.until(ExpectedConditions.visibilityOf(watchLiveNow));	
		wait.until(ExpectedConditions.visibilityOf(shows));	
		wait.until(ExpectedConditions.visibilityOf(schedule));	
	}
	
	public void clickOnShowsCategory() {
		shows.click();
	}
	
	public void clickSeeAllShowsOption() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(seeAllShows)).click();
		Thread.sleep(5000);
	}
	
	}
	
	
	

