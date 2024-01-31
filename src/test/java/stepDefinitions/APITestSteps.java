package stepDefinitions;

import api.pojo.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class APITestSteps {
    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }
  Response response;
    @Given("I hit the rest public api")
    public void i_hit_the_rest_public_api() {
        // Write code here that turns the phrase above into concrete actions
        response =RestAssured.given().get("https://gorest.co.in/public/v2/users/")
                .then()
                .extract().response();
    }

    @Then("I received the status code {int}")
    public void i_received_the_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(response.statusCode(),int1);
    }

    @Given("I hit the post rest public api with {int},{string}, {string}, {string}, {string}")
    public void i_hit_the_post_rest_public_api_with(Integer id, String name, String email, String gender, String status) {
        // Write code here that turns the phrase above into concrete actions
      User user = new User(id, name, email, gender, status);
      Response postResponse = RestAssured.given()
              .header("Authorization", "Bearer e4b8e1f593dc4a731a153c5ec8cc9b8bbb583ae964ce650a741113091b4e2ac6")
              .body(user)
              .post("https://gorest.co.in/public/v2/users/")
              .then()
              .log().all()
              .extract().response();

    }
}
