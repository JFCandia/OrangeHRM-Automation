package com.orangehrm.qa.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.orangehrm.qa.steps",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json", // <-- útil para debugging
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true
)
public class TestRunner {
}