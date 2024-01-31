package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By emailInput = By.xpath("//*[@type='email']");
    private By passwordInput = By.xpath("//input[@type='password']");
    private By logInBtn = By.xpath("//*[@type='submit']");
    private By passwordErrorMsgText = By.xpath("//*[@text='Your password must contain between 4 and 60 characters.']");

    public LoginPage(WebDriver driver){
        this.driver =driver;
    }

    public void enterEmail(String email){
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInt = driver.findElement(passwordInput);
        passwordInt.sendKeys(password);
    }

    public void clickLoginBtn(){
        WebElement loginBtn = driver.findElement(logInBtn);
        loginBtn.click();
    }

    public  void logIn(String email, String password){
        enterEmail(email);
        enterPassword(password);

    }

    public boolean getErrorMsg(){
        WebElement errorMsg = driver.findElement(passwordErrorMsgText);
        return errorMsg.isDisplayed();
    }


}
