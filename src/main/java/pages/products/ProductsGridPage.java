package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static helpers.WaitHandler.waitForElementToBeClickable;
import static helpers.WaitHandler.waitForElementToBeVisible;

public class ProductsGridPage extends BasePage {
    private Logger log = LoggerFactory.getLogger(ProductsGridPage.class);

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
    @FindBy(css = "#js-product-list-header h1")
    private WebElement categoryHeaderLabel;
    @FindBy(css = "#category-description span")
    private WebElement categoryText;

    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    public String getRandomProductName() {
        return getTextOfWebElement(getRandomWebElement(productTitleList, productTitleList.size()));
    }

    public void openRandomProductDetails() {
        click(getRandomWebElement(productTitleList, productTitleList.size()));
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

    public void openProductByName(String productName) {
        waitForElementToBeClickable(driver, productTitleList.get(0));
        for (WebElement tempProductName : productTitleList) {
            String name = tempProductName.getText();
            if (name.equals(productName)) {
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

    public String getCategoryLabelText() {
        waitForElementToBeVisible(driver, categoryHeaderLabel);
        return getTextOfWebElement(categoryHeaderLabel);
    }

    public String getCategoryDescription() {
        waitForElementToBeVisible(driver, categoryText);
        return getTextOfWebElement(categoryText);
    }
}

