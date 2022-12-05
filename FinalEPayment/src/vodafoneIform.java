
import java.util.ArrayList;
import java.util.Scanner;

public class vodafoneIform extends   Forms{
    String homeNumber;
    int quota;
    public String servicename="Vodafone Internet";
    ArrayList<String> homeNumberList=new ArrayList<String>();
    ArrayList<Float> balanceRechargeList=new ArrayList<Float>();
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    Transactions vodatrans=new Transactions();

    public boolean setFlag()
    {
        this.CashFlag=true;
        return CashFlag;

    }

    public void display()
    {
        //taking Values From SysUsers.User
        System.out.println("Enter Home Number :");
        homeNumber = myObj.nextLine();
        System.out.println("Enter Quota :");
        quota= myObj.nextInt();
        System.out.println("Enter Balance Recharge :");
        balanceRecharge = myObj.nextFloat();

        //Adding Values to the List
        balanceRechargeList.add(balanceRecharge);
        homeNumberList.add(homeNumber);
        // Read user input

        vodatrans.addTransF(balanceRecharge ,servicename);
        vodatrans=null;
        vodatrans=new Transactions();
    }
}
