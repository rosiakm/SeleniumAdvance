package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class OrderSummaryPage extends BasePage {
    Logger log = LoggerFactory.getLogger(OrderSummaryPage.class);

    public OrderSummaryPage(WebDriver driver){
        super(driver);
    }
    public String orderNumber = "";

    @FindBy(xpath = "//div[@id='order-details']//li[1]")
    private WebElement orderNumberText;

    public String getOrderNumber(){
        orderNumber = orderNumberText.getText().replace("Order reference: ","");
        return orderNumber;
    }

}
