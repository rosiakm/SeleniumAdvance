package pages.Cart;

import models.Cart;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Base.BasePage;

import java.util.List;

public class CartPage extends BasePage {
    Logger log = LoggerFactory.getLogger(CartPage.class);

    @FindBy(css = ".js-cart-line-product-quantity")
    private List<WebElement> quantityList;
    @FindBy(css = ".cart-item")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public Cart toCart(){
        Cart cart = new Cart();
        for (WebElement cartItem : cartItems){
            cart.addProduct(new Product(cartItem));
        }
        return cart;
    }
}
