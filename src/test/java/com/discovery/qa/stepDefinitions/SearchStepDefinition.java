package com.discovery.qa.stepDefinitions;
import com.discovery.qa.base.TestBase;
import com.discovery.qa.pages.HomePage;
import com.discovery.qa.pages.SearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class SearchStepDefinition extends TestBase {

	HomePage homePage;
	TestBase testbase;
	SearchPage searchpage;
	
	@Given("^click on Search icon$")
	public void click_on_search_icon() throws Throwable {	   
		initialization();
		homePage = new HomePage();
		testbase = new TestBase();
		searchpage = new SearchPage();
		searchpage.clickSearchIcon();
	}
	
	@Given("^I enter show name in search text box$")
	public void enter_show_name_in_search_text_box() throws Throwable {		
		searchpage.enterSearchText();
	}
	
	@And("select the first show from the list$")
	public void select_the_first_show_from_search_list() throws Throwable {	   
		searchpage.selectFirstShowFromSearchList();
	}
		
		
	}
 
	
	


	
	


	    

