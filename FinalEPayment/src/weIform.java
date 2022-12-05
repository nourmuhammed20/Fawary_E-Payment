

import java.util.ArrayList;
import java.util.Scanner;


public class weIform extends   Forms{
    String homeNumber;
    public boolean setFlag()
    {
        this.CashFlag=false;
        return CashFlag;

    }
    public String servicename="We Internet";

    ArrayList<String> homeNumberList=new ArrayList<String>();
    ArrayList<Float> balanceRechargeList=new ArrayList<Float>();
    Transactions wetrans=new Transactions();

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object



    public void display()
    {
        //taking Values From SysUsers.User
        System.out.println("Enter Home Number :");
        homeNumber = myObj.nextLine();
        System.out.println("Enter Balance Recharge :");
        balanceRecharge = myObj.nextFloat();

        //Adding Values to the List
        balanceRechargeList.add(balanceRecharge);
        homeNumberList.add(homeNumber);
        // Read user input
        wetrans.addTransF(balanceRecharge ,servicename);
        wetrans=null;
        wetrans=new Transactions();
    }
}
