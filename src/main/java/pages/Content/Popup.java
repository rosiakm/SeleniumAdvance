package pages.Content;

import helpers.WaitHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import static helpers.WaitHandler.waitForElementToBeClickable;

public class Popup extends BasePage {
    Logger log = LoggerFactory.getLogger(Popup.class);

    @FindBy(css = ".product-name")
    private WebElement productName;
    @FindBy(css = "p.product-price")
    private WebElement productPrice;
    @FindBy(css = "p.product-total .value")
    private WebElement totalPrice;
    @FindBy(css = "p.cart-products-count")
    private WebElement summaryText;
    @FindBy(css = "a.btn")
    private WebElement proceedToCheckoutButton;

    public Popup(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getTextOfWebElement(productName);
    }

    public Double getProductPrice() {
        return getPrice(productPrice);
    }

    public Double getTotalPrice() {
        return getPrice(totalPrice);
    }

    public String getSummaryText() {
        return getTextOfWebElement(summaryText);
    }
    public void clickOnProceedToCheckoutButton(){
        click(proceedToCheckoutButton);
    }
    public void waitForProceedToCheckoutButtonToBeClickable(){
        waitForElementToBeClickable(driver,proceedToCheckoutButton);
    }

}
