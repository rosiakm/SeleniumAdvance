package basket;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketTest extends Pages {
    Logger log = LoggerFactory.getLogger(BasketTest.class);
    SoftAssertions softly = new SoftAssertions();

    @RepeatedTest(10)
    @Tag("popup")
    @Tag("basket")
    public void popupTest(){
        categories.clickOnArtButton();
        products.waitForProductToBeClickable();
        products.openProduct(System.getProperty("basketPopupGenericProductName"));
        productDetails.waitForQuantityInputToBeClickable();
        Double productPrice = productDetails.getProductPrice();
        productDetails.setQuantityInput(System.getProperty("basketPopupGenericQuantity"));
        productDetails.clickOnAddToCartButton();
        popup.waitForProceedToCheckoutButtonToBeClickable();
        softly.assertThat(popup.getProductName()).isEqualTo(System.getProperty("basketPopupGenericProductName"));
        softly.assertThat(popup.getProductPrice()).isEqualTo(productPrice);
        softly.assertThat(popup.getTotalPrice()).isEqualTo((productPrice)*
                Double.parseDouble(System.getProperty("basketPopupGenericQuantity"))+
                Double.parseDouble(System.getProperty("shippingPrice"))
        );
        log.info("My total price is: " + System.getProperty("currency") + popup.getTotalPrice());
        softly.assertAll();
    }
}
