

import java.util.ArrayList;
import java.util.Scanner;

public class Refund extends Transactions{
    public String usernameforobs;
    public static ArrayList<String> AcceptedNameList=new   ArrayList <String>();
    public static ArrayList<Integer> AcceptedRefundIdList=new ArrayList <Integer>();
    public static ArrayList<Integer> RejectedRefundIdList2=new ArrayList <Integer>();
    public static ArrayList<String> RejectedNameList=new   ArrayList <String>();






    public static ArrayList<Refund> Refundlist=new   ArrayList <Refund>();
    public static ArrayList<Refund> Acceptedlist=new   ArrayList <Refund>();
    public static ArrayList<Refund> Rejectedlist=new   ArrayList <Refund>();


    public static Refund obj2 = new Refund();
    public static   Refund obj3 = new Refund();
       public int refundid;
        int ReqRefundID;
        CreditCard c = new CreditCard();
        boolean flag =true;
        String status="pending";
        Scanner myObj = new Scanner(System.in);


    public void refund() {
        System.out.println("Enter Transaction ID :");
        refundid = myObj.nextInt();
        Transactions t1=new Transactions();

        for(int i=0;i<t1.transArr.size();i++)
        {

                if(t1.transArr.get(i).TransactionID==refundid)
                {
                    System.out.println("Do you want to refund this Transaction?\n1-Yes\n2-No");
                    int opt = myObj.nextInt();
                    if(!t1.transArr.get(i).isRefunded){
                        obj2.service_name2=t1.transArr.get(i).service_name2;
                        obj2.refundid=t1.transArr.get(i).TransactionID;
                        obj2.pay_Amount=t1.transArr.get(i).pay_Amount;
                        obj2.Username2=t1.transArr.get(i).Username2;
                        t1.transArr.get(i).isRefunded=true;
                        obj2.status =status;
                        Refundlist.add(obj2);
                        obj2=null;
                        obj2=new Refund();
                        System.out.println("Added to Refund Request List Successfully");
                    }
                    else {
                        System.out.println("This Transaction is Already Refunded");
                    }

                }
//            else{System.out.println("No Transaction Found For This ID. 000000");break;}
        }
    }

    public void ListRequest(){
    //prints the list objects in tabular format
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.printf("%5s %20s %20s %20s %20s ", "Transaction ID", "USERNAME", "Amount","Service Name","Status");
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------------------------------");
//iterates over the list
    for( Refund i: Refundlist)
    {

        System.out.format("%10s %20s %22s %22s %22s",i.refundid , i.Username2, i.pay_Amount,i.service_name2,i.status);
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
    while(flag){
    System.out.println("1-Accept Request\n2-Reject Request\n3-Exit List");
    int opt = myObj.nextInt();
        if(opt ==1){
            AcceptRefund();
        } else if (opt ==2) {
            RejectRefund();
        }
        else if(opt ==3){
            break;
        }
        else {System.out.println("Wrong input please try Again");}
    }
//    System.out.println("----------------------------------------------------------------------------------------------");
}


    public void AcceptRefund(){
        System.out.println("Enter Transaction ID To Accept :");
        ReqRefundID = myObj.nextInt();
        boolean isFound=false;
        for(Refund r : Refundlist){
            if(r.refundid==ReqRefundID)
            {
                obj3.refundid=ReqRefundID;
                obj3.service_name2=r.service_name2;
                obj3.pay_Amount=r.pay_Amount;
                obj3.Username2=r.Username2;
                usernameforobs=obj3.Username2;
                AcceptedRefundIdList.add(obj3.refundid);
                AcceptedNameList.add(usernameforobs);
                obj3.status ="Accepted";
                r.status="Accepted";
                Acceptedlist.add(obj3);
                c.CreditAmount+=r.pay_Amount;
                Refundlist.remove(r);

                obj3=null;
                obj3=new Refund();
                System.out.println("Added to Accepted Request List Successfully");
                isFound=true;
                break;
            }
        }
        if(!isFound){System.out.println("No Transaction Found For This ID.");}
    }


    public void RejectRefund(){
        System.out.println("Enter Transaction ID To Reject :");
        ReqRefundID = myObj.nextInt();
        boolean isFound=false;
        for(Refund r : Refundlist){
            if(r.refundid==ReqRefundID)
            {
                obj3.refundid=ReqRefundID;
                obj3.service_name2=r.service_name2;
                obj3.pay_Amount=r.pay_Amount;
                obj3.Username2=r.Username2;
                obj3.status ="Rejected";
                r.status="Rejected";


                Rejectedlist.add(obj3);
                Refundlist.remove(r);
                RejectedNameList.add(obj3.Username2);
                RejectedRefundIdList2.add(obj3.refundid);
                obj3=null;
                obj3=new Refund();
                System.out.println("Added to Rejected Request List Successfully");
                isFound=true;
                break;
            }
        }
        if(!isFound){System.out.println("No Request Found For This Transaction ID.");}
    }

    public void ListAccept(){
        //prints the list objects in tabular format
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %20s %20s %20s %20s ", "Transaction ID", "USERNAME", "Amount","Service Name","Status");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------");
//iterates over the list
        for( Refund i: Acceptedlist)
        {

                System.out.format("%10s %20s %22s %22s %22s", i.refundid, i.Username2, i.pay_Amount, i.service_name2, i.status);
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------------------------------");

        }
    }



public void ListReject(){
    //prints the list objects in tabular format
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.printf("%5s %20s %20s %20s %20s ", "Transaction ID", "USERNAME", "Amount","Service Name","Status");
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------------------------------");
//iterates over the list
    for( Refund i: Rejectedlist)
    {
            System.out.format("%10s %20s %22s %22s %22s", i.refundid, i.Username2, i.pay_Amount, i.service_name2, i.status);
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------");

    }
  }
//
//
//  public void NotifyUser(){
//    this.TransactionID=;
//    this.Status=;
//  }


}
