package views;

import controllers.AccountController;
import models.Account;
import models.User;

import java.util.Scanner;

public class AccountView {

    public static void accountMenu(User user) {
        while (true) {
            System.out.println("1. Show Bank Accounts");
            System.out.println("2. Create New Bank Account");
            System.out.println("3. Go Back");

            System.out.print("Choice: ");
            String choice = new Scanner(System.in).nextLine();

            switch (choice) {
                case "1":
                    showBankAccounts(user);
                    break;
                case "2":
                    createBankAccount(user);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showBankAccounts(User user) {
        // Implement logic to display the user's bank accounts
        // Use the AccountController to fetch the bank accounts associated with the user
        // Print the bank account details to the console
        // You can use loops and formatting to display the accounts in a clear format
    }

    private static void createBankAccount(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account name: ");
        String accountName = scanner.nextLine();

        System.out.println("Enter account number: ");
        String accountNo = scanner.nextLine();

        System.out.println("Enter balance: ");
        int balance = Integer.parseInt(scanner.nextLine());

        Account account = new Account();
        account.setAccountName(accountName);
        account.setAccountNo(accountNo);
        account.setBalance(balance);

        AccountController accountController = new AccountController();
        accountController.createAccount(user, account);

        System.out.println("Bank account created successfully!");
    }
}
