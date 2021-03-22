package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {
    private String address;
    private int area;
    private int level;
    private final int PRICE = 100;

    public Office(String address, int area, int level) {
        this.address = address;
        this.area = area;
        this.level = level;
    }

    @Override
    public int clean() {
        return area * level * PRICE;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Office{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", level=" + level +
                '}';
    }
}
