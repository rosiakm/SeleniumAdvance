package helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class WaitHandler {
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))));
        wait.withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(Integer.parseInt(System.getProperty("polling_every_millis"))))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))));
        wait.withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
