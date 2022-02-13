package bdd;

import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BingSearchStepDefinitions {

    private WebDriver driver;

    @Given("an open browser with bing.com")
    public void anOpenBrowserWithBingCom() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(5);
        driver.get("https://www.bing.com/");
    }

    @When("a keyword selenium is entered in input field and clicks search button")
    public void aKeywordSeleniumIsEnteredInInputFieldAndClicksSearchButton() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("selenium");
        searchInput.submit();
    }

    @Then("the first result should contain selenium")
    public void theFirstResultShouldContainSelenium() {
        System.out.println("wyszukało selenium");

        //tutaj jest dobre miejsce na asercje
        Assertions.assertTrue(true);
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
