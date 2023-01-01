package com.fawary.Fawary.BSL.Payment;

import com.fawary.Fawary.Models.Transaction;
import com.fawary.Fawary.Models.Users;
import java.util.ArrayList;

import static com.fawary.Fawary.Models.Transaction.Transactions;

public class DiscountBL {
   Users u1 = new Users();
   double discountValue;
   public static ArrayList<String> ServicesDiscount = new ArrayList<>();

    public double OverallDiscount()
    {
        int cnt=0;
        if(!Transactions.isEmpty()){
            for( Transaction i: Transactions)
            {
                if(i.getUsername().equals(Users.CurrentUser))
                {
                    cnt++;
                }
            }
        }
        if(cnt<1)
        {
            discountValue=0.1;
        }
        else{
            discountValue=0;
        }
            return discountValue;
    }
    public double SpecificDiscount(String servicename)
    {
        if(ApplyDiscount(servicename))
        {
            discountValue=0.2;
        }
        else{
            discountValue=0;
        }
        return discountValue;
    }
    public boolean ApplyDiscount(String servicename){
        for (String i:ServicesDiscount){
            if(servicename.equals(i)){
                return true;
            }
        }
        return false;
    }
    public String setServiceDiscount(String servicename){
        ServicesDiscount.add(servicename);
        return "Discount Successfully Done" ;
    }

}



