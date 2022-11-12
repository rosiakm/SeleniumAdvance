package pages.Content;

import helpers.WaitHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class ProductListHeader extends BasePage {
    private Logger log = LoggerFactory.getLogger(ProductListHeader.class);

    @FindBy(css = "#js-product-list-header h1")
    private WebElement categoryHeaderLabel;

    public ProductListHeader(WebDriver driver) {
        super(driver);
    }

    public String getCategoryLabelText() {
        waitForElementToBeVisible(driver, categoryHeaderLabel);
        return getTextOfWebElement(categoryHeaderLabel);
    }
}
