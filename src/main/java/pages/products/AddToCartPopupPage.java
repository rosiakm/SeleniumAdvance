package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import static helpers.WaitHandler.waitForElementToBeClickable;
import static helpers.WaitHandler.waitForElementToBeVisible;

public class AddToCartPopupPage extends BasePage {
    Logger log = LoggerFactory.getLogger(AddToCartPopupPage.class);

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
    @FindBy(css = ".btn-secondary")
    private WebElement continueShoppingButton;

    public AddToCartPopupPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getTextOfWebElement(productName);
    }

    public Double getProductPrice() {
        return getPrice(productPrice);
    }

    public Double getTotalPrice() {
        waitForElementToBeVisible(driver,totalPrice);
        return getPrice(totalPrice);
    }

    public void continueShopping(){
        waitForElementToBeClickable(driver,continueShoppingButton);
        click(continueShoppingButton);
    }
    public void openCart(){
        waitForElementToBeClickable(driver,proceedToCheckoutButton);
        click(proceedToCheckoutButton);
    }
    public void waitForProceedToCheckoutButtonToBeClickable(){
        waitForElementToBeClickable(driver,proceedToCheckoutButton);
    }

}
