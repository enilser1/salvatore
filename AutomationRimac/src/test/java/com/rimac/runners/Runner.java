package com.rimac.runners;



import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;


import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.rimac",
		tags = "@EscenariosRimac",
		snippets = SnippetType.CAMELCASE
		)
public class Runner {

}
