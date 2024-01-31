package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
           driver.quit();
        }
    }

    @Given("I am on the flipcart login page")
    public void i_am_on_the_flipcart_login_page() {
       driver.get("https://www.netflix.com/in/login");
       loginPage = new LoginPage(driver);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String email, String password) {
       loginPage.logIn(email,password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginBtn();
    }

    @Then("I should see the error message")
    public void i_should_see_the_error_message() {
      // loginPage.getErrorMsg();
      // Assert.assertTrue(loginPage.getErrorMsg(),"Your password must contain between 4 and 60 characters.");
    }
}
