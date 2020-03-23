package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    @Test
    void should_return_quality_no_less_than_0_given_many_days_passed() {
        Product product = new Product(50, 20, 2);

        int quality = product.getCurrentQuality(30);

        assertTrue(quality >= 0);
    }

    @Test
    void should_return_quality_no_more_than_50_given_few_days_passed() {
        Product product = new Product(50, 20, 2);

        int quality = product.getCurrentQuality(0);

        assertTrue(quality <= 50);
    }

    @Test
    void should_quality_of_many_days_passed_less_than_one_of_few_days_passed() {
        Product product = new Product(50, 20, 2);

        int qualityOfFewDays = product.getCurrentQuality(0);
        int qualityOfManyDays = product.getCurrentQuality(20);

        assertTrue(qualityOfFewDays > qualityOfManyDays);
    }

    @Test
    void should_quality_decrease_twice_when_after_sell_in_date() {
        Product product = new Product(20, 50, 1);

        int decreasedQualityBeforeSellIn = product.getCurrentQuality(2) - product.getCurrentQuality(1);
        int decreasedQualityAfterSellIn = product.getCurrentQuality(22) - product.getCurrentQuality(21);

        assertEquals(2, decreasedQualityAfterSellIn / decreasedQualityBeforeSellIn);
    }
}
