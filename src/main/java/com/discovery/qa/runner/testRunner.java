package com.discovery.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports" }, monochrome = true, features = "src/test/resources/com/discovery/qa/features", glue = "com.discovery.qa.stepDefinitions")

public class testRunner {

}
