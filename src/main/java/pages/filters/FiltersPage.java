package pages.filters;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class FiltersPage extends BasePage {
    private Logger log = LoggerFactory.getLogger(FiltersPage.class);

    @FindBy(css = "[data-slider-label] p")
    private WebElement priceRangeLabel;
    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    private WebElement sliderRightHandler;
    @FindBy(css = "a.ui-slider-handle:nth-child(2)")
    private WebElement sliderLeftHandler;

    public FiltersPage(WebDriver driver){
        super(driver);
    }

    public void getPriceRangeText(){
        waitForElementToBeVisible(driver, priceRangeLabel);
        getTextOfWebElement(priceRangeLabel);
    }
    public double getMinimumPriceRange(){
       return getPrice(priceRangeLabel, Integer.parseInt(System.getProperty("positionOfMinimumPrice")));
    }
    public double getMaximumPriceRange(){
        return getPrice(priceRangeLabel,Integer.parseInt(System.getProperty("positionOfMaximumPrice")));
    }
    public void moveLeftSliderHandlerToSpecificRange(){
        moveSlider(sliderLeftHandler, Double.parseDouble(System.getProperty("minimumPrice")), getMinimumPriceRange());
    }
    public void moveRightSliderHandlerToSpecificRange(){
        getMaximumPriceRange();
        moveSlider(sliderRightHandler,Double.parseDouble(System.getProperty("maximumPrice")),getMaximumPriceRange());
    }
    public void scrollToPriceFilter(){
        scrollToElement(sliderRightHandler);
    }
    private void moveSlider(WebElement element, double price, double edge){
        while (price != edge){
            if(price > edge){
                wait.until(driver -> element.isEnabled());
                actions.clickAndHold(element).sendKeys(Keys.ARROW_RIGHT).perform();
                edge++;
            }
            else {
                wait.until(driver -> element.isEnabled());
                actions.clickAndHold(element).sendKeys(Keys.ARROW_LEFT).perform();
                edge--;
            }
        }
        wait.until(driver -> element.isEnabled());
    }
}
