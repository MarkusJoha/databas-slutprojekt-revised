package views;

import controllers.UserController;
import models.Database;
import models.Login;
import models.User;

import java.sql.Connection;
import java.util.Scanner;

public class Menu {
    public static void displayMenu() {
        System.out.println("Welcome to Swosh!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    public static void login() {
        System.out.println();
    }

    public static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }

    public static void performAction() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.println("Choice: ");
            switch (scan.nextLine()) {
                case "1":
                    User user = Login.logIn();
                    if (user != null) {
                        LoginView.loggedIn(user);
                    }
                    break;
                case "2":
                    UserController.createUser(Database.getConnection());
                    return;
                case "3":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
