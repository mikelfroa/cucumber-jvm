package com.mutua.test.testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="./src/test/resources/features/Cotizacion.feature",
        glue={"com/mutua/test/pageobjects","com/mutua/test/testhooks","com/mutua/test/stepdefinitions"},
        plugin={ "pretty",
                "json:target/cucumber.json"},
        tags = {"~@ignore"}

)

public class RunnerClassIT {

}
