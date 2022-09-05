package Model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String username;
    private String pass;

    boolean isBlocked = false;

    public User(String name, String login, String pass) {
        this.name = name;
        this.username = login;
        this.pass = pass;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Model.User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
