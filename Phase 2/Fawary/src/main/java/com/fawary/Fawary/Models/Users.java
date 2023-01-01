package com.fawary.Fawary.Models;

import java.util.ArrayList;
//Model
public class Users {
    String username;
    String Password;
    String Email;
    boolean Admin;
    boolean isLogged=false;
    Credit credit = new Credit();
    Wallet wallet = new Wallet();
    public static String CurrentUser;
    public static  ArrayList<Users> UsersArray =new ArrayList<Users>();
    public void setCredit(double credit) {this.credit.setCreditBalance(credit);}
    public void setEmail(String email) {
        Email = email;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setWallet(double credit) {
        this.wallet.setWalletCredit(credit);
    }
    public void setAdmin(boolean admin) {
        Admin = admin;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public static void setCurrentUser(String currentUser) {
        CurrentUser = currentUser;
    }
    public static String getCurrentUser() {
        return CurrentUser;
    }
    public double getWallet() {
        return wallet.getWalletCredit();
    }
    public double getCredit() {
        return credit.getCreditBalance();
    }
    public boolean isAdmin() {
        return Admin;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return Password;
    }
    public String getEmail() {
        return Email;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void addAdmin(){
        for (int i = 1; i <= 3; i++) {
            Users user = new Users();
            user.setUsername("admin" + i);
            user.setPassword("admin" + i);
            user.setEmail("admin" + i + "@example.com");
            user.setAdmin(true);
            UsersArray.add(user);
        }
    }

}
