
import java.util.Scanner;


public class CreditCard extends Payment {


    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    public String username;
    public static float CreditAmount;
    float walletPoints=0;
    float walletInputs;

    Transactions trans=new Transactions();
    public CreditCard(String name)
    {
        username=name;
    }
    public CreditCard()
    {

    }

    public void AddCreditamount(){
        Transactions t1=new Transactions();
        System.out.println("Enter your Credit Amount : ");
        Scanner myObj3 = new Scanner(System.in);  // Create a Scanner object
        CreditAmount = myObj3.nextFloat();  // Read user input
    }

    //Check Credit amount for new users
    public void Pay(float amount){

        AddCreditamount();
        if(amount>CreditAmount)
        {
            System.out.println("No Enough Balance in the credit Card.");
        }
        else
        {
            System.out.println("You will be charged with "+amount);
            System.out.println("Are you sure you want to proceed?\n1-Yes\n2-NO ");
            Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
            int opt = myObj2.nextInt();  // Read user input

            if (opt == 1) {
                System.out.println("Your Credit become "+(CreditAmount-(amount)));
                CreditAmount-=amount;
                trans.addTransU(username);
            }
            else if (opt == 2) {
                System.out.println("Transaction has been Canceled.");
            }

        }
        }

    public float addWalletPoints()
    {

        AddCreditamount();
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter value to add to your wallet ");
       // Read user input
        walletInputs = myObj.nextFloat();
        if(walletInputs>CreditAmount){
            System.out.println("No Enough Money in the Card");
            AddCreditamount();
            addWalletPoints();
        }
        else{
            walletPoints += walletInputs;
             CreditAmount-=walletInputs;
        }
            return walletPoints;
    }
    public void Walletpay(float amount){
        Transactions t1=new Transactions();
        if(walletPoints==0||amount>walletPoints){
            System.out.println("No Enough Balance in the Wallet.");
            addWalletPoints();
            Walletpay(amount);
        }
        else  {

                System.out.println("You will be charged with "+amount);
                System.out.println("Are you sure you want to proceed?\n1-Yes\n2-NO ");
                Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
                int opt = myObj2.nextInt();  // Read user input

                if (opt == 1) {
                    System.out.println("Your Credit money become "+(CreditAmount));
                    System.out.println("Your Wallet Credit become "+(walletPoints-(amount)));
                    walletPoints-=amount;
                    trans.addTransU(username);
                }
                else if (opt == 2) {
                    System.out.println("Transaction has been Canceled.");
                }
            }
    }



    public void displayCardData()
    {
        System.out.println("Credit Money :"+ CreditAmount+
                "\nWallet Money : "+walletPoints
        );
    }
}
