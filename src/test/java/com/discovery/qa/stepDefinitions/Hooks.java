package com.discovery.qa.stepDefinitions;

import com.discovery.qa.base.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {
//		@Before
//		public void deleteCookies()
//		{
//			driver.manage().deleteAllCookies();
//		}
		
		@After
	    public void afterScenario(){
			driver.manage().deleteAllCookies();
	        driver.quit();
	    }
	}

