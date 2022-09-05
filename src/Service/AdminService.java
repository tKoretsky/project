package Service;

import Model.Order;
import Model.Product;
import Model.User;
import WorkWithFiles.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    private FileManager<List<Product>> productsManager;
    private FileManager<List<Order>> ordersManager;
    private FileManager<List<User>> usersManager;

    private Scanner scanner;

    public void addNewCar() {
        productsManager = new FileManager<>();
        List<Product> cars = new ArrayList<>();
        cars = productsManager.readFile("src/SimpleBD/cars.bin", cars);

        scanner = new Scanner(System.in);

        System.out.println("Brand: ");
        String brand = scanner.next();
        System.out.println("Model: ");
        String model = scanner.next();
        System.out.println("Color: ");
        String color = scanner.next();
        System.out.println("Price: ");
        double price = scanner.nextDouble();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        Product newCar = new Product(brand, model, color, price, year);

        cars.add(newCar);
        productsManager.writeFile("src/SimpleBD/cars.bin", cars);
    }

    public void changePrice() {
        new ProductService().showProducts();
        scanner = new Scanner(System.in);
        System.out.println("Choose the car: ");
        int index = scanner.nextInt();

        productsManager = new FileManager<>();
        List<Product> cars = new ArrayList<>();
        cars = productsManager.readFile("src/SimpleBD/cars.bin", cars);
        System.out.println("Set price");
        Double price = scanner.nextDouble();
        cars.get(index).setPrice(price);
        System.out.println("Price changed");
    }

    public void block_unblock() {
        scanner = new Scanner(System.in);
        usersManager = new FileManager<>();
        List<User> users = new ArrayList<>();
        users = usersManager.readFile("src/SimpleBD/users.bin", users);
        System.out.println(users);
        System.out.println("choose user to block or unblock");
        int index = scanner.nextInt();
        if (index == 1) {
            users.get(index).setBlocked(true);
        }
        if (index == 2) {
            users.get(index).setBlocked(false);
        }

    }

    public void confirm() {
        scanner = new Scanner(System.in);
        ordersManager = new FileManager<>();
        List<Order> orders = new ArrayList<>();
        orders = ordersManager.readFile("src/SimpleBD/orders.bin", orders);
        System.out.println(orders);
        System.out.println("choose order to confirm");
        int index = scanner.nextInt();
        orders.get(index).setConfirmed();
    }
}
