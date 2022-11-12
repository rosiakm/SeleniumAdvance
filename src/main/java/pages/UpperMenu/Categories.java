package pages.UpperMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import java.util.List;
import java.util.Map;

public class Categories extends BasePage {
    private Logger log = LoggerFactory.getLogger(Categories.class);

    @FindBy(css = "#category-3")
    private WebElement clothesButton;
    @FindBy(css = "#category-6")
    private WebElement accessoriesButton;
    @FindBy(css = "#category-9")
    private WebElement artButton;
    @FindBy(css = "#top-menu >li")
    private List<WebElement> categoryList;
    @FindBy(css = "img[alt='TesterSii']")
    private WebElement imageButton;

    public Categories(WebDriver driver){
        super(driver);
    }

    public void clickOnClothesButton(){
        click(clothesButton);
    }
    public void clickOnAccessoriesButton(){
        click(accessoriesButton);
    }
    public void clickOnArtButton(){
        click(artButton);
    }
    public void clickOnImageButton(){
        click(imageButton);
    }
    public List<String> getCategoryNames(){
        return getNames(categoryList);
    }
    public Map<String,WebElement> getCategoryButtonByName(){
        return getWebElementByName(getCategoryNames(),categoryList);
    }
}
