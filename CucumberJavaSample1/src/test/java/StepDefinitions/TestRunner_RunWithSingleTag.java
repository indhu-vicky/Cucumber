package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeatureWithTags/Tags.feature",
glue= {"StepDefinitions"},tags = "@mustRun")

//"@smoke"
//"@smoke and @regression"
//"@smoke or @regression"
//"(@regression and not @important)"
//"(@smoke or @regression) and not @important"


public class TestRunner_RunWithSingleTag {

}
