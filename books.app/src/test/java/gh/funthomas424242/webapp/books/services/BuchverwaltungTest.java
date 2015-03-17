package gh.funthomas424242.webapp.books.services;

import gh.funthomas424242.webapp.books.lib.Feature;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@modul" }, plugin = { "pretty",
		"html:target/test-report" }, features = { "src/test/resources/features" })
@Feature
public class BuchverwaltungTest {
}
