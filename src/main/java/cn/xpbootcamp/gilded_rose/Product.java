package cn.xpbootcamp.gilded_rose;

public class Product {
    private int sellIn;

    private int initialQuality;

    private int decreaseStep;

    public Product(int sellIn, int initialQuality, int decreaseStep) {
        this.sellIn = sellIn;
        this.initialQuality = initialQuality;
        this.decreaseStep = decreaseStep;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getInitialQuality() {
        return initialQuality;
    }

    public void setInitialQuality(int initialQuality) {
        this.initialQuality = initialQuality;
    }

    public int getDecreaseStep() {
        return decreaseStep;
    }

    public void setDecreaseStep(int decreaseStep) {
        this.decreaseStep = decreaseStep;
    }

    public int getCurrentQuality(int passedDays) {
        int currentQuality = initialQuality - passedDays * decreaseStep;
        return Math.max(currentQuality, 0);
    }
}
