package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    private String address;
    private int area;
    private int levelNumber;
    private final int PRICE = 100;

    public Office(String address, int area, int levelNumber) {
        this.address = address;
        this.area = area;
        this.levelNumber = levelNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getPRICE() {
        return PRICE;
    }

    @Override
    public int clean() {
        return area * levelNumber * PRICE;
    }
}
