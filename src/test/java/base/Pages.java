package base;

import org.junit.jupiter.api.BeforeEach;
import pages.Cart.CartPage;
import pages.Content.AddToCartPopupPage;
import pages.Content.ProductDetailsPage;
import pages.Content.CategoryHeaderPage;
import pages.Content.ProductsGridPage;
import pages.Filters.FiltersPage;
import pages.UpperMenu.CategoriesMenuPage;
import pages.UpperMenu.SearchInputPage;
import pages.UpperMenu.UpperMenuPage;

public class Pages extends TestBase{

    public ProductsGridPage productsGridPage;
    public CategoryHeaderPage categoryHeaderPage;
    public FiltersPage filtersPage;
    public CategoriesMenuPage categoriesMenuPage;
    public SearchInputPage searchInputPage;
    public CartPage cartPage;
    public AddToCartPopupPage addToCartPopupPage;
    public ProductDetailsPage productDetailsPage;
    public UpperMenuPage upperMenuPage;
    @BeforeEach
    public void setPageInstance(){
        productsGridPage = new ProductsGridPage(driver);
        categoryHeaderPage = new CategoryHeaderPage(driver);
        filtersPage = new FiltersPage(driver);
        categoriesMenuPage = new CategoriesMenuPage(driver);
        searchInputPage = new SearchInputPage(driver);
        cartPage = new CartPage(driver);
        addToCartPopupPage = new AddToCartPopupPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        upperMenuPage = new UpperMenuPage(driver);
    }
}
