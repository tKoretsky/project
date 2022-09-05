package Service;

import Model.Order;
import Model.Product;
import Model.User;
import WorkWithFiles.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    private FileManager<List<Product>> productsManager;
    private FileManager<List<Order>> ordersManager;
    private Scanner scanner;

    public void createOrder(User user) {
        showProducts();
        System.out.println("choose the car");
        scanner = new Scanner(System.in);
        String choice = scanner.next();
        List<Order> orders = new ArrayList<>();
        productsManager = new FileManager<>();
        ordersManager = new FileManager<>();
        orders = ordersManager.readFile("src/SimpleBD/orders.bin", orders);
        List<Product> cars = new ArrayList<>();
        cars = productsManager.readFile("src/SimpleBD/cars.bin", cars);
        orders.add(new Order(user, cars.get((Integer.parseInt(choice)-1))));
        ordersManager.writeFile("src/SimpleBD/orders.bin", orders);
        System.out.println("You ordered "+cars.get((Integer.parseInt(choice)-1)));
    }

    public void showOrders(User user) {

        System.out.println("Your order");
        List<Order> orders = new ArrayList<>();
        ordersManager = new FileManager<>();
        orders = ordersManager.readFile("src/SimpleBD/orders.bin", orders);
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCustomer().getUsername().contains(user.getUsername())) {
                System.out.println(orders.get(i).getCar());
            } else {
                System.out.println("You have not orders yet...");
            }
        }
    }

    public void showProducts() {
        System.out.println("List of cars: ");
        List<Product> cars = new ArrayList<>();
        productsManager = new FileManager<>();
        cars = productsManager.readFile("src/SimpleBD/cars.bin", cars);
        System.out.println(cars);

    }
}
