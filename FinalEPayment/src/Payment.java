

import java.util.Scanner;

public abstract class Payment {

    public String username;

    public  void  Pay(float amount)
    {

    }
    //check next func
    public void SetPaymentBehaviour()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        int choice = myObj.nextInt();  // Read user input

        if(choice == 1){
            Payment PaymentBehaviour=new CreditCard();
            PaymentBehaviour.Pay(500);
        }
        else if(choice == 2){
//            Payment PaymentBehaviour=new Cash();
//            PaymentBehaviour.Pay(500);
        }



    }

}
