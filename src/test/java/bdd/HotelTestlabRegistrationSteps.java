package bdd;

import helpers.GeneralHelpers;
import helpers.WebDriverFactory;
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

    @Given("unregistered user is on the Hotel Testlab website")
    public void unregisteredUserIsOnTheHotelTestlabWebsite() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("user clicks Sign In button")
    public void userClicksSignInButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
    }

    @When("user inputs random email address in Create An Account section")
    public void userInputsEmailAddressInCreateAnAccountSection() {
        String email = GeneralHelpers.GetCurrentRandomizedDateTimeEmail();
        driver.findElement(By.id("email_create")).sendKeys(email);
    }

    @And("clicks Create an account button")
    public void clicksCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("user fills {string}, {string}, {string} and user clicks Register button")
    public void userFillsFirstNameLastNamePasswordAndUserClicksRegisterButton(String firstName, String lastName, String password) {
        createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.registerUser(firstName, lastName, password);
    }

    @Then("Your account has been created. message is displayed.")
    public void yourAccountHasBeenCreatedMessageIsDisplayed() {
        Assertions.assertEquals("Your account has been created.",
                createAnAccountPage.getRegistrationConfirmationText());

        driver.quit();
    }
}
