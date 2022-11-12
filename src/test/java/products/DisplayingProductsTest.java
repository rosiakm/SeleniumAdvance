package products;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayingProductsTest extends Pages {
    private Logger log = LoggerFactory.getLogger(DisplayingProductsTest.class);
    SoftAssertions softly = new SoftAssertions();

    @RepeatedTest(10)
    @DisplayName("Categories test")
    @Tag("categories")
    public void checkTheCategoriesHeadersTest(){
        for (String categoryName : categories.getCategoryNames()) {
            log.info("My category name is: " + categoryName);
            categories.getCategoryButtonByName().get(categoryName).click();
            softly.assertThat(productListHeader.getCategoryLabelText()).isEqualTo(categoryName);
            int numberOfDisplayingProducts = products.getTheNumberOfProducts();
            softly.assertThat(products.getTextOfSearchSummary()).isEqualTo("There are " +
                    numberOfDisplayingProducts + " products.");
            softly.assertAll();
        }
    }

    @RepeatedTest(1)
    @DisplayName("Price filter test")
    @Tag("filters")
    public void checkPriceFilterTest(){
        categories.clickOnArtButton();
        price.scrollToPriceFilter();
        price.moveLeftSliderHandlerToSpecificRange();
        price.moveRightSliderHandlerToSpecificRange();
        products.scrollToProductDescription();
        for (double productPrice : products.getProductPriceList()) {
            softly.assertThat(productPrice).isBetween(Double.valueOf(System.getProperty("minimumPrice")),
                    Double.valueOf(System.getProperty("maximumPrice")));
        }
        softly.assertAll();
    }
}
