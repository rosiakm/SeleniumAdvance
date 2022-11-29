package products;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayingProductsTestGridPage extends Pages {
    private Logger log = LoggerFactory.getLogger(DisplayingProductsTestGridPage.class);
    SoftAssertions softly = new SoftAssertions();

    @RepeatedTest(10)
    @DisplayName("Categories test")
    @Tag("categories")
    public void checkTheCategoriesHeadersTest(){
        for (String categoryName : categoriesMenuPage.getCategoryNames()) {
            log.info("My category name is: " + categoryName);
            categoriesMenuPage.getCategoryButtonByName().get(categoryName).click();
            softly.assertThat(categoryHeaderPage.getCategoryLabelText()).isEqualTo(categoryName);
            int numberOfDisplayingProducts = productsGridPage.getTheNumberOfProducts();
            softly.assertThat(productsGridPage.getTextOfSearchSummary()).isEqualTo("There are " +
                    numberOfDisplayingProducts + " products.");
        }
        softly.assertAll();
    }

    @RepeatedTest(10)
    @DisplayName("Price filter test")
    @Tag("filters")
    public void checkPriceFilterTest(){
        categoriesMenuPage.openArtCategory();
        filtersPage.scrollToPriceFilter();
        filtersPage.moveLeftSliderHandlerToSpecificRange();
        filtersPage.moveRightSliderHandlerToSpecificRange();
        productsGridPage.scrollToProductDescription();
        for (double productPrice : productsGridPage.getProductPrices()) {
            softly.assertThat(productPrice).isBetween(Double.valueOf(System.getProperty("minimumPrice")),
                    Double.valueOf(System.getProperty("maximumPrice")));
        }
        softly.assertAll();
    }
}
