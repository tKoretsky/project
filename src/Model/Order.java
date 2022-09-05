package Model;

import java.io.Serializable;

public class Order implements Serializable {

    User customer;
    Product car;

    boolean isConfirmed = false;

    public Order(User customer, Product car) {
        this.customer = customer;
        this.car = car;
    }

    public User getCustomer() {
        return customer;
    }

    public Product getCar() {
        return car;
    }

    public void setConfirmed() {
        isConfirmed = true;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", car=" + car +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
