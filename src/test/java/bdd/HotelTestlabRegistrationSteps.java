package bdd;

import helpers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.pages.CreateAnAccountPage;

public class HotelTestlabRegistrationSteps {

    private WebDriver driver;

    CreateAnAccountPage createAnAccountPage;

    @Before
    public void openBrowser() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("unregistered user is on the Hotel Testlab website")
    public void unregisteredUserIsOnTheHotelTestlabWebsite() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("user clicks Sign In button")
    public void userClicksSignInButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
    }

    @When("user inputs email address in Create An Account section")
    public void userInputsEmailAddressInCreateAnAccountSection() {
        driver.findElement(By.id("email_create")).sendKeys("jds12522das45@mail.com");
    }

    @And("clicks Create an account button")
    public void clicksCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("user fills First name, Last name, Password and user clicks Register button")
    public void userFillsFirstNameLastNamePasswordAndUserClicksRegisterButton() {
        createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.registerUser("firstName", "lastName", "password");
    }

    @Then("Your account has been created. message is displayed.")
    public void yourAccountHasBeenCreatedMessageIsDisplayed() {
        Assertions.assertEquals("Your account has been created.",
                createAnAccountPage.getRegistrationConfirmationText());
    }
}
