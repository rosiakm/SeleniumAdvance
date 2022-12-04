package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class OrderDetailsPage extends BasePage {
    Logger log = LoggerFactory.getLogger(OrderDetailsPage.class);

    public OrderDetailsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//section[@id='order-history']//tbody//td[1]")
    private WebElement dateText;
    @FindBy(xpath = "//section[@id='order-history']//tbody//span")
    private WebElement paymentStatusText;
    @FindBy(xpath = "//tr[@class='text-xs-right line-total']/td[2]")
    private WebElement totalPriceText;
    @FindBy(css = "#delivery-address address")
    private WebElement deliveryAddressText;
    @FindBy(css = "#invoice-address address")
    private WebElement invoiceAddressText;

    public String getDate(){
        return getTextOfWebElement(dateText);
    }
    public String getPaymentStatusText(){
        return getTextOfWebElement(paymentStatusText);
    }
    public Double getTotalPrice(){
        return getPrice(totalPriceText);
    }
    public String getDeliveryAddress(){
        return getTextOfWebElement(deliveryAddressText);
    }
    public String getInvoiceAddress(){
        return getTextOfWebElement(invoiceAddressText);
    }
}
