package pages.Content;

import helpers.WaitHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static helpers.WaitHandler.waitForElementToBeClickable;

public class Products extends BasePage {
    private Logger log = LoggerFactory.getLogger(Products.class);

    @FindBy(css = "div[class='products row']")
    private WebElement allProducts;
    @FindBy(css = "div[class='product']")
    private List<WebElement> productList;
    @FindBy(css = ".product-title a")
    private List<WebElement> productTitleList;
    @FindBy(css = "span[class='price']")
    private List<WebElement> priceList;
    @FindBy(css = "div[class='product-description'] a")
    private WebElement productDescription;
    @FindBy(css = "#js-product-list-top p")
    private WebElement summaryOfSearchText;

    public Products(WebDriver driver) {
        super(driver);
    }

    public String getRandomProductName() {
        Random random = new Random();
        WebElement randomElement = productTitleList.get(random.nextInt(productTitleList.size()));
        return getTextOfWebElement(randomElement);
    }

    public int getTheNumberOfProducts() {
        return productList.size();
    }

    public String getTextOfSearchSummary() {
        return getTextOfWebElement(summaryOfSearchText);
    }

    public String getProductName() {
        return getTextOfWebElement(productDescription);
    }

    public void scrollToProductDescription() {
        scrollToElement(productDescription);
    }
    public void openProduct(String name){
        openProductByName(productTitleList, name);
    }
    public void waitForProductToBeClickable(){
        waitForElementToBeClickable(driver, productTitleList.get(0));
    }

    public List<Double> getProductPriceList() {
        List<Double> productPriceList = new ArrayList<>();
        for (WebElement productPrice : priceList) {
            wait.until(driver -> productPrice.isEnabled());
            productPriceList.add(getPrice(productPrice));
        }
        return productPriceList;
    }

}
