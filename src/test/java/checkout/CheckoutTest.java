package checkout;

import base.Pages;
import basket.BasketTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckoutTest extends Pages {
    Logger log = LoggerFactory.getLogger(BasketTest.class);
    SoftAssertions softly = new SoftAssertions();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String currentDate = LocalDate.now().format(formatter);

    @RepeatedTest(10)
    @Tag("checkout")
    public void checkoutTest() {
        topMenuPage.openLoginPage();
        logInPage.populateEmail()
                .populatePassword()
                .signIn();
        topMenuPage.moveToMainPage();
        productsGridPage.openProductByName(System.getProperty("basketPopupGenericProductName"));
        productDetailsPage.addProductToCart();
        Double price = addToCartPopupPage.getTotalPrice();
        addToCartPopupPage.openCart();
        cartPage.openShippingForm();
        checkoutFormPage.openInvoiceAddressForm()
                .populateInvoiceAddress()
                .openAddressTab();
        String selectedDeliveryAddress = checkoutFormPage.getSelectedDeliveryAddress();
        String selectedInvoiceAddress = checkoutFormPage.getSelectedInvoiceAddress();
        checkoutFormPage.openShippingMethodForm()
                .openPaymentForm()
                .selectPayByCheckMethod()
                .acceptTermsOfService()
                .placeOrder();
        orderSummaryPage.getOrderNumber();
        topMenuPage.openMyAccountMenu();
        myAccountPage.openOrderHistoryDetails();
        orderHistoryPage.openDetailsByName(orderSummaryPage.orderNumber);
        softly.assertThat(orderDetailsPage.getDate().equals(currentDate));
        softly.assertThat(price).isEqualTo(orderDetailsPage.getTotalPrice());
        softly.assertThat(orderDetailsPage.getDeliveryAddress()).isEqualTo(selectedDeliveryAddress);
        softly.assertThat(orderDetailsPage.getInvoiceAddress()).isEqualTo(selectedInvoiceAddress);
        softly.assertThat(orderDetailsPage.getPaymentStatusText()).isEqualTo(System.getProperty("paymentStatus"));
        softly.assertAll();
    }
}
