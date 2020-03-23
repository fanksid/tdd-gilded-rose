package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;
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
}
