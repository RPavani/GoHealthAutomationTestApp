package CommonSteps;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\PavaniRamineni\\eclipse-workspace\\GoHealthAutomationTestApp\\Feature\\Dateofbirth.feature"
		,glue={"StepDefinitions"}
		)

public class TestRunner {

}
