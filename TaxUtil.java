public class TaxUtil {
    
    public static double calculateTax(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String a[])
    {
        //same outputs are produced for same inputs.
        double amount=20500.0;
        double rate= 4.2;
        System.out.println("Tax for amount "+amount+" and rate "+rate+ ":" +calculateTax(20500, 4.2));
        System.out.println("Tax for amount "+amount+" and rate "+rate+ ":" +calculateTax(20500, 4.2));
    }
}