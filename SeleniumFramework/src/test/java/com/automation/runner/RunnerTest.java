package com.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/UAT/Store_UI","src/test/resources/UAT/features_GetMethods"},
				 plugin = { "pretty",
						    "html:target/cucumber-html-report",
						    "json:target/cucumber.json"
						        },
				 glue ={"com/pdp/test"},strict = true,
				 dryRun= false,monochrome = true)

public class RunnerTest {
		 

}
