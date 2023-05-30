package controllers;

import DatabaseConnection.Database;
import Hashing.Password;
import models.User;
import views.MenuView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class UserController {
    public static void createUser() {
        MenuView.registerUser();
    }

    public void add(User user) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE birthdate = ? AND password = ?");
            checkStmt.setString(1, user.getBirthdate());
            checkStmt.setString(2, user.getPassword());
            ResultSet checkResult = checkStmt.executeQuery();
            while (checkResult.next()) {
                int count = checkResult.getInt(1);
                if (count > 0) {
                    System.out.println("Birthdate already exists in db! Please write a different birthdate.");
                    return;
                }
            }

            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO users (birthdate, phone, email, name, address, password) VALUES (?, ?, ?, ?, ?, ?)");
            insertStmt.setString(1, user.getBirthdate());
            insertStmt.setString(2, user.getPhone());
            insertStmt.setString(3, user.getEmail());
            insertStmt.setString(4, user.getName());
            insertStmt.setString(5, user.getAddress());
            insertStmt.setString(6, Password.hash(user.getPassword()));
            if (insertStmt.executeUpdate() == 1) {
                System.out.println("User created.");

            } else {
                System.out.println("Something went wrong! Please try again");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("User with this birthdate already exists, please write a different birthdate.");
            e.printStackTrace();
        }
    }

    public static User logIn() {
        Scanner input = new Scanner(System.in);
        try {
            String checkPassword = "SELECT * FROM users WHERE birthdate = ?;";

            System.out.println("Log In");
            System.out.println("Birthdate:");
            String username = input.nextLine();

            System.out.println("Password:");
            String password = input.nextLine();

            Connection connection = Database.getConnection();
            PreparedStatement checkPw = connection.prepareStatement(checkPassword);
            checkPw.setString(1, username);
            ResultSet pw = checkPw.executeQuery();
            if (pw.next()) {
                String hashPassword = pw.getString("password");

                if (Password.Verify(password, hashPassword)) {
                    System.out.println("Login successful!");
                    int userId = pw.getInt("id");
                    String name = pw.getString("name");
                    String adress = pw.getString("address");
                    String phone = pw.getString("phone");
                    String birthdate = pw.getString("birthdate");
                    String email = pw.getString("email");
                    Date created = pw.getDate("created");

                    System.out.println("Welcome " + name + "!");
                    connection.close();

                    return new User(userId, birthdate, phone, email, name, adress, password, created);
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("Birthdate doesn't exist!");
            }
            connection.close();
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}