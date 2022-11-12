package base;

import helpers.yamlConfigFramework.DriverSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.YamlProvider;

public class TestBase {
    private static Logger log = LoggerFactory.getLogger(TestBase.class);

    public WebDriver driver;
    private static DriverSetup driverSetup;
    private static YamlProvider yamlProvider;

    @BeforeAll
    public static void setupDriver() {
        yamlProvider = YamlProvider.getInstance();
        driverSetup = new DriverSetup();
        log.info("WebDriver started successfully");
    }

    @BeforeEach
    public void setupBrowser() {
        driver = driverSetup.getDriver();
        log.info("<<<<<<Driver initialized>>>>>>");
        driver.get(System.getProperty("appUrl"));
        log.info("<<<<<<Loaded url: " + System.getProperty("appUrl") + ">>>>>>");
        log.info("Maximized browser opened successfully");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        log.info("<<<<<<Driver has been quit>>>>>>");
    }
}
