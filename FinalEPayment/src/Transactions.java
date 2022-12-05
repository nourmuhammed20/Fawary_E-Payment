import java.util.Random;
import java.util.ArrayList;


public class Transactions {
    //rand.nextInt(upperbound);
    Random rand=new Random();
    int TransactionID; //random
    Float pay_Amount;
    String service_name2;
    String Username2;
    String Status="Active";
    boolean isRefunded=false;
    public static ArrayList<Transactions> transArr=new   ArrayList <Transactions>();
    public static Transactions obj1 = new Transactions();



    public void addTransU(String user_name)
    {
        Random rand=new Random();
        Random rand2=new Random();
        obj1.TransactionID=rand.nextInt(1500)+rand2.nextInt(3500);
        obj1.Username2=user_name;
        transArr.add(obj1);
        System.out.println("The Transaction ID : "+obj1.TransactionID);
        obj1=null;
        obj1=new Transactions();
    }

   public void addTransF(float balance , String servname)
    {
        obj1.pay_Amount=balance;
        obj1.service_name2=servname;

    }
//random must be unique

    //list transactions
    public void ListTrans(){
        //prints the list objects in tabular format
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %25s %25s %25s %20s", "Transaction ID", "USERNAME", "Amount", "Service Name","Status");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------");
//iterates over the list
        for( Transactions i: transArr)
        {
            System.out.format("%10s %25s %27s %30s %30s",i.TransactionID , i.Username2, i.pay_Amount,i.service_name2,i.Status);
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------");
        }
    }



}
//If Transaction Not found print anything