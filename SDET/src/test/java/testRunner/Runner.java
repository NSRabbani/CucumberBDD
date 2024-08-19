package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "E:\\CucumberBDD\\Rabbani\\SDET\\FeatureFiles\\Login.feature", 
glue = "stepDefinitions", 
dryRun = false,
plugin={
		"html:Reports/Html_Report",
		"pretty",
		"json:Reports/Json_Report.json",
}


)
public class Runner{
	
	
}
