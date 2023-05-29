package views;

import models.User;

import java.util.Scanner;

public class UserView {
    public static User getUserInput() {
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

        return user;
    }
}
