
import java.util.ArrayList;
import java.util.Scanner;

public class vodafoneMform extends   Forms{
    String MobileNumber;
    public String servicename="Vodafone Mobile";
    ArrayList<String> MobileNumberList =new ArrayList<String>();

    ArrayList<Float> balanceRechargeList=new ArrayList<Float>();
    Transactions vodatrans=new Transactions();
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

        vodatrans.addTransF(balanceRecharge ,servicename);
        vodatrans=null;
        vodatrans=new Transactions();

    }
}
