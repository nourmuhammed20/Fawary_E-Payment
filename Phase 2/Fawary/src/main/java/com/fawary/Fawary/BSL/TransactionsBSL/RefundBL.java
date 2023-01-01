package com.fawary.Fawary.BSL.TransactionsBSL;

import com.fawary.Fawary.Models.Transaction;
import com.fawary.Fawary.Models.Users;
import java.util.ArrayList;
import java.util.HashMap;
import static com.fawary.Fawary.Models.Transaction.Refunds;
import static com.fawary.Fawary.Models.Transaction.Transactions;

public class RefundBL {
    Users usr=new Users();
    public static ArrayList<Transaction> Acceptedlist=new   ArrayList <Transaction>();
    public static ArrayList<Transaction> Rejectedlist=new   ArrayList <Transaction>();
    public static ArrayList<String> AcceptedNameList=new   ArrayList <String>();
    public static ArrayList<String> RejectedNameList=new   ArrayList <String>();
    public HashMap<String,String> addRefund(int id)
    {
        HashMap<String,String> response =new HashMap<>();

        for( Transaction i: Transactions)
        {
            if(id==i.getTransactionID()){
                Refunds.add(i);
                i.setStatus("Pending");
                System.out.println("Transaction Refunded");
                response.put("response","Transaction Refunded");

                return response;
            }
        }
        response.put("response","Transaction Not Found");
        return response;
    }
    public HashMap<String,String> acceptRefund(int id)
    {
        HashMap<String,String> response =new HashMap<>();

        for( Transaction i: Refunds)
        {
            if(id==i.getTransactionID()){
                for( Transaction j: Transactions)
                {
                    if(id==j.getTransactionID()){
                        j.setStatus("Accepted");
                        i.setStatus("Accepted");
                        Acceptedlist.add(i);
                        AcceptedNameList.add(i.getUsername());
                        break;
                    }
                }
                for (int j = 0; j < Users.UsersArray.size() ; j++) {
                    if(Users.CurrentUser.equals(Users.UsersArray.get(j).getUsername()))  //get user
                    {
                        Users.UsersArray.get(j).setCredit(Users.UsersArray.get(j).getCredit()+i.getServiceAmount());
                        break;
                    }
                }

                response.put("response","Refund Accepted");
                return response;
            }
        }

        response.put("response","Refund Request Not Found");
        return response;
    }
    public HashMap<String,String> rejectRefund(int id)
    {
        HashMap<String,String> response =new HashMap<>();
        for( Transaction i: Refunds)
        {
            if(id==i.getTransactionID()){
                for( Transaction j: Transactions)
                {
                    if(id==j.getTransactionID()){
                        j.setStatus("Rejected");
                        i.setStatus("Rejected");
                        Rejectedlist.add(i);
                        RejectedNameList.add(i.getUsername());
                    }
                }
                response.put("response","Refund Rejected");
                return response;
            }
        }
        response.put("response","Refund Request Not Found");
        return response;
    }
    public HashMap<String,ArrayList<Transaction>> notifications()
    {
        ArrayList<Transaction> accTmp=new ArrayList<>();
        ArrayList<Transaction> rejTmp=new ArrayList<>();

        for(int i=0;i<AcceptedNameList.size();i++)
        {
            if(AcceptedNameList.isEmpty())
            {
                break;
            }
            if(Users.CurrentUser.equals(AcceptedNameList.get(i)))
            {
                accTmp.add(Acceptedlist.get(i));
                AcceptedNameList.remove(AcceptedNameList.get(i));
            }
        }
        for(int i=0;i<RejectedNameList.size();i++)
        {

            if(RejectedNameList.isEmpty())
            {
                break;
            }

            else if(Users.CurrentUser.equals(RejectedNameList.get(i)))
            {
                rejTmp.add(Rejectedlist.get(i));
                RejectedNameList.remove(RejectedNameList.get(i));
            }
        }
        HashMap<String,ArrayList<Transaction>> response=new HashMap<>();
        response.put("accepted",accTmp);
        response.put("rejected",rejTmp);
        return response;
    }
    public  HashMap<String,ArrayList<Transaction>> refundslist(){

        HashMap<String,ArrayList<Transaction>> response=new HashMap<>();
        response.put("response",Refunds);
        return response;
    }
}