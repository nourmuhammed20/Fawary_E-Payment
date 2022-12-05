

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolsForm extends Forms {

    public String servicename="Donations";
    String schoolCode;
    String Schoolname;
    Float DonationBalance;

    ArrayList<String> SchoolCodeList=new ArrayList<String>();
    ArrayList<String> SchoolNameList=new ArrayList<String>();
    ArrayList<Float> DonationBalanceList=new ArrayList<Float>();
    Transactions SchoolsDonations=new Transactions();

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    public boolean setFlag()
    {
        this.CashFlag=true;
        return CashFlag;

    }

    public void display()
    {
        //taking Values From SysUsers.User
        System.out.println("Enter Schools Code :");
        schoolCode = myObj.nextLine();
        System.out.println("Enter Schools Name:");
        Schoolname = myObj.nextLine();
        System.out.println("Donate Balance :");
        DonationBalance = myObj.nextFloat();

        //Adding Values to the List
        SchoolCodeList.add(schoolCode);
        DonationBalanceList.add(DonationBalance);
        SchoolNameList.add(Schoolname);
        // Read user input
        SchoolsDonations.addTransF(DonationBalance ,servicename);
        SchoolsDonations=null;
        SchoolsDonations=new Transactions();
    }
}
