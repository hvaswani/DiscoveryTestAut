package com.discovery.qa.stepDefinitions;

import com.discovery.qa.base.TestBase;

import cucumber.api.java.After;

public class Hooks extends TestBase {
		
		@After
	    public void afterScenario(){
			driver.manage().deleteAllCookies(); 
			driver.quit();
	    }
	}

