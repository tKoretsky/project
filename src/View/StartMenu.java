package View;

import Model.User;
import Service.UserService;

import java.util.Scanner;


public class StartMenu implements MenuManager, UserManager {

    final String LOGIN_MENU = "1";
    final String REGISTRATION_MENU = "2";
    private boolean isRunning = true;
    private Scanner scanner;

    @Override
    public void startMenu() {
        System.out.println("Hello, Welcome to Car Sale\n"+"--------------------"+"" +
                "\n1. Login\n2. Registration\n--------------------");
        scanner = new Scanner(System.in);


        while (isRunning) {
            String choice = scanner.next();
            switch (choice) {
                case LOGIN_MENU:
                    login();
                    break;
                case REGISTRATION_MENU:
                    registration();
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
    public void exit() {
        isRunning = false;
    }

    @Override
    public void login() {
        System.out.println("Login Menu\n--------------------");
        System.out.print("Login: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String pass = scanner.next();
        exit();
        if (username.equals("admin") && pass.equals("admin")) {
            new AdminMenu().startMenu();
        } else {
            new UserMenu().startMenu(new UserService().login(username, pass));
        }
    }

    @Override
    public void registration() {
        System.out.println("Registration Menu\n--------------------");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Login: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String pass = scanner.next();
        exit();
        new UserMenu().startMenu(new UserService().registration(name, username, pass));
    }

    @Override
    public void startMenu(User user) {

    }

}
