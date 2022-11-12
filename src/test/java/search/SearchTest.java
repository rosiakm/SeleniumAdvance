package search;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchTest extends Pages {
    private Logger log = LoggerFactory.getLogger(SearchTest.class);
    SoftAssertions softly = new SoftAssertions();

    @RepeatedTest(10)
    @DisplayName("Standard Search Test")
    @Tag("search")
    public void checkCompatibilityOfSearchedProductsTest(){
        String input = products.getRandomProductName();
        search.populateSearchInput(input);
        search.clickSearchButton();
        softly.assertThat(products.getTheNumberOfProducts()).isEqualTo(Integer.parseInt(System.getProperty("expectedNumberOfProducts")));
        softly.assertThat(products.getProductName()).isEqualTo(input);
        softly.assertAll();
    }

    @RepeatedTest(10)
    @DisplayName("Dropdown Search Test")
    @Tag("search")
    public void checkDropdownSearchPromptsTest(){
        search.populateSearchInput(System.getProperty("searchInput"));
        for (String productName : search.createProductNameList()) {
            softly.assertThat(productName).contains(System.getProperty("searchInput"));
        }
        softly.assertAll();
    }
}
