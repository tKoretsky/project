package View;

import Model.User;
import Service.ProductService;

import java.util.Scanner;

public class UserMenu implements MenuManager {
    final String SHOW_PRODUCTS = "1";
    final String SHOW_ORDERS = "2";
    final String CREATE_ORDER = "3";
    private boolean isRunning = true;
    private Scanner scanner;


    @Override
    public void startMenu(User user) {

        System.out.println("1. All cars" +
                "\n2. Your ordrers" +
                "\n3. New order"+
                "\n--------------------");

        scanner = new Scanner(System.in);
        //logic
        while (isRunning) {
            String choice = scanner.next();
            switch (choice) {
                case SHOW_PRODUCTS:
                    new ProductService().showProducts();
                    exit();
                    break;
                case SHOW_ORDERS:
                    new ProductService().showOrders(user);
                    exit();
                    break;
                case CREATE_ORDER:
                    new ProductService().createOrder(user);
                    exit();
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    @Override
    public void startMenu() {

    }

    @Override
    public void exit() {
        isRunning = false;
    }
}
