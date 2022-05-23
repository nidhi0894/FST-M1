package TestRunner;
import org.checkerframework.checker.units.qual.C;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="C://Users//0035G0744//Documents//IntelliJ Workspace//FST_Cucumber//src//test//java//Features",
        glue={"StepDefinitions"},
        plugin = { "pretty" ,"html:target/Reports/index.html", "json:target/Reports/cucumber.json" },
        tags="@SmokeTest",
        monochrome = true

)

public class TestRunner {
}
