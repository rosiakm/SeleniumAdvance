package pages.UpperMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

public class UpperMenuPage extends BasePage {
    Logger log = LoggerFactory.getLogger(UpperMenuPage.class);

    @FindBy(css = ".blockcart")
    private WebElement cartButton;

    public UpperMenuPage(WebDriver driver){
        super(driver);
    }

    public void openCart(){
        click(cartButton);
    }
}
