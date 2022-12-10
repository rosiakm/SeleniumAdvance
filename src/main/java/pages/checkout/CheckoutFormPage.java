package pages.checkout;

import models.builders.Address;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import static helpers.WaitHandler.waitForElementToBeClickable;

public class CheckoutFormPage extends BasePage {
    Logger log = LoggerFactory.getLogger(CheckoutFormPage.class);
    public CheckoutFormPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a[data-link-action='different-invoice-address']")
    private WebElement differentAddressLink;
    @FindBy(css = "input[name='address1']")
    private WebElement addressInput;
    @FindBy(css = "input[name='postcode']")
    private WebElement postalInput;
    @FindBy(css = "input[name='city']")
    private WebElement cityInput;
    @FindBy(css = "button[name='confirm-addresses']")
    private WebElement continueButton;
    @FindBy(css = "#checkout-addresses-step")
    private WebElement addressTab;
    @FindBy(css = "#delivery-addresses .selected .address")
    private WebElement selectedDeliveryAddress;
    @FindBy(css = "#invoice-addresses .selected .address")
    private WebElement selectedInvoiceAddress;
    @FindBy(css = "button[name='confirmDeliveryOption']")
    private WebElement confirmDeliveryButton;
    @FindBy(css = "#payment-option-1")
    private WebElement payByCheckRadioButton;
    @FindBy(css = ".custom-checkbox")
    private WebElement approveTermsCheckbox;
    @FindBy(css = "#payment-confirmation button")
    private WebElement placeOrderButton;

    public CheckoutFormPage openInvoiceAddressForm(){
        click(differentAddressLink);
        return this;
    }
    public CheckoutFormPage populateInvoiceAddress(Address address){
        try {
            sendKeys(addressInput, address.getAddress());
            sendKeys(postalInput, address.getZipCode());
            sendKeys(cityInput, address.getCity());
            click(continueButton);
        }
        catch (NoSuchElementException e){
            click(continueButton);
        }
        return this;
    }
    public CheckoutFormPage openShippingMethodForm(){
        waitForElementToBeClickable(driver,continueButton);
        click(continueButton);
        return this;
    }
    public void openAddressTab(){
        click(addressTab);
    }
    public String getSelectedDeliveryAddress(){
        return getTextOfWebElement(selectedDeliveryAddress);
    }
    public String getSelectedInvoiceAddress(){
        waitForElementToBeClickable(driver,selectedInvoiceAddress);
        return getTextOfWebElement(selectedInvoiceAddress);
    }
    public CheckoutFormPage openPaymentForm(){
        click(confirmDeliveryButton);
        return this;
    }
    public CheckoutFormPage selectPayByCheckMethod(){
        click(payByCheckRadioButton);
        return this;
    }
    public CheckoutFormPage acceptTermsOfService(){
        click(approveTermsCheckbox);
        return this;
    }
    public void placeOrder(){
        click(placeOrderButton);
    }
}
