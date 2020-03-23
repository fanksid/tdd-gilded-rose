package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    @Test
    void should_return_quality_no_less_than_0_given_many_days_passed() {
        Product product = new Product(50, 20);

        int quality = product.getCurrentQuality(30);

        assertTrue(quality >= 0);
    }

    @Test
    void should_return_quality_no_more_than_50_given_few_days_passed() {
        Product product = new Product(50, 20);

        int quality = product.getCurrentQuality(0);

        assertTrue(quality <= 50);
    }

    @Test
    void should_quality_of_many_days_passed_less_than_one_of_few_days_passed() {
        Product product = new Product(50, 20);

        int qualityOfFewDays = product.getCurrentQuality(0);
        int qualityOfManyDays = product.getCurrentQuality(20);

        assertTrue(qualityOfFewDays > qualityOfManyDays);
    }

    @Test
    void should_quality_decrease_twice_when_after_sell_in_date() {
        Product product = new Product(20, 50);

        int decreasedQualityBeforeSellIn = product.getCurrentQuality(2) - product.getCurrentQuality(1);
        int decreasedQualityAfterSellIn = product.getCurrentQuality(22) - product.getCurrentQuality(21);

        assertEquals(2, decreasedQualityAfterSellIn / decreasedQualityBeforeSellIn);
    }

    @Test
    void should_quality_increase_when_Aged_Brie_passed_days_increase() {
        Product product = new Product("Aged_Brie", 20, 40);

        int qualityOfFewDays = product.getCurrentQuality(1);
        int qualityOfManyDays = product.getCurrentQuality(2);

        assertTrue(qualityOfFewDays >= 0);
        assertTrue(qualityOfFewDays <= 50);
        assertTrue(qualityOfManyDays >= 0);
        assertTrue(qualityOfManyDays <= 50);
        assertTrue(qualityOfFewDays < qualityOfManyDays);
    }

    @Test
    void should_quality_increase_but_less_than_50_when_Aged_Brie_passed_days_increase() {
        Product product = new Product("Aged_Brie", 20, 40);

        int qualityOfManyDays = product.getCurrentQuality(20);

        assertTrue(qualityOfManyDays >= 0);
        assertTrue(qualityOfManyDays <= 50);
    }

    @Test
    void should_quality_no_change_for_Sulfuras_given_different_passed_days() {
        Product product = new Product("Sulfuras", 20, 40);

        int qualityOfFewDays = product.getCurrentQuality(10);
        int qualityOfManyDays = product.getCurrentQuality(200);

        assertEquals(qualityOfFewDays, qualityOfManyDays);
    }

    @Test
    void should_quality_of_Backstage_Pass_increase_2_everyday_before_10_days_of_sell_in() {
        Product product = new Product("Backstage_Pass", 20, 10);

        int qualityOfFewDays = product.getCurrentQuality(12);
        int qualityOfManyDays = product.getCurrentQuality(13);

        assertEquals(2, qualityOfManyDays - qualityOfFewDays);
    }
}
