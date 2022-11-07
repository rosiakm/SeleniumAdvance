package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static Logger log = LoggerFactory.getLogger(TestBase.class);

    public WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        log.info("WebDriver started successfully");
    }

    @BeforeEach
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        log.info("Maximized browser opened successfully");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        log.info("WebDriver closed");
    }
}
