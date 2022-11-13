package base;

import org.junit.jupiter.api.BeforeEach;
import pages.Cart.CartPage;
import pages.Content.Popup;
import pages.Content.ProductDetails;
import pages.Content.ProductListHeader;
import pages.Content.Products;
import pages.Filters.Price;
import pages.UpperMenu.Categories;
import pages.UpperMenu.Search;

public class Pages extends TestBase{

    public Products products;
    public ProductListHeader productListHeader;
    public Price price;
    public Categories categories;
    public Search search;
    public CartPage cartPage;
    public Popup popup;
    public ProductDetails productDetails;

    @BeforeEach
    public void setPageInstance(){
        products = new Products(driver);
        productListHeader = new ProductListHeader(driver);
        price = new Price(driver);
        categories = new Categories(driver);
        search = new Search(driver);
        cartPage = new CartPage(driver);
        popup = new Popup(driver);
        productDetails = new ProductDetails(driver);
    }
}
