package org.example.model;

public class User {
    String username;
    int id;
    int password;

    public User(String username, int id, int password) {
        this.username = username;
        this.id = id;
        this.password = password;
    }

    public static void add(User user1) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
