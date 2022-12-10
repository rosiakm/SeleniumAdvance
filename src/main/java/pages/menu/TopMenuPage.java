package pages.menu;

import models.Categories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class TopMenuPage extends BasePage {
    Logger log = LoggerFactory.getLogger(TopMenuPage.class);

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".blockcart")
    private WebElement cartButton;
    @FindBy(css = "#_desktop_user_info .hidden-sm-down")
    private WebElement signInButton;
    @FindBy(css = "#_desktop_user_info .account")
    private WebElement myAccountLink;
    @FindBy(css = "input[type='text']")
    private WebElement searchInput;
    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;
    @FindBy(css = "#ui-id-1")
    private WebElement searchDropDownList;
    @FindBy(css = "#ui-id-1 span[class='product']")
    private List<WebElement> searchedItems;
    @FindBy(css = "#category-3")
    private WebElement clothesButton;
    @FindBy(css = "#category-4")
    private WebElement menClothesButton;
    @FindBy(css = "#category-6")
    private WebElement accessoriesButton;
    @FindBy(css = "#category-7")
    private WebElement stationeryAccessoriesButton;
    @FindBy(css = "#category-9")
    private WebElement artButton;
    @FindBy(css = "#top-menu >li")
    private List<WebElement> categoryList;
    @FindBy(css = "img[alt='TesterSii']")
    private WebElement imageButton;

    public void openCategory(Categories category){
        switch (category)
        {
            case CLOTHES -> {
                click(clothesButton);
                break;
            }
            case ACCESSORIES -> {
                click(accessoriesButton);
                break;
            }
            case ART -> {
                click(artButton);
                break;
            }
        }
    }
    public void openCart() {
        click(cartButton);
    }
    public void openLoginPage() {
        click(signInButton);
    }

    public void openMyAccountMenu() {
        click(myAccountLink);
    }
    public TopMenuPage populateSearchInput(String input) {
        sendKeys(searchInput, input);
        return this;
    }
    public void openSearchResults() {
        click(searchButton);
    }

    public List<String> getProductNames() {
        waitForElementToBeVisible(driver, searchDropDownList);
        return getNames(searchedItems);
    }

    public void moveToMainPage() {
        click(imageButton);
    }

    public List<String> getCategoryNames() {
        return getNames(categoryList);
    }
    public Map<String, WebElement> getCategoryButtonByName() {
        return getWebElementByName(getCategoryNames(), categoryList);
    }
    private Map<String, WebElement> getWebElementByName(List<String> name, List<WebElement> list) {
        Map<String, WebElement> categories = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            categories.put(name.get(i), list.get(i));
        }
        return categories;
    }
    public TopMenuPage moveMouseTo(Categories category){
        switch (category)
        {
            case CLOTHES -> {
                mouseHover(clothesButton);
                break;
            }
            case ACCESSORIES -> {
                mouseHover(accessoriesButton);
                break;
            }
            case ART -> {
                mouseHover(artButton);
                break;
            }
            case MEN -> {
                mouseHover(menClothesButton);
                break;
            }
            case STATIONERY -> {
                mouseHover(stationeryAccessoriesButton);
                break;
            }
        }
        return this;
    }
    public void openCategoryUsingMouse(Categories category){
        switch (category)
        {
            case MEN -> {
                clickUsingMouse(menClothesButton);
                break;
            }
            case STATIONERY -> {
                clickUsingMouse(stationeryAccessoriesButton);
                break;
            }
            case ART -> {
                clickUsingMouse(artButton);
                break;
            }
        }
    }
}

