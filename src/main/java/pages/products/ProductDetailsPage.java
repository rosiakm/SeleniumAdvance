package pages.products;

import models.Cart;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.Random;

import static helpers.WaitHandler.waitForElementToBeClickable;

public class ProductDetailsPage extends BasePage {
    Logger log = LoggerFactory.getLogger(ProductDetailsPage.class);

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

    public ProductDetailsPage(WebDriver driver){
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
    public void addProductToCart(){
        click(addToCartButton);
    }
    public void addProductToCart(Cart cart){
        Product product = new Product(getProductName(),getProductPrice(),getQuantity(),getProductPrice()*getQuantity());
        cart.addProduct(product);
        click(addToCartButton);
    }
    public void setQuantity(String text){
        waitForElementToBeClickable(driver,quantityInput);
        sendKeysAndClear(quantityInput, text);
        log.info("quantity value: " + text);
    }
    public void waitForQuantityInputToBeClickable(){
        waitForElementToBeClickable(driver,quantityInput);
    }
    public void setRandomQuantity(int minQuantity, int maxQuantity){
        String quantity = getRandomQuantity(minQuantity, maxQuantity);
        sendKeysAndClear(quantityInput,quantity);
        log.info("quantity value: " + quantity);
    }
    private String getRandomQuantity(int minQuantity, int maxQuantity){
        Random random = new Random();
        return String.valueOf(random.nextInt(minQuantity, maxQuantity));
    }
}
