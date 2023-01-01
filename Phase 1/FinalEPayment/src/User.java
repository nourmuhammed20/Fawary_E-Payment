
import java.util.ArrayList;
import java.util.Scanner;



public class User extends Accounts {
        ArrayList<String> PasswordList=new ArrayList<String>();
        ArrayList<String> EmailList=new ArrayList<String>();
        ArrayList<String> UsernamesList=new ArrayList<String>();

        public Menu m;
//        public String instance_user;
        boolean flag = true;
   public String Username;
   Refund ref;
    boolean check=false;
    @Override
    public void SignIn() {

        UsernamesList.add("n");
        UsernamesList.add("s");
        UsernamesList.add("g");
        PasswordList.add("n");
        PasswordList.add("s");
        PasswordList.add("g");


        while (flag){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        Username= myObj.nextLine();  // Read user input
        System.out.println("Enter Password");
        String Password = myObj.nextLine();  // Read user input



            for(int i = 0; i < UsernamesList.size(); i++)
            {
                check=false;
                if (Username.equals(UsernamesList.get(i)) && PasswordList.get(i).equals(Password))
                {


                    System.out.println("valid");
                    flag =false;
                    instance_user=Username;
                    check=true;

                    break;

                }

            }
            if(check==false)
            {
                System.out.println("invalid data");
            }
            if(UsernamesList.isEmpty()){
             System.out.println("No Registered Accounts \nPlease,sign up first");
            }
            // add Update Notifications
            this.updateNotfication();



        }
    }


    public void SignUp() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter username : ");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Enter Email Address : ");
        String Email = myObj.nextLine();  // Read user input
        EmailList.add(Email);
        if(UsernamesList.isEmpty()){
            UsernamesList.add(userName);
            System.out.println("Enter New Password : ");
            String Password = myObj.nextLine();  // Read user input
            PasswordList.add(Password);        }
        else{
            for(int i = 0; i < UsernamesList.size(); i++)
            {

                if (userName.equals(UsernamesList.get(i)))
                {
                    System.out.println("username already exists ...");
                }
                else if(Email.equals(EmailList.get(i)))
                {
                    System.out.println("Email already exists ...");

                }
                else{
                    UsernamesList.add(userName);
                    System.out.println("Enter New Password : ");
                    String Password = myObj.nextLine();  // Read user input
                    PasswordList.add(Password);
            }
            }
        }
    }
    public void updateNotfication()
    {



        for(int i=0;i<ref.AcceptedNameList.size();i++)
        {

            if(ref.AcceptedNameList.isEmpty())
            {
                break;
            }
            if(this.Username.equals(ref.AcceptedNameList.get(i)))
            {
                System.out.println("Transaction : "+ref.AcceptedRefundIdList.get(i) +"  is Accepted");
                ref.AcceptedNameList.remove(ref.AcceptedNameList.get(i));
                ref.AcceptedRefundIdList.remove(ref.AcceptedRefundIdList.get(i));
            }
        }
        for(int i=0;i<ref.RejectedNameList.size();i++)
        {

            if(ref.RejectedNameList.isEmpty())
            {
                break;
            }

            else if(this.Username.equals(ref.RejectedNameList.get(i)))
            {
                System.out.println("Transaction : "+ref.RejectedRefundIdList2.get(i) +" is Rejected");
                ref.RejectedNameList.remove(ref.RejectedNameList.get(i));
                ref.RejectedRefundIdList2.remove(ref.RejectedRefundIdList2.get(i));
            }



        }




    }


}
