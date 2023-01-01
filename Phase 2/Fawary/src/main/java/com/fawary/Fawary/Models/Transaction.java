package com.fawary.Fawary.Models;

import java.util.ArrayList;
//Model
public class Transaction {
    String Username;
    String ServiceName;



    String ServiceProv;
    String Status;
    int TransactionID;
    double ServiceAmount;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUsername() {
        return Username;
    }
    public String getServiceProv() {
        return ServiceProv;
    }

    public void setUsername(String username) {
        Username = username;
    }
    public void setServiceProv(String serviceProv) {
        ServiceProv = serviceProv;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public int getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(int transactionID) {
        TransactionID = transactionID;
    }

    public double getServiceAmount() {
        return ServiceAmount;
    }

    public void setServiceAmount(double serviceAmount) {
        ServiceAmount = serviceAmount;
    }

    public static ArrayList<Transaction> Transactions = new ArrayList<Transaction>();

    public static ArrayList<Transaction> Refunds = new ArrayList<Transaction>();

}