package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class MyAccountPage extends BasePage {
    Logger log = LoggerFactory.getLogger(MyAccountPage.class);

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#history-link span")
    private WebElement orderHistoryButton;

    public void openOrderHistoryDetails(){
        click(orderHistoryButton);
    }
}
