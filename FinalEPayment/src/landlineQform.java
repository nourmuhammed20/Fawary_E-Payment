
import java.util.ArrayList;
import java.util.Scanner;


public class landlineQform extends Forms {
    String homeNumber;
    String zipcode;

    public String servicename="Quarter Receipt";

    ArrayList<String> homeNumberList=new ArrayList<String>();
    ArrayList<String> zipcodeList=new ArrayList<String>();
    ArrayList<Float> balanceRechargeList=new ArrayList<Float>();
    Transactions LLQtrans=new Transactions();

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    public boolean setFlag()
    {
        this.CashFlag=true;
        return CashFlag;

    }

    public void display()
    {
        //taking Values From SysUsers.User
        System.out.println("Enter Country Zip Code :");
        zipcode = myObj.nextLine();
        System.out.println("Enter Home Number :");
        homeNumber = myObj.nextLine();
        System.out.println("Enter Balance Recharge :");
        balanceRecharge = myObj.nextFloat();

        //Adding Values to the List
        zipcodeList.add(zipcode);
        balanceRechargeList.add(balanceRecharge);
        homeNumberList.add(homeNumber);
        // Read user input
        LLQtrans.addTransF(balanceRecharge ,servicename);
        LLQtrans=null;
        LLQtrans=new Transactions();
    }
}