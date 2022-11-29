package pages.Content;

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

public class ProductsGridPage extends BasePage {
    private Logger log = LoggerFactory.getLogger(ProductsGridPage.class);
    Random random = new Random();

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

    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    public String getRandomProductName() {
        WebElement randomElement = productTitleList.get(random.nextInt(productTitleList.size()));
        return getTextOfWebElement(randomElement);
    }
    public void openRandomProductDetails(){
        click(productList.get(random.nextInt(productList.size())));
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
    public void openProductByName(String productName){
        waitForElementToBeClickable(driver, productTitleList.get(0));
        for (WebElement tempProductName : productTitleList) {
            String name = tempProductName.getText();
            if(name.equals(productName)){
                click(tempProductName);
                break;
            }
        }
    }
    public List<Double> getProductPrices() {
        List<Double> productPriceList = new ArrayList<>();
        for (WebElement productPrice : priceList) {
            wait.until(driver -> productPrice.isEnabled());
            productPriceList.add(getPrice(productPrice));
        }
        return productPriceList;
    }

}
