package Service;

import Model.User;
import WorkWithFiles.FileManager;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private FileManager<List<User>> fileManager;

    public User login(String username, String password) {

        List<User> users = new ArrayList<>();
        fileManager = new FileManager<>();
        users = fileManager.readFile("src/SimpleBD/users.bin", users);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPass().equals(password)) {

                System.out.println("Welcome "+users.get(i).getName()+"\n--------------------");
                return users.get(i);

            } else {
                System.out.println("\n--------------------\nWrong login or password\n--------------------");
            }
        }
        return null;
    }

    public User registration(String name, String username, String password) {

        List<User> users = new ArrayList<>();
        fileManager = new FileManager();
        users = fileManager.readFile("src/SimpleBD/users.bin", users);
        User newUser = new User(name, username, password);
        users.add(newUser);


        fileManager.writeFile("src/SimpleBD/users.bin", users);

        System.out.println("Registration complete\n--------------------");
        return newUser;
    }
}
