package pages.Cart;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

public class CartPage extends BasePage {
    Logger log = LoggerFactory.getLogger(CartPage.class);



    public CartPage(WebDriver driver){
        super(driver);
    }

}
