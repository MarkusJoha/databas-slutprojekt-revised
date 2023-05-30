package models;

import java.util.Date;

public class User {
    private int id;
    private String birthdate;
    private String phone;
    private String email;
    private String name;
    private String address;
    private String password;

    private Date created;

    public int getId() {
        return id;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User() {

    }

    public User(String birthdate, String password) {
        this.birthdate = birthdate;
        this.password = password;
    }

    public User(int id, String birthdate, String phone, String email, String name, String address, String password, Date created) {
        this.id = id;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.address = address;
        this.password = password;
        this.created = created;
    }

    public void getUserInformation() {
        System.out.println("This is your Profile Information.");

        System.out.println("Birthdate: " + this.birthdate);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Address: " + this.address);
        System.out.println("Phone: " + this.phone);
        System.out.println("Created at: " + this.created);

    }

}
