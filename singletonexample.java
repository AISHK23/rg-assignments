public class singletonexample  {

    public static void main(String a[])
    {
        singleton obj1=singleton.getInstance();
        singleton obj2=singleton.getInstance();

    }
    
}

class singleton {
    private static singleton obj=new singleton();
    private singleton()
    {
        System.out.println("Instance created.");
    }
    public static singleton getInstance()
    {
        return obj;
    }
    
}