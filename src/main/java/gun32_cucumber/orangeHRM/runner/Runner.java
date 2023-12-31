package gun32_cucumber.orangeHRM.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/main/java/gun32_cucumber/orangeHRM/feature"},
        glue = {"gun32_cucumber/orangeHRM/stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
// '[A-Z][A-Za-z\d]*Test(s|Case)?|Test[A-Z][A-Za-z\d]*|IT(.*)|(.*)IT(Case)?'