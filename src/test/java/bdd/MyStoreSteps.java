package bdd;

import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.pages.myStore.LoginPage;
import pageObjectPattern.pages.myStore.UserInformationPage;

public class MyStoreSteps {

    private WebDriver driver;
    private UserInformationPage userInformationPage;

    @Given("User is logged in to CodersLab shop")
    public void userIsLoggedInToCodersLabShop() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");
    }

    @When("User goes to UserInformationPage")
    public void userGoesToUserInformationPage() {
        driver.findElement(By.id("identity-link")).click();
        userInformationPage = new UserInformationPage(driver);
    }

    @And("User signs up for our newsletter")
    public void userSignsUpForOurNewsletter() {
        userInformationPage.signInForNewsletter();
    }

    @And("User changes birthdate")
    public void userChangesBirthdate() {
        userInformationPage.setBirthDate("12/12/1980");
    }

    @And("User saves information")
    public void userSavesInformation() {
        userInformationPage.submitUserInfo("qwerty");
    }

    @Then("User sees {string}")
    public void userSees(String successMessage) {
        Assertions.assertEquals(successMessage, userInformationPage.getUpdateInformation());

        driver.quit();
    }
}
