package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber",
        tags = "@newTest",
//        tags = "@parameterizedTest",
//        dryRun = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class Runner {

}