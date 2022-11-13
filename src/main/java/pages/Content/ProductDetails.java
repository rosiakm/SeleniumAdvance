package pages.Content;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import static helpers.WaitHandler.waitForElementToBeClickable;

public class ProductDetails extends BasePage {
    Logger log = LoggerFactory.getLogger(ProductDetails.class);

    @FindBy(css = "h1[itemprop='name']")
    private WebElement productName;
    @FindBy(css = "span[itemprop='price']")
    private WebElement productPrice;
    @FindBy(css = "span[class='regular-price']")
    private WebElement regularPrice;
    @FindBy(css = "#quantity_wanted")
    private WebElement quantityInput;
    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    public ProductDetails(WebDriver driver){
        super(driver);
    }

    public String getProductName(){
        return getTextOfWebElement(productName);
    }
    public Double getProductPrice(){
        return getPrice(productPrice);
    }
    public Integer getQuantity(){
        return Integer.parseInt(getValue(quantityInput));
    }
    public void clickOnAddToCartButton(){
        click(addToCartButton);
    }
    public void setQuantityInput(String text){
        sendKeysAndClear(quantityInput, text);
    }
    public void waitForQuantityInputToBeClickable(){
        waitForElementToBeClickable(driver,quantityInput);
    }
    public Product returnNewProduct(){
        return new Product(getProductName(), getProductPrice(), getQuantity());
    }

}
