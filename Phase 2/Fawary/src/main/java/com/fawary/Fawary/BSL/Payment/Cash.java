package com.fawary.Fawary.BSL.Payment;

import com.fawary.Fawary.BSL.TransactionsBSL.TransactionBL;
import com.fawary.Fawary.Models.Transaction;
import com.fawary.Fawary.Models.Users;
import com.fawary.Fawary.controllers.ServiceProviders.ServiceController;

import java.util.HashMap;


public class Cash extends PaymentResponse {
    TransactionBL transactionBL = new TransactionBL();
    Users users = new Users();

    public HashMap<String, Transaction> Pay(double ServiceMoney, ServiceController s) {

        HashMap<String, Transaction> response = new HashMap<String,Transaction>();

            if (s.isAccCash()){
                response= transactionBL.addTransaction(Users.CurrentUser, s.getServiceName(),ServiceMoney,s.getServiceProvider());
            }
            else {
                response.put("Service Doesn't Accept cash",null);
            }
        return response;
    }
}