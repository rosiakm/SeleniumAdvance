package pages.UpperMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import java.util.List;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class Search extends BasePage {
    private Logger log = LoggerFactory.getLogger(Search.class);

    @FindBy(css = "input[type='text']")
    private WebElement searchInput;
    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;
    @FindBy(css = "#ui-id-1")
    private WebElement searchDropDownList;
    @FindBy(css = "#ui-id-1 span[class='product']")
    private List<WebElement> searchedItems;

    public Search (WebDriver driver){
        super(driver);
    }

    public void populateSearchInput(String input){
        sendKeys(searchInput, input);
    }
    public void clickSearchButton(){
        click(searchButton);
    }
    public List<String> createProductNameList(){
        waitForElementToBeVisible(driver, searchDropDownList);
        return getNames(searchedItems);
    }
}