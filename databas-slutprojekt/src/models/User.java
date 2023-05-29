package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void add(Connection conn) {
        try {
            PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE birthdate = ?");
            checkStmt.setString(1, birthdate);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            int count = checkResult.getInt(1);
            if (count > 0) {
                System.out.println("Birthdate already exists! Please write a different birthdate.");
                return;
            }

            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO users (birthdate, phone, email, name, address, password) VALUES (?, ?, ?, ?, ?, ?)");
            insertStmt.setString(1, birthdate);
            insertStmt.setString(2, phone);
            insertStmt.setString(3, email);
            insertStmt.setString(4, name);
            insertStmt.setString(5, address);
            insertStmt.setString(6, Password.hash(password));
            insertStmt.executeUpdate();
            System.out.println("User created.");

        } catch (SQLException e) {
            System.out.println("User with this birthdate already exists, please write a different birthdate.");
            e.printStackTrace();
        }
    }

}
