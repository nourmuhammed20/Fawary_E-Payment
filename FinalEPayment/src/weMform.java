
import java.util.ArrayList;
import java.util.Scanner;

public class weMform extends Forms{
    String MobileNumber;

    public String servicename="we Mobile";
    ArrayList<String> MobileNumberList =new ArrayList<String>();
    Transactions wetrans=new Transactions();

    ArrayList<Float> balanceRechargeList=new ArrayList<Float>();
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    public boolean setFlag()
    {
         this.CashFlag=true;
         return CashFlag;

    }

    public void display()
    {


        //taking Values From SysUsers.User
        System.out.println("Enter Mobile Number :");
        MobileNumber = myObj.nextLine();
        System.out.println("Enter Balance Recharge :");
        balanceRecharge = myObj.nextFloat();

        //Adding Values to the List
        balanceRechargeList.add(balanceRecharge);
        MobileNumberList.add(MobileNumber);
        // Read user input
        wetrans.addTransF(balanceRecharge ,servicename);
        wetrans=null;
        wetrans=new Transactions();
        this.setFlag();
    }
}
