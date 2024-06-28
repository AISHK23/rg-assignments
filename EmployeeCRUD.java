import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


class Employee
{
    private int id;
    private String name;
    private String department;

    public  Employee(int id,String name,String department)
    {
        this.id=id;
        this.name=name;
        this.department=department;
    }
    public void setid(int id)
    {
        this.id=id;
    }
    public void setname(String name)
    {
        this.name=name;
    }
    public void setdepartment(String department)
    {
        this.department=department;
    }

    public int getid()
    {
        return id;
    }
 
    public String getname()
    {
       return name;
    }

    public String getdepartment()
    {
       return department;
    }

    
}



public class EmployeeCRUD {

   public List<Employee> employees=new ArrayList<Employee>(); 

   
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
        System.out.println("Succeessfully added!"); 
      
    }

    public void removeemployee(int id)
    {
        Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()) {
        Employee emp = iterator.next();
        if (emp.getid() == id) {
            iterator.remove();
            System.out.println("Succeessfully removed!"); 
            return;
        }
    }
    System.out.println("Employee not found!");
        
    }
    
    public void updateemployee(int id,String dept)
    {

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getid() == id) {

                emp.setdepartment(dept);
                System.out.println("Sucessfully updated!");
                return;
            }
        }
        System.out.println("Employee not found!");
       
    }

    public void search(int id)
    {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getid() == id) {

                System.out.println("Employee details: ");
                getEmployee(id);
                return;
            }
        }
        System.out.println("Employee not found! ");
    }
    
    public void getEmployee(int id)
    {
        for(Employee employee: employees)
        {
            if(employee.getid()==id)
            {
               System.out.println("Name"+ "  "+"ID "+"  "+"Department");
               System.out.println(employee.getname()+"   "+employee.getid()+"   "+ employee.getdepartment());
               return;
               
            }
        }
    }

    public void getAllEmployees() {
        System.out.println("Name"+ "  "+"ID "+"  "+"Department");
       for(Employee employee : employees)
       {
         System.out.println(employee.getname()+"   "+employee.getid()+"  "+ employee.getdepartment());
       }
    }
    
    public static void main(String a[])
    {
       EmployeeCRUD employeecrud=new EmployeeCRUD();
       Scanner sc = new Scanner(System.in);
       char ch;
       do{
       System.out.println("Enter your choice :");
       System.out.println("1.Add an employee");
       System.out.println("2.Update Employee");
       System.out.println("3.Remove an employee");
       System.out.println("4.Search an employee");
       System.out.println("5.Print all employees");
       System.out.println("6.Quit");
       int option = sc.nextInt();
       switch (option) {
        case 1:
           System.out.println("Enter id of the employee: ");
           int id=sc.nextInt();
           System.out.println("Enter name of the employee: ");
           String name = sc.next();
           System.out.println("Enter department of the employee: ");
           String dept = sc.next();
           Employee employee=new Employee(id, name, dept);
           employeecrud.addEmployee(employee);
           break;
        case 2:
           System.out.println("Enter id of the employee: ");
           int i=sc.nextInt();
           System.out.println("Enter department of the employee: ");
            dept = sc.next();
           employeecrud.updateemployee(i,dept);
           break;
        case 3: 
           System.out.println("Enter id of the employee: ");
           id=sc.nextInt();
           employeecrud.removeemployee(id);
           break;
        case 4:
           System.out.println("Enter id of the employee: ");
           id=sc.nextInt();
           employeecrud.search(id);
           break;
        case 5:
           System.out.println("The employees are: ");
           employeecrud.getAllEmployees();
           break;
        case 6:
         return;
        default:
           break;  
        
       }
       System.out.println("Do you want to continue(y/n): ");
       ch=sc.next().charAt(0);
       }while(ch=='y');
       sc.close();
    }   
}