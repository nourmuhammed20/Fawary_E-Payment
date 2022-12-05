

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalsForm extends Forms {

    public String servicename="Donations";
    String HospitalCode;
    String Hospitalname;
    Float DonationBalance;

    ArrayList<String> HospitalCodeList=new ArrayList<String>();
    ArrayList<String> HospitalnameList=new ArrayList<String>();
    ArrayList<Float> DonationBalanceList=new ArrayList<Float>();
    Transactions HospitalDonation=new Transactions();

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object

    public boolean setFlag()
    {
        this.CashFlag=true;
        return CashFlag;

    }
    public void display()
    {
        //taking Values From SysUsers.User
        System.out.println("Enter Hospital Code :");
        HospitalCode = myObj.nextLine();
        System.out.println("Enter Hospital Name:");
        Hospitalname = myObj.nextLine();
        System.out.println("Donate Balance :");
        DonationBalance = myObj.nextFloat();

        //Adding Values to the List
        HospitalCodeList.add(HospitalCode);
        DonationBalanceList.add(DonationBalance);
        HospitalnameList.add(Hospitalname);
        // Read user input
        HospitalDonation.addTransF(DonationBalance ,servicename);
        HospitalDonation=null;
        HospitalDonation=new Transactions();
    }
}

