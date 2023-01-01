package com.fawary.Fawary.BSL.Payment;

import com.fawary.Fawary.Models.Transaction;
import com.fawary.Fawary.Models.Users;
import com.fawary.Fawary.controllers.Payment.CashApplier;
import com.fawary.Fawary.controllers.ServiceProviders.ServiceController;
import java.util.HashMap;

public abstract class PaymentResponse {
    public abstract HashMap<String, Transaction> Pay(double ServiceMoney, ServiceController s);
    Users u1 = new Users();
    CashApplier applier = new CashApplier();
    public boolean ProceedService(double UserMoney,double balance){
        boolean flag = false;
        flag = UserMoney >= balance;
        return flag;
    }

    public HashMap<String, Transaction> payment(String method,
                                                double ServiceMoney,
                                                String serviceName,
                                                String serviceProvider)
    {
        HashMap<String,Transaction> response=new HashMap<>();
        ServiceController s=new ServiceController(serviceName,ServiceMoney,serviceProvider);

        if(method.equals("cash")){
            if(ProceedService(u1.getCredit(), ServiceMoney))
            {
                Cash m=new Cash();
                s.setAccCash(applier.AcceptCash(serviceProvider));
                response= m.Pay(ServiceMoney,s);
                return response;
            }
        }

        else if (method.equals("credit")) {
            if(ProceedService(u1.getCredit(), ServiceMoney))
            {
                s=new ServiceController(serviceName,ServiceMoney,serviceProvider);
                CreditCard m=new CreditCard();
                response= m.Pay(ServiceMoney,s);
            }
        }

        else if (method.equals("wallet")) {
            if(ProceedService(u1.getCredit(), ServiceMoney))
            {
                s=new ServiceController(serviceName,ServiceMoney,serviceProvider);
                WalletBL m=new WalletBL();
                response= m.Pay(ServiceMoney,s);
            }
        }
        return response;
    }

}
