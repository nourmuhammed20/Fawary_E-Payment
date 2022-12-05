
import java.util.Scanner;


public class UserMenu extends Menu {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    Accounts user=new User();
    Refund ref=new Refund();
    Forms f;
    boolean flag =true;
    public void Usermenu(){
        while(flag){
            System.out.println("Start up Menu");
            System.out.println("------------------ ");
            System.out.println("1-Sign in\n2-Sign Up ");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                user.SignIn();

                this.User_interface();

            }
//    user interface
            else if (choice == 2) {
                user.SignUp();
//                user.SignIn();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }
    }

    public void User_interface() {
        while(flag){
            System.out.println("Main Services");
            System.out.println("------------------ ");
            System.out.println("1-Search Service\n" +
                    "2-Pay Service\n" +
                    "3-Refund Transaction\n" +
                    "4-Sign out");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                searchtool s=new searchtool();
                s.search();
            }
            else if (choice == 2) {
                this.Services();
            }
            else if (choice == 3) {
                ref.refund();
            }
            else if (choice == 4) {
                mainmenu();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }}

    public void Services() {
        while (flag) {
            System.out.println("Services_pkg");
            System.out.println("------------------ ");
            System.out.println("1-Mobile Recharge\n" +
                    "2-Internet Payment\n" +
                    "3-Landline\n" +
                    "4-Donations\n"+
                    "5-Return to Previous Menu");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                this.Mobilemenu();
            }
//    user interface
            else if (choice == 2) {
                this.Internetmenu();
            }
            else if (choice == 3) {
                this.Landlinemenu();
            }
            else if (choice == 4) {
                DonationsMenu();
            }
            else if (choice == 5) {
                User_interface();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }
    }


    public void Mobilemenu(){
        while(flag){

            System.out.println("Mobile Service Providers");
            System.out.println("------------------ ");
            System.out.println("1-Vodafone Service Provider\n" +
                    "2-We Service Provider\n" +
                    "3-Etisalat Service Provider\n" +
                    "4-Return to Previous Menu");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                vodafone_mobile v = new vodafone_mobile();
                f =new vodafoneMform();
                this.Paymentmenu();
            }
            else if (choice == 2) {
                We_mobile w = new We_mobile();
                f =new weMform();
                this.Paymentmenu();
            }
            else if (choice == 3) {
                etisalat_mobile et = new etisalat_mobile();
                f =new etisalatMform();
                this.Paymentmenu();
            }
            else if (choice == 4) {
                Services();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }
    }


    public void Internetmenu(){
        while(flag){

            System.out.println("Internet Service Providers");
            System.out.println("------------------ ");
            System.out.println("1-Vodafone Service Provider\n" +
                    "2-We Service Provider\n" +
                    "3-Etisalat Service Provider\n" +
                    "4-Return to Previous Menu");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                vodafone_Internet v = new vodafone_Internet();
                f =new vodafoneIform();
                this.Paymentmenu();
            }
            else if (choice == 2) {
                We_Internet w = new We_Internet();
                f =new weIform();
                this.Paymentmenu();
            }
            else if (choice == 3) {
                etisalat_internet et = new etisalat_internet();
                f =new etisalatIform();
                this.Paymentmenu();
            }
            else if (choice == 4) {
                Services();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }
    }

    public void Landlinemenu(){
        while(flag){

            System.out.println("Landline Menu");
            System.out.println("------------------ ");
            System.out.println("1-Landline Quarter Receipt\n" +
                    "2-Landline Monthly Receipt\n"  +
                    "3-Return to Previous Menu");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                LandlineQ w = new LandlineQ();
                f =new landlineQform();
                this.Paymentmenu();
            }
            else if (choice == 2) {
                LandlineM w = new LandlineM();
                f =new etisalatMform();
                this.Paymentmenu();
            }
            else if (choice == 3) {
                Services();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }
    }

    public void DonationsMenu(){
        while(flag){

            System.out.println("Donations Menu");
            System.out.println("------------------ ");
            System.out.println("1-Schools\n" +
                    "2-Hospitals\n"  +
                    "3-Return to Previous Menu");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                SchoolsDonation w = new SchoolsDonation();
                f =new SchoolsForm();
                this.Paymentmenu();
            }
            else if (choice == 2) {
                HospitalsDonations w = new HospitalsDonations();
                f =new HospitalsForm();
                this.Paymentmenu();
            }
            else if (choice == 3) {
                Services();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }
    }


    public void Paymentmenu(){
        while(flag){
            System.out.println("Payment Method");
            System.out.println("------------------ ");
            System.out.println("Default Payment Method is Credit press\n1-Continue\n2-Other Methods");
            int choice;
            CreditCard creditecard=new CreditCard(user.instance_user);
            choice=myObj.nextInt();
            if(choice==1){
            creditecard.Pay(f.balanceRecharge);
            User_interface();
            }
            else if(choice==2){
                System.out.println("Payment Method");
                System.out.println("------------------ ");

                System.out.println("1-Pay with Credit Card\n" +
                        "2-Pay with Cash\n" +
                        "3-Pay with Wallet\n" +
                        "4-Add Money to Wallet\n" +
                        "5-Return to Main Menu");
                int opt = myObj.nextInt();  // Read user input
                if (opt == 1) {
                    creditecard.Pay(f.balanceRecharge);
                    User_interface();
                }
                else if (opt == 2) {
                    Cash c=new Cash(user.instance_user);
                    if(f.setFlag()){
                    c.Pay(f.balanceRecharge);
                    }
                    else if(f.setFlag()==false){
                        System.out.println("Service Doesn't Support Cash ");
                        Paymentmenu();
                    }
                    User_interface();
                }
                else if (opt == 3) {
                    creditecard.Walletpay(f.balanceRecharge);
                    User_interface();
                }
                else if (opt==4){
                    creditecard.addWalletPoints();
                    Paymentmenu();
                    User_interface();
                }
                else if (opt == 5) {
                    User_interface();
                }
                else {
                    System.out.println("Choose right option ...");
                }
            }
            else{
                System.out.println("Wrong input try again");
                this.Paymentmenu();
            }
        }
    }
}
