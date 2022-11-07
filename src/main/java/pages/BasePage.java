package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log.info("Elements on the website are initialized");
    }

    public void click(WebElement element){
        log.info("clicking on: " + element.getText());
        element.click();
    }

    public void sendKeys(WebElement element, String textToSend){
        log.info("typing: " + textToSend);
        element.sendKeys(textToSend);
    }

    public void sendKeysAndClear(WebElement element, String textToSet){
        log.info("cleaning input");
        element.clear();
        element.sendKeys(textToSet);
    }

    public double getPrice(WebElement element){
        return Double.parseDouble(element.getText().replace("$",""));
    }

    public String getValue (WebElement element){
        return element.getAttribute("value");
    }
}
