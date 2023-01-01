import java.util.Scanner;

public  class Menu {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object

    public int mainmenu(){
        while (true) {
            System.out.println("1-Admin Page ");
            System.out.println("2-User Page ");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                AdminMenu m=new AdminMenu();
                m.Admin_interface();
            }
//    user interface
            else if (choice == 2) {
                UserMenu m=new UserMenu();
                m.Usermenu();
            }
            else {
                System.out.println("Choose right option ...");
            }
        }

    }

}

