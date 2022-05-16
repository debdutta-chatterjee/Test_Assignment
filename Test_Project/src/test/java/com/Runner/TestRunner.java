package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Cucumber runner
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resource/features", tags="@E2E", glue="com.stepDefinition", plugin= {"json:target/cucumber.json"})
public class TestRunner {
	
	
	
}
