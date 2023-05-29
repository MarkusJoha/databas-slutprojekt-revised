package views;

import models.User;

import java.util.Scanner;

public class LoginView {
    public static void loggedIn(User user) {
        Scanner choice = new Scanner(System.in);
        while (true) {
            System.out.println("1.Create bank account");
            System.out.println("2. Make a payment.");
            System.out.println("3. Check Transactions.");
            System.out.println("4. Profile information.");
            System.out.println("5. Log out.");

            switch (choice.nextLine()) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
