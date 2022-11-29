package pages.UpperMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesMenuPage extends BasePage {
    private Logger log = LoggerFactory.getLogger(CategoriesMenuPage.class);

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

    public CategoriesMenuPage(WebDriver driver){
        super(driver);
    }

    public void openArtCategory(){
        click(artButton);
    }
    public void moveToMainPage(){
        click(imageButton);
    }
    public List<String> getCategoryNames(){
        return getNames(categoryList);
    }
    public Map<String,WebElement> getCategoryButtonByName(){
        return getWebElementByName(getCategoryNames(),categoryList);
    }
    private Map<String,WebElement> getWebElementByName(List<String> name, List<WebElement> list){
        Map<String,WebElement> categories = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            categories.put(name.get(i), list.get(i));
        }
        return categories;
    }
}
