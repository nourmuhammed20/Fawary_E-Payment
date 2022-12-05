
public class Cash extends Payment{
    Transactions trans=new Transactions();
    public Cash(String name)
    {
        username=name;
    }
    public void Pay(float amount )
    {
           System.out.println("You will be charged with "+amount);
           System.out.println("Transaction Completed ...");
           trans.addTransU(username);

    }
}
