package pages.logIn;

import models.builders.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import providers.UserBuilder;

public class LogInPage extends BasePage {
    Logger log = LoggerFactory.getLogger(LogInPage.class);

    public LogInPage(WebDriver driver){
        super(driver);
    }
    User registeredUser = UserBuilder.getAlreadyRegisterUser();

    @FindBy(css = ".col-md-6 input[name='email']")
    private WebElement emailInput;
    @FindBy(css = ".col-md-6 input[name='password']")
    private WebElement passwordInput;
    @FindBy(css = "#submit-login")
    private WebElement signInButton;

    public LogInPage populateEmail(){
        sendKeys(emailInput, registeredUser.getEmail());
        return this;
    }
    public LogInPage populatePassword(){
        sendKeys(passwordInput, registeredUser.getPassword());
        return this;
    }
    public void signIn(){
        click(signInButton);
    }
}
