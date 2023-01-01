package com.fawary.Fawary.BSL.TransactionsBSL;

import com.fawary.Fawary.Models.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static com.fawary.Fawary.Models.Transaction.Transactions;

public class TransactionBL {
    Random rand=new Random();
    Random rand2=new Random();
    public HashMap<String, Transaction> addTransaction(String Username ,
                                                       String ServiceName ,
                                                       double Credit,
                                                       String ServiceProvider) {
        
        Transaction t1 = new Transaction();
        int TransactionID=rand.nextInt(1523)+rand2.nextInt(3332);
        t1.setUsername(Username);
        t1.setTransactionID(TransactionID);
        t1.setServiceAmount(Credit);
        t1.setServiceName(ServiceName);
        t1.setServiceProv(ServiceProvider);
        t1.setStatus("Active");
        Transactions.add(t1);
        HashMap<String, com.fawary.Fawary.Models.Transaction> response=new HashMap<>();
        response.put("response",t1);
        return response;
    }
    public HashMap<String, ArrayList<Transaction>> listTransaction(){
        HashMap<String,ArrayList<Transaction>> response=new HashMap<>();
        response.put("response",Transactions);
        return response;
    }
}
