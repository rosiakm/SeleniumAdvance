package mouse;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MouseHoverTest extends Pages {

    @Test
    @Tag("mouse")
    @DisplayName("EventFiringMouse test - category")
    public void hoverOverClothesCategoryTest() {
        topMenuPage.moveMouseToClothesCategory()
                .moveMouseToMenClothesCategory()
                .openMenClothesCategoryUsingMouse();
        assertThat(productsGridPage.getCategoryDescription()).isEqualTo(System.getProperty("menCategoryText"));
    }

    @Test
    @Tag("mouse")
    @DisplayName("EventFiringMouse test - accessories")
    public void hoverOverAccessoriesCategoryTest() {
        topMenuPage.moveMouseToAccessoriesCategory()
                .moveMouseToStationeryAccessoriesCategory()
                .openStationeryAccessoriesCategoryUsingMouse();
        assertThat(productsGridPage.getCategoryDescription()).isEqualTo(System.getProperty("stationeryCategoryText"));
    }

    @Test
    @Tag("mouse")
    @DisplayName("EventFiringMouse test - art")
    public void hoverOverArtCategoryTest() {
        topMenuPage.moveMouseToArtCategory()
                .openArtCategoryUsingMouse();
        assertThat(productsGridPage.getCategoryDescription()).isEqualTo(System.getProperty("artCategoryText"));
    }
}
