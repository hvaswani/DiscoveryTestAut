package com.discovery.qa.stepDefinitions;

import com.discovery.qa.base.TestBase;
import com.discovery.qa.pages.FavoritesPage;
import com.discovery.qa.pages.HomePage;
import com.discovery.qa.pages.SearchPage;

import cucumber.api.java.en.And;

public class FavoritesStepDefinition extends TestBase {

	HomePage homePage;
	TestBase testbase;
	SearchPage searchpage;
	FavoritesPage favoritespage;

	@And("^verify the favorite status$")
	public void verify_the_favorite_status() throws Throwable {
		homePage = new HomePage();
		testbase = new TestBase();
		searchpage = new SearchPage();
		favoritespage = new FavoritesPage();
		favoritespage.verifyFavorites();
	}

	@And("^change the favourites status$")
	public void change_the_favourites() throws Throwable {
		favoritespage.flagFavorite();
	}

	@And("^navigate to my videos and validate favorite shows$")
	public void navigate_to_my_videos_validate_shows() throws Throwable {
		favoritespage.clickMenuIcon();
		favoritespage.clickMyVideos();
		favoritespage.compareList();
	}

}
