
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Accounts{
    ArrayList<String> APasswordList=new ArrayList<String>();
    ArrayList<String> AUsernamesList=new ArrayList<String>();

    boolean flag = true;



    @Override
    public void SignIn() {
        AUsernamesList.add("n");
        AUsernamesList.add("Samy");
        AUsernamesList.add("Ganna");
        AUsernamesList.add("Salma");
        APasswordList.add("n");
        APasswordList.add("nn");
        APasswordList.add("123g");
        APasswordList.add("123sa");

        while (flag){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter username");
            String Username= myObj.nextLine();  // Read user input
            System.out.println("Enter Password");
            String Password = myObj.nextLine();  // Read user input


            for(int i = 0; i < AUsernamesList.size(); i++)
            {
                if (Username.equals(AUsernamesList.get(i)) && APasswordList.get(i).equals(Password))
                {

                    System.out.println("valid");
                    flag =false;
                    break;

                }
                    else {
                    System.out.println("invalid data");
                    break;

                }
            }
        }}
}
