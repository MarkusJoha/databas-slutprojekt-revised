package controllers;

import DatabaseConnection.Database;
import models.Account;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountController {

    private List<Account> accounts;

    public AccountController() {
        // Initialize the accounts list, either by fetching data from the database or creating a new list
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts(User user) {
        // Implement logic to fetch bank accounts associated with the given user
        // You can query the database to retrieve the accounts based on the user's information
        // Return a list of Account objects representing the user's bank accounts
        return null; // Placeholder, replace with your implementation
    }

    public void createAccount(User user, Account account) {
        try {
            Connection conn = Database.getConnection();
            account.setOwnerId(user.getId());

            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO accounts (account_name, account_no, balance, owner_id) VALUES (?, ?, ?, ?)");
            insertStmt.setString(1, account.getAccountName());
            insertStmt.setString(2, account.getAccountNo());
            insertStmt.setInt(3, account.getBalance());
            insertStmt.setInt(4, account.getOwnerId());

            if (insertStmt.executeUpdate() == 1) {
                System.out.println("Bank account created.");
            } else {
                System.out.println("Failed to create bank account. Please try again.");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while creating bank account.");
            e.printStackTrace();
        }
    }
}