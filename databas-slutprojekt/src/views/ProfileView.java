package views;

import models.User;

import java.util.Scanner;

public class ProfileView {
    public static void profileMenu(User user) {

        while (true) {
            user.getUserInformation();
            System.out.println("1. Edit information.");
            System.out.println("2. Delete profile.");
            System.out.println("3. Go back.");
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> editUserInfo(user);
                case "2" -> deleteUser(user);
                case "3" -> {
                    return;
                }

                default ->
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void editUserInfo(User user){
        //souta och gör de ändringar som användaren får kan vill göra
        // typ ändra mobilnummer -> new UserController().updateUser(user);
    }

    public static void deleteUser(User user){
        //souta enb fråga om user verkligen vill radera sitt konto kanske
        // begära att user skriver in sitt födelsedatum och lösenord
        // bekräfta? -> new UserController().deleteUser(user);
        // sout user account deleted
    }
}

