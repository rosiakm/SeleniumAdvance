package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebListener extends AbstractWebDriverEventListener {
    Logger log = LoggerFactory.getLogger(WebListener.class);
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("*********** Event listener before click" + element.getText());
    }
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info("*********** Event listener after click" + element.getText());
    }
}
