package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("timeout"))));
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
        log.info("The price is: " + element.getText().replace(System.getProperty("currency"),""));
        return Double.parseDouble(element.getText().replace(System.getProperty("currency"),""));
    }

    public double getPrice(WebElement element, int i){
        return Double.parseDouble(element.getText().replace(System.getProperty("currency"),"").split("-")[i]);
    }
    public String getTextOfWebElement(WebElement element){
        return element.getText();
    }

    public String getValue (WebElement element){
        return element.getAttribute("value");
    }
    public List<String> getNames(List<WebElement> list){
        List<String> namesList = new ArrayList<>();
        for (WebElement tempElement : list) {
            namesList.add(getTextOfWebElement(tempElement));
        }
        return namesList;
    }
    public void scrollToElement(WebElement element){
        actions.scrollToElement(element).perform();
        log.info("Successfully scrolled to " + element);
    }
}
