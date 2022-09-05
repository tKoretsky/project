package Model;

import java.io.Serializable;

public class Product implements Serializable {
    private String brand;
    private String model;
    private String color;
    private double price;
    private int year;


    public Product(String brand, String model, String color, double price, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "[" +
                "<" + brand +" "+
                model + '>' +
                ",<" + color + '>' +
                ", Price= $" + price +
                ", Year=" + year +
                ']'+"\n";
    }
}
