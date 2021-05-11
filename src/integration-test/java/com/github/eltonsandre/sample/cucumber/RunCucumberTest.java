package com.github.eltonsandre.sample.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.github.eltonsandre.sample.cucumber",
        features = "src/test/resources/features/",
        plugin = {"pretty", "json:build/cucumber.json"},
        publish = true
)
public class RunCucumberTest {

    @BeforeClass
    public static void beforeClass() {
    }

    @AfterClass
    public static void afterClass() {
    }

}
