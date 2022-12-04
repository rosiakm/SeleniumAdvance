package basket;

import base.Pages;
import models.Cart;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest extends Pages {
    Logger log = LoggerFactory.getLogger(BasketTest.class);
    SoftAssertions softly = new SoftAssertions();

    @RepeatedTest(10)
    @Tag("popup")
    @Tag("basket")
    public void popupTest() {
        topMenuPage.openArtCategory();
        productsGridPage.openProductByName(System.getProperty("basketPopupGenericProductName"));
        productDetailsPage.setQuantity(System.getProperty("basketPopupGenericQuantity"));
        Double productPrice = productDetailsPage.getProductPrice();
        productDetailsPage.addProductToCart();
        softly.assertThat(addToCartPopupPage.getProductName()).isEqualTo(System.getProperty("basketPopupGenericProductName"));
        softly.assertThat(addToCartPopupPage.getProductPrice()).isEqualTo(productPrice);
        softly.assertThat(addToCartPopupPage.getTotalPrice()).isEqualTo((productPrice) *
                Double.parseDouble(System.getProperty("basketPopupGenericQuantity")) +
                Double.parseDouble(System.getProperty("shippingPrice"))
        );
        log.info("My total price is: " + System.getProperty("currency") + addToCartPopupPage.getTotalPrice());
        softly.assertAll();
    }

    @RepeatedTest(10)
    @Tag("Cart")
    @Tag("Basket")
    public void basketCalculationTest() {
        Cart expectedCart = new Cart();

        for (int i = 0; i < Integer.parseInt(System.getProperty("basketCalculationsTestIterations")); i++) {
            productsGridPage.openRandomProductDetails();
            productDetailsPage.setRandomQuantity(Integer.parseInt(System.getProperty("minQuantity")),
                            Integer.parseInt(System.getProperty("maxQuantity")))
                    .addProductToCart(expectedCart);
            addToCartPopupPage.continueShopping();
            topMenuPage.moveToMainPage();
        }
        topMenuPage.openCart();
        Cart actualCart = cartPage.toCart();
        assertThat(actualCart).usingRecursiveComparison().isEqualTo(expectedCart);
    }
}
