package controllers;

import DatabaseConnection.Database;
import Hashing.Password;
import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {


    public void add(User user) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE birthdate = ?");
            checkStmt.setString(1, user.getBirthdate());
            ResultSet checkResult = checkStmt.executeQuery();

            while (checkResult.next()) {
                int count = checkResult.getInt(1);
                if (count > 0) {
                    System.out.println("User with this birthdate already exists. Please enter a different birthdate.");
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
                System.out.println("Something went wrong. Please try again.");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while adding user to the database.");
            e.printStackTrace();
        }
    }


    public void update(User user){
        try {
            Connection conn = Database.getConnection();
            PreparedStatement updateStmt = conn.prepareStatement("UPDATE users SET name = ?, address = ?, phone = ?, password = ?, email = ? WHERE birthdate = ?");
            updateStmt.setString(1, user.getName());
            updateStmt.setString(2, user.getAddress());
            updateStmt.setString(3, user.getPhone());
            updateStmt.setString(4, Password.hash(user.getPassword()));
            updateStmt.setString(5, user.getEmail());
            updateStmt.setString(6, user.getBirthdate());

            if (updateStmt.executeUpdate() == 1) {
                System.out.println("User information updated.");
            } else {
                System.out.println("Something went wrong! Please try again.");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating user information.");
            e.printStackTrace();
        }
    }
    public void delete(User user) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM users WHERE birthdate = ?");
            deleteStmt.setString(1, user.getBirthdate());

            if (deleteStmt.executeUpdate() == 1) {
                System.out.println("User deleted.");
            } else {
                System.out.println("Something went wrong! Please try again.");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting the user.");
            e.printStackTrace();
        }
    }
}