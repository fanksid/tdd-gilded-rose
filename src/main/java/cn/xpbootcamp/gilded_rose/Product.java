package cn.xpbootcamp.gilded_rose;

public class Product {
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

    public int getSellIn() {
        return sellIn;
    }

    public int getInitialQuality() {
        return initialQuality;
    }

    public int getDecreaseStep() {
        return decreaseStep;
    }

    public String getType() {
        return type;
    }

    public int getCurrentQuality(int passedDays) {
        if ("Aged_Brie".equals(type)) {
            return Math.min(initialQuality + passedDays * calculateDecreaseStep(passedDays), 50);
        }
        return Math.max(initialQuality - passedDays * calculateDecreaseStep(passedDays), 0);
    }

    private int calculateDecreaseStep(int passedDays) {
        if (passedDays > sellIn) {
            return decreaseStep * 2;
        }
        return decreaseStep;
    }
}
