package base;

import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setPageInstance(){
        products = new Products(driver);
        productListHeader = new ProductListHeader(driver);
        price = new Price(driver);
        categories = new Categories(driver);
        search = new Search(driver);
    }
}
