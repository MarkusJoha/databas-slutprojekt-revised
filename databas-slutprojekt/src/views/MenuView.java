package views;

import controllers.UserController;
import models.User;
import java.util.Scanner;

public class MenuView {
    public static void displayMenu() {
        System.out.println("Welcome to Swosh!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    public static void displayLoginMenu() {

        while (true) {
            MenuView.displayMenu();
            System.out.println("Choice: ");

            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    User user = UserController.logIn();
                    if (user != null) {
                        MenuView.displayLandingPage(user);
                    }
                }
                case "2" -> UserController.createUser();


                case "3" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
/*            if(!user.getLoggedIn()){
                System.out.println("Exiting");
                return;
            }*/
        }
    }

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.print("Name: ");
        user.setName(scanner.nextLine());

        System.out.println("Birthdate format: yyyymmddnnnn");
        System.out.print("Birthdate: ");
        user.setBirthdate(scanner.nextLine());

        System.out.print("Phone: ");
        user.setPhone(scanner.nextLine());

        System.out.print("Email: ");
        user.setEmail(scanner.nextLine());

        System.out.print("Address: ");
        user.setAddress(scanner.nextLine());

        System.out.print("Password: ");
        user.setPassword(scanner.nextLine());

        new UserController().add(user);

    }

    public static void displayLandingPage(User user) {

        while (true) {
            System.out.println("1. Create bank account");
            System.out.println("2. Make a payment.");
            System.out.println("3. Check Transactions.");
            System.out.println("4. Profile information.");
            System.out.println("5. Check Accounts.");
            System.out.println("6. Log out.");
            switch (new Scanner(System.in).nextLine()) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    ProfileView.profileMenu(user);
                    break;
                case "5":
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }

}
