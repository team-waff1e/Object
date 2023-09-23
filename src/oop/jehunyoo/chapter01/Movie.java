package oop.jehunyoo.chapter01;

public class Movie {

    private String name;
    private int price;

    public Movie(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
