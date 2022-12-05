

import java.util.Scanner;

public class AdminMenu extends Menu {


    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    Accounts admin=new Admin();

    Transactions trans=new Transactions();
    Refund ref=new Refund();
    boolean flag =true;

    public void Admin_interface(){
        admin.SignIn();

        while(flag){
            System.out.println("Main Services");
            System.out.println("------------------ ");
            System.out.println("1-List Transaction\n" +
                    "2-List Refund Requests\n"+
                    "3-List Accepted Requests\n"+
                    "4-List Rejected Requests\n"+
                    "5-Sign Out");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                trans.ListTrans();
            }
            else if (choice == 2) {
                ref.ListRequest();
            }
            else if (choice == 3) {
                ref.ListAccept();
            }
            else if (choice == 4) {
                ref.ListReject();
            }

             else if (choice == 5) {
                mainmenu();
            }

            else {
                System.out.println("Choose right option ...");
            }
        }
    }

}
//Check Line  38  41