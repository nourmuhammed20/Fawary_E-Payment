
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//Add Donations and landline
public class searchtool {

    public ArrayList<String> serviceslist=new   ArrayList <String>();
    public UserMenu menu=new UserMenu();
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
    String ReqService;


    public void search(){
        ArrayList<String> foundedStrings=new ArrayList<String>();
        serviceslist.add("Internet Payment");
        serviceslist.add("Mobile Recharge");
        serviceslist.add("Landline");
        serviceslist.add("Donations");

        System.out.println("Enter Service name to search :");
        ReqService = myObj.nextLine();
        ReqService = ReqService.toLowerCase(Locale.ROOT).replaceAll("\\s", "");

        foundedStrings=this.getString(ReqService);

        if(foundedStrings.size()!=0){
            System.out.println("Your Search Results");
            System.out.println("---------------------");

            for (String i : foundedStrings){
                System.out.println(i);
            }

            System.out.println("Enter Your Choice: ");
            String choice= myObj2.nextLine();

            this.userSearchChoice(choice);
        }

        else {
            System.out.println("No Results Found");
        }
    }

    protected ArrayList<String> getString(String substr){

        ArrayList<String> foundedStrings=new ArrayList<String>();

        for(int i=0;i<serviceslist.size();i++){
            String tmp= serviceslist.get(i).toLowerCase(Locale.ROOT).replaceAll("\\s", "");
            if(tmp.contains(substr))
            {
              foundedStrings.add(serviceslist.get(i));
            }

        }
        return foundedStrings;
    }

    protected void userSearchChoice(String choice){

        if(choice.equals("Internet Payment")){
            menu.Internetmenu();
        }
        else if(choice.equals("Mobile Recharge")){
            menu.Mobilemenu();
        }
        else if(choice=="landline"){
            menu.Landlinemenu();
        }
        else if(choice=="donations"){
            menu.DonationsMenu();
        }
    }
}
