package com.discovery.qa.stepDefinitions;

import static org.junit.Assert.*;

import com.discovery.qa.base.TestBase;
import com.discovery.qa.pages.HomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class HomeStepDefinition extends TestBase {

	HomePage homePage;
	TestBase testbase;

	@Given("^I am on Discovery Home Page$")
	public void i_am_on_Discovery_Page() throws Throwable {
		initialization();
		homePage = new HomePage();
		testbase = new TestBase();
	}

	@And("^Verify the Home Page title$")
	public void verify_the_Home_Page_title() throws Throwable {
		String title = homePage.verifyHomePageTitle();
		assertEquals(title, "Discovery - Official Site");
	}

	@And("^Verify the Home Page elements$")
	public void verify_the_Home_Page_elements() throws Throwable {
		homePage.verifyHomePageElements();
	}

	@And("^Navigate to shows category$")
	public void navigate_to_shows_category() throws Throwable {
		homePage.clickOnShowsCategory();
		System.out.println("User clicked on Shows Category");
	}

	@And("^click on See All Shows option$")
	public void click_on_See_all_show_option() throws Throwable {
		homePage.clickSeeAllShowsOption();
	}

}
