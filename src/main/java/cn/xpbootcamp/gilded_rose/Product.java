package cn.xpbootcamp.gilded_rose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Product {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private int sellIn;

    private int initialQuality;

    private String type;

    public Product(int sellIn, int initialQuality) {
        this.sellIn = sellIn;
        this.initialQuality = initialQuality;
    }

    public Product(String type, int sellIn, int initialQuality) {
        this(sellIn, initialQuality);
        this.type = type;
    }

    public int getCurrentQuality(int passedDays) {
        if ("Sulfuras".equals(type)) {
            return initialQuality;
        }

        int changedQuality = passedDays * calculateStep(passedDays);
        int increasedQuality = min(initialQuality + changedQuality, MAX_QUALITY);
        if ("Backstage_Pass".equals(type)) {
            return passedDays > sellIn ? 0 : increasedQuality;
        }

        if ("Aged_Brie".equals(type)) {
            return increasedQuality;
        }

        return max(initialQuality - changedQuality, MIN_QUALITY);
    }

    private int calculateStep(int passedDays) {
        int leftDays = sellIn - passedDays;
        if ("Backstage_Pass".equals(type) && leftDays > 5 && leftDays <= 10) {
            return 2;
        }
        if ("Backstage_Pass".equals(type) && leftDays >= 0 && leftDays <= 5) {
            return 3;
        }

        if (passedDays > sellIn) {
            return 2;
        }
        return 1;
    }
}
