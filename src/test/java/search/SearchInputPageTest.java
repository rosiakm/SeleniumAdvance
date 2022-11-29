package search;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchInputPageTest extends Pages {
    private Logger log = LoggerFactory.getLogger(SearchInputPageTest.class);
    SoftAssertions softly = new SoftAssertions();

    @RepeatedTest(10)
    @DisplayName("Standard Search Test")
    @Tag("search")
    public void checkCompatibilityOfSearchedProductsTest(){
        String input = productsGridPage.getRandomProductName();
        searchInputPage.populateSearchInput(input);
        searchInputPage.openSearchResults();
        softly.assertThat(productsGridPage.getTheNumberOfProducts()).isEqualTo(Integer.parseInt(System.getProperty("expectedNumberOfProducts")));
        softly.assertThat(productsGridPage.getProductName()).isEqualTo(input);
        softly.assertAll();
    }

    @RepeatedTest(10)
    @DisplayName("Dropdown Search Test")
    @Tag("search")
    public void checkDropdownSearchPromptsTest(){
        searchInputPage.populateSearchInput(System.getProperty("searchInput"));
        for (String productName : searchInputPage.getProductNames()) {
            softly.assertThat(productName).contains(System.getProperty("searchInput"));
        }
        softly.assertAll();
    }
}
