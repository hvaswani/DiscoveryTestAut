package com.discovery.qa.stepDefinitions;
import com.discovery.qa.base.TestBase;
import com.discovery.qa.pages.PopularShowPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import static org.junit.Assert.*;

public class PopularShowStepDefinition extends TestBase {

	PopularShowPage popularshowpage;
	
	@Given("^verify Popular Shows$")
	public void verify_popular_shows() throws Throwable {	   
		popularshowpage = new PopularShowPage();
		String CorousalName = popularshowpage.verifyPopularShow();
		assertEquals(CorousalName, "POPULAR SHOWS");		
	}
	
	@And("^go to last video and click explore the show$")
	public void go_to_last_video_and_click_explore_the_show() throws Throwable{
		popularshowpage.clickRightIconAndClickExploreTheShow();		
	}
	
	@And("^click on Show More twice and verify title with durations$")
	public void click_on_show_more_and_verify_title_with_duration() throws Throwable{
		popularshowpage.clickShowMoreVerifyTitleDuration();	
	}
	
	
}
 
	
	


	
	


	    

