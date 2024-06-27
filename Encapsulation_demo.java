public class Encapsulation_demo{
    public static void main(String a[])
    {
       Bank obj=new Bank("12345");
       obj.setname("aish");
       System.out.println("Acc no: "+obj.getaccno());
       System.out.println("Acc no: "+obj.getname());
       System.out.println("Acc no: "+obj.getbalance());
    }
}

 class Bank
 {
    private double balance;
    private String name;
    private String accno;
    public Bank(String accno)
    {
        balance=10000;
        this.accno=accno;
    }
    public double getbalance()
    {

        return balance;
    }
    public String getaccno()
    {
        return accno;
    }
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name=name;
    }
 }