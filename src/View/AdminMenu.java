package View;

import Model.User;
import Service.AdminService;

import java.util.Scanner;

public class AdminMenu implements MenuManager {

    final String ADD_NEW_CAR = "1";
    final String CHANGE_PRICE = "2";
    final String BLOCK_UNBLOCK = "3";
    final String CONFIRM = "4";
    private boolean isRunning = true;
    private Scanner scanner;


    @Override
    public void startMenu() {
        System.out.println("You are in admin menu");
        System.out.println(" press 1 to add new car \n" + " press 2 to change price \n" + "press 3 block/unblock user" + "press 4 to comfirm order");

        scanner = new Scanner(System.in);
        //logic
        while (isRunning) {
            String choice = scanner.next();
            switch (choice) {
                case ADD_NEW_CAR:
                    new AdminService().addNewCar();
                    exit();
                    break;
                case CHANGE_PRICE:
                    new AdminService().changePrice();
                    exit();
                    break;
                case BLOCK_UNBLOCK:
                    new AdminService().block_unblock();
                    exit();
                    break;
                case CONFIRM:
                    new AdminService().confirm();
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
    public void startMenu(User user) {

    }

    @Override
    public void exit() {
        isRunning = false;
    }
}
