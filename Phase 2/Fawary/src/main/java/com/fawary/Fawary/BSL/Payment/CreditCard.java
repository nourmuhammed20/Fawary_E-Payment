package com.fawary.Fawary.BSL.Payment;

import com.fawary.Fawary.BSL.TransactionsBSL.TransactionBL;
import com.fawary.Fawary.Models.Transaction;
import com.fawary.Fawary.Models.Users;
import com.fawary.Fawary.controllers.ServiceProviders.ServiceController;

import java.util.HashMap;


public class CreditCard extends PaymentResponse {
    Users u1 = new Users();
    TransactionBL transactionBL= new TransactionBL();
    DiscountBL dsc = new DiscountBL();

    public HashMap<String, Transaction> Pay(double ServiceMoney, ServiceController s) {
        HashMap<String, Transaction> response = new HashMap<String,Transaction>();

        if(super.ProceedService(u1.getCredit(), ServiceMoney)){
            for (int i = 0; i < Users.UsersArray.size() ; i++) {
                if(Users.CurrentUser.equals(Users.UsersArray.get(i).getUsername()))
                {
                        ServiceMoney=ServiceMoney-(dsc.OverallDiscount()*ServiceMoney);
                        ServiceMoney=ServiceMoney-(dsc.SpecificDiscount(s.getServiceName())*ServiceMoney);
                        response= transactionBL.addTransaction(Users.UsersArray.get(i).getUsername(), s.getServiceName(),ServiceMoney,s.getServiceProvider());
                        Users.UsersArray.get(i).setCredit(u1.getCredit()-(ServiceMoney));
                }
            }
        }
        return response;
    }
}


