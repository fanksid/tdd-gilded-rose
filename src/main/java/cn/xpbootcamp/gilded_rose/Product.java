package cn.xpbootcamp.gilded_rose;

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
        int changedQuality = passedDays * calculateStep(passedDays);

        if ("Sulfuras".equals(type)) {
            return initialQuality;
        }

        if ("Aged_Brie".equals(type) || "Backstage_Pass".equals(type)) {
            return Math.min(initialQuality + changedQuality, MAX_QUALITY);
        }
        return Math.max(initialQuality - changedQuality, MIN_QUALITY);
    }

    private int calculateStep(int passedDays) {
        int decreaseStep = 1;
        if ("Backstage_Pass".equals(type) && sellIn - passedDays > 5 && sellIn - passedDays <= 10) {
            return 2;
        }
        if (passedDays > sellIn) {
            return decreaseStep * 2;
        }
        return decreaseStep;
    }
}
