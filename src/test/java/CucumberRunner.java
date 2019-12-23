import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import my.company.steps.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"my.company"},
        plugin = {
                "my.company.util.AllureReporter",
        }
)
public class CucumberRunner extends BaseSteps{
}