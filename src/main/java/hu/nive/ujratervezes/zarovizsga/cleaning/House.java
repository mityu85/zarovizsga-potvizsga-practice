package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int area;
    private final int PRICE = 80;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getPRICE() {
        return PRICE;
    }

    @Override
    public int clean() {
        return area * PRICE;
    }
}
