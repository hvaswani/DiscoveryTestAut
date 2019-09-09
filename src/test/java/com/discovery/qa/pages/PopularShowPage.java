package com.discovery.qa.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.discovery.qa.base.TestBase;

public class PopularShowPage extends TestBase {

	@FindBy(className = "popularShowsCarousel__header")
	public WebElement popularShow;

	@FindBy(xpath = "//div[contains(@class,'carousel__arrowWrapper popularShowsCarousel__controlsProp')]//i[@class='icon-arrow-right']")
	public WebElement rightIcon;

	@FindBy(xpath = "(//div[@class='popularShowTile__showButtonWrapper'])[15]")
	public WebElement exploreTheShow;

	@FindBy(xpath = "//button[@class='episodeList__showMoreButton']")
	public WebElement showMore;

	public PopularShowPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPopularShow() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3700)");
		return popularShow.getText();
	}

	public void clickRightIconAndClickExploreTheShow() {

		for (int i = 0; i < 14; i++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", rightIcon);
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(exploreTheShow)).click();

	}

	public void clickShowMoreVerifyTitleDuration() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(showMore)).click();
		jse.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.elementToBeClickable(showMore)).click();
		List<WebElement> products = driver.findElements(By.xpath("//p[@class='episodeTitle']"));
		List<WebElement> durations = driver.findElements(By.xpath("//p[@class='minutes']"));
		Iterator<WebElement> productIterator = products.iterator();
		Iterator<WebElement> durationIterator = durations.iterator();
		try {
			FileWriter writer = new FileWriter("src/test/resources/MyFile.txt", true);
			while (productIterator.hasNext() && durationIterator.hasNext()) {
				WebElement prodElement = (WebElement) productIterator.next();
				WebElement durationElement = (WebElement) durationIterator.next();
				writer.write(prodElement.getText() + " == " + durationElement.getText());
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}