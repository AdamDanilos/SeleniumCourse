package bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/hotel-testlab-registration.feature",
        plugin = {"pretty", "html:out/report.html"}
)
public class HotelTestlabRegistrationTest {
}
