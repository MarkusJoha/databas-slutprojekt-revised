package models;

import java.util.Date;

public class Account {
    private int id;
    private int ownerId;
    private int balance;
    private String accountNo;
    private String accountName;
    private Date created;

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Account() {

    }
    public Account(String accountName, String accountNo, int balance) {
    }
    public Account(int id, int ownerId, int balance, String accountNo, String accountName, Date created) {
        this.id = id;
        this.ownerId = ownerId;
        this.balance = balance;
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.created = created;
    }

    public void getAccountInformation() {
        System.out.println("This is your Profile Information.");

        System.out.println("Account name: " + this.accountName);
        System.out.println("Account number: " + this.accountNo);
        System.out.println("Balance: " + this.balance);
        System.out.println("Owner Id: " + this.ownerId);
        System.out.println("Created at: " + this.created);

    }

}
