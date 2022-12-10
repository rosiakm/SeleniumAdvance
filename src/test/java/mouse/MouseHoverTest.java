package mouse;

import base.Pages;
import models.Categories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MouseHoverTest extends Pages {

    @Test
    @Tag("mouse")
    @DisplayName("EventFiringMouse test - category")
    public void hoverOverClothesCategoryTest() {
        topMenuPage.moveMouseTo(Categories.CLOTHES)
                .moveMouseTo(Categories.MEN)
                .openCategoryUsingMouse(Categories.MEN);
        assertThat(productsGridPage.getCategoryDescription()).isEqualTo(System.getProperty("menCategoryText"));
    }

    @Test
    @Tag("mouse")
    @DisplayName("EventFiringMouse test - accessories")
    public void hoverOverAccessoriesCategoryTest() {
        topMenuPage.moveMouseTo(Categories.ACCESSORIES)
                .moveMouseTo(Categories.STATIONERY)
                .openCategoryUsingMouse(Categories.STATIONERY);
        assertThat(productsGridPage.getCategoryDescription()).isEqualTo(System.getProperty("stationeryCategoryText"));
    }

    @Test
    @Tag("mouse")
    @DisplayName("EventFiringMouse test - art")
    public void hoverOverArtCategoryTest() {
        topMenuPage.moveMouseTo(Categories.ART)
                .openCategoryUsingMouse(Categories.ART);
        assertThat(productsGridPage.getCategoryDescription()).isEqualTo(System.getProperty("artCategoryText"));
    }
}
