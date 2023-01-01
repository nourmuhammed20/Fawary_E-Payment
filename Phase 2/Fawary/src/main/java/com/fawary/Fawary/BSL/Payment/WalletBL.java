package com.fawary.Fawary.BSL.Payment;

import com.fawary.Fawary.BSL.TransactionsBSL.TransactionBL;
import com.fawary.Fawary.Models.Transaction;
import com.fawary.Fawary.Models.Users;
import com.fawary.Fawary.Models.Wallet;
import com.fawary.Fawary.controllers.Payment.PaymentController;
import com.fawary.Fawary.controllers.ServiceProviders.ServiceController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public class WalletBL extends PaymentResponse {
//    AuthenticateView authview =new AuthenticateView();
    Users usr=new Users();
    Wallet wallet =new Wallet();
//    AuthenticateView authView = new AuthenticateView();
    TransactionBL transactionBL = new TransactionBL();
    DiscountBL dsc = new DiscountBL();

    public HashMap<String, Transaction> Pay(double ServiceMoney, ServiceController s){
        HashMap<String, Transaction> response = new HashMap<String,Transaction>();

        if(super.ProceedService(u1.getWallet(), ServiceMoney)){
            for (int i = 0; i < Users.UsersArray.size() ; i++) {
//                if(authView.CurrentUser.equals(u1.UsersArray.get(i).getUsername()))  //get user
                if(Users.CurrentUser.equals(Users.UsersArray.get(i).getUsername()))  //get user
                {
                    if(dsc.OverallDiscount()!=1)
                    {
                        ServiceMoney=ServiceMoney-dsc.OverallDiscount()*ServiceMoney;
                        Users.UsersArray.get(i).setWallet(u1.getWallet()-(ServiceMoney));
                        System.out.println("You Will be Recharged With :"+ServiceMoney);
                        System.out.println("Your Credit Become :"+ Users.UsersArray.get(i).getWallet());
                        response= transactionBL.addTransaction(Users.UsersArray.get(i).getUsername(), s.getServiceName(),ServiceMoney,s.getServiceProvider());
                    }
                    else
                    {
                        Users.UsersArray.get(i).setWallet(u1.getWallet()-(ServiceMoney));
                        System.out.println("You Will be Recharged With :"+ServiceMoney);
                        System.out.println("Your Credit Become :"+ Users.UsersArray.get(i).getWallet());
                        response= transactionBL.addTransaction(Users.UsersArray.get(i).getUsername(), s.getServiceName(),ServiceMoney,s.getServiceProvider());
                    }
                }
            }
        }
        return response;
    }

    public HashMap<String,String> chargeWallet(double value){
        HashMap<String,String> response=new HashMap<>();

        for (int j = 0; j < Users.UsersArray.size() ; j++) {
            if(Users.CurrentUser.equals(Users.UsersArray.get(j).getUsername()))  //get user
            {
                if(Users.UsersArray.get(j).getCredit()>=value){
                    double tmp = Users.UsersArray.get(j).getCredit() - value;
                    Users.UsersArray.get(j).setCredit(tmp);
                    Users.UsersArray.get(j).setWallet(value);
                    Wallet.WalletTransactions.put(Users.UsersArray.get(j).getUsername(),value);

                    response.put("response","Added Successfully");
                    return response;
                }
                else {
                    response.put("response","Credit Value is Not Enough");
                    return response;
                }

            }
        }
        response.put("response","No Authentication");
        return response;
    }

    public HashMap<String,HashMap<String,Double>> listWalletTrans(){

        HashMap<String,HashMap<String,Double>> response=new HashMap<>();
        Wallet w=new Wallet();
        response.put("response", Wallet.WalletTransactions);
        return response;
    }

}
