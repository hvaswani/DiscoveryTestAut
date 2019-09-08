package com.discovery.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.discovery.qa.base.TestBase;

public class FavoritesPage extends TestBase {

	@FindBy(xpath = "//i[contains(@class,'flipIconCore__icon icon-plus ')]")
	public WebElement favorite;

	@FindBy(xpath = "//i[contains(@class,'flipIconCore__icon icon-minus ')]")
	public WebElement unfavorite;

	@FindBy(xpath = "//*[@class='dscHeaderMain__iconMenu']")
	public WebElement menuicon;

	@FindBy(xpath = "//span[contains(text(),'My Videos')]")
	public WebElement myvideos;

	@FindBy(xpath = "//section[contains(@class,'tile showTileSquare__main transition-in')]//div[contains(@class,'content-box showTileSquare__contentBox')]//h3[contains(@class,'showTileSquare__title')]")
	public WebElement favShow;

	List<String> favoriteList = new ArrayList<String>();
	//List<String> unfavoriteList = new ArrayList<String>();
	List<String> secondFavoriteList = new ArrayList<String>();

	public FavoritesPage() {
		// To initialize page factory/page objects by PageFactory class and initElements
		// Method
		PageFactory.initElements(driver, this);
	}

	public void verifyFavorites() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elementTest = null;
		try {
			elementTest = driver.findElement(By.xpath("//i[contains(@class,'flipIconCore__icon icon-plus ')]"));
		} catch (Exception e) {
			elementTest = driver.findElement(By.xpath("//i[contains(@class,'flipIconCore__icon icon-minus ')]"));
		}
		System.out.println(elementTest.getAttribute("class"));
		elementTest.getAttribute("class");
	}

	public List<String> flagFavorite() throws Exception {
		try {
			unfavorite.click();
//			System.out.println(driver.getTitle());
//			unfavoriteList.add(driver.getTitle().split("\\|")[0]);
			System.out.println("Show is removed from Favorites");
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(favorite)).click();
			favoriteList.add(driver.getTitle().split("\\|")[0].toUpperCase());
		}
		return favoriteList;

	}
	
	public boolean compareList(List<String> favFirst, List<String> favSecond) {
		if(favFirst.size() == favSecond.size()) {
			return favFirst.equals(favSecond);
		}
		return false;
	}

	public void clickMenuIcon() {
		menuicon.click();
	}

	public List<String> clickMyVideos() {
		myvideos.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		List<WebElement> elementsTest = driver.findElements(By.className("localStorageCarousel__wrapper"));
		for (WebElement element : elementsTest) {
			String innerTxt = element.findElement(By.className("showTileSquare__title")).getAttribute("innerText");
			secondFavoriteList.add(innerTxt.toUpperCase());
		}
		return secondFavoriteList;
	}
	
//	@SuppressWarnings("unchecked")
//	public void verifyTitlesInFavorites() {
////		WebDriverWait wait = new WebDriverWait(driver, 10);
////		wait.until(ExpectedConditions.visibilityOf(favShow)).getAttribute("href");
////		System.out.println(favShow.getText());
////		
////		return favShow.findElement(By.cssSelector("a")).getAttribute("href");
//		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,400)");
//		
//		}
//	}
//	
////	
////	public void getFavoriteShowText()
//	{
//		System.out.println(favShow.getText());
//			
//	}

//	public void displayCountStatus() {
//		List<String> favoriteList = new ArrayList<String>();
//		List<String> unfavoriteList = new ArrayList<String>();
//		if(favorite.isDisplayed()) {
//			
//			System.out.println("Show is removed from Favorites");
//		}else {
//			unfavorite.click();
//			System.out.println("Show is added in Favorites");
//		}
//	}

}
