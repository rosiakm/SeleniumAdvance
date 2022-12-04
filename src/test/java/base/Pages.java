package base;

import org.junit.jupiter.api.BeforeEach;
import pages.cart.CartPage;
import pages.menu.MyAccountPage;
import pages.menu.TopMenuPage;
import pages.products.*;
import pages.filters.FiltersPage;
import pages.logIn.LogInPage;
import pages.checkout.OrderDetailsPage;
import pages.checkout.OrderHistoryPage;
import pages.checkout.OrderSummaryPage;
import pages.checkout.CheckoutFormPage;

public class Pages extends TestBase{

    public ProductsGridPage productsGridPage;
    public FiltersPage filtersPage;
    public TopMenuPage topMenuPage;
    public CartPage cartPage;
    public AddToCartPopupPage addToCartPopupPage;
    public ProductDetailsPage productDetailsPage;
    public MyAccountPage myAccountPage;
    public LogInPage logInPage;
    public OrderDetailsPage orderDetailsPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderSummaryPage orderSummaryPage;
    public CheckoutFormPage checkoutFormPage;
    @BeforeEach
    public void setPageInstance(){
        productsGridPage = new ProductsGridPage(driver);
        filtersPage = new FiltersPage(driver);
        topMenuPage = new TopMenuPage(driver);
        cartPage = new CartPage(driver);
        addToCartPopupPage = new AddToCartPopupPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        myAccountPage = new MyAccountPage(driver);
        logInPage = new LogInPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        checkoutFormPage = new CheckoutFormPage(driver);
    }
}
