package com.discovery.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.discovery.qa.base.TestBase;

public class SearchPage extends TestBase {
	
	@FindBy(xpath="//div[contains(@class,'headerSearch__searchIcon ')]")
	public WebElement searchIcon;
	
	@FindBy(xpath="//input[contains(@class,'searchInput__input')]")
	public WebElement searchText;

	@FindBy(xpath="(//div[contains(@class,'searchGrid__tilesList')]//div[contains(@class,'searchTileAnimation')]//div[contains(@class,'searchGridTile__container')]\r\n" + 
			"//a[contains(@class,'searchGridTile__link')])[1]")
	public WebElement firstProduct;

	
	@FindBy(xpath="//h2[contains(text(),'Apollo')]")
	public WebElement showDetail;
	
	public SearchPage() {
		//To initialize page factory/page objects by PageFactory class and initElements Method
		PageFactory.initElements(driver, this);
	}
	
	public void clickSearchIcon() {
		searchIcon.click();
	}

	public void enterSearchText() {
		searchText.sendKeys("APOLLO");
		searchText.sendKeys(Keys.ENTER);
	}
	public void selectFirstShowFromSearchList() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();	
		
	}
	
	public boolean verifyShowDetail() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		return showDetail.getText().contains("apollo");
	}
	
	}
	
	
	

