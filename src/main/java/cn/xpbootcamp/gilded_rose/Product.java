package cn.xpbootcamp.gilded_rose;

public class Product {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private int sellIn;

    private int initialQuality;

    private int decreaseStep;

    private String type;

    public Product(int sellIn, int initialQuality, int decreaseStep) {
        this.sellIn = sellIn;
        this.initialQuality = initialQuality;
        this.decreaseStep = decreaseStep;
    }

    public Product(String type, int sellIn, int initialQuality, int decreaseStep) {
        this(sellIn, initialQuality, decreaseStep);
        this.type = type;
    }

    public int getCurrentQuality(int passedDays) {
        int changedQuality = passedDays * calculateDecreaseStep(passedDays);

        if ("Aged_Brie".equals(type)) {
            return Math.min(initialQuality + changedQuality, MAX_QUALITY);
        }
        return Math.max(initialQuality - changedQuality, MIN_QUALITY);
    }

    private int calculateDecreaseStep(int passedDays) {
        if (passedDays > sellIn) {
            return decreaseStep * 2;
        }
        return decreaseStep;
    }
}
