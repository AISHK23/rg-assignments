import java.sql.*;
import java.util.Scanner;

public class EmployeeJDBC {
	Connection con=null;
	public void connect()
	{
        String url="jdbc:mysql://localhost:3306/assignment";
        String uname="root";
        String pwd="ram123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url,uname,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addEmployee(Employee e) throws Exception
	{
		String query="insert into Employee values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,e.id);
		ps.setString(2,e.name);
		ps.setString(3,e.department);
		ps.executeUpdate();
		System.out.println("Added Successfully!");
	}
	
	public void deleteEmployee(int id) throws Exception
	{
		String query="delete from Employee where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Deleted Successfully!");
	}
	public void updateEmployee(int id,String department) throws Exception
	{
		String query="update Employee set department=? where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,department);
		ps.setInt(2, id);
		ps.executeUpdate();
		System.out.println("Employee update successfull!");
	}
	public void getallEmployee() throws Exception
	{
		System.out.println("Employee Details: ");
		String query="select * from Employee";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String department=rs.getString("department");
			System.out.println("id      Name       Department");
			System.out.println(id+"       "+name+"       "+department);
		}
		
	}
	
	public void getEmployee(int id) throws Exception
	{
		System.out.println("Employee Details: ");
		String query="select * from Employee where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		String name=rs.getString("name");
		String department=rs.getString("department");
		System.out.println("id      Name       Department");
		System.out.println(id+"       "+name+"       "+department);
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmployeeJDBC employees=new EmployeeJDBC();
		
		employees.connect();
		Scanner sc = new Scanner(System.in);
	       char ch;
	       do{
	       System.out.println("Enter your choice :");
	       System.out.println("1.Add an employee");
	       System.out.println("2.Update Employee");
	       System.out.println("3.Remove an employee");
	       System.out.println("4.Search an employee");
	       System.out.println("5.Print all employees");
	
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
	           employees.addEmployee(employee);
	           break;
	        case 2:
	           System.out.println("Enter id of the employee: ");
	           int i=sc.nextInt();
	           System.out.println("Enter department of the employee: ");
	            dept = sc.next();
	           employees.updateEmployee(i,dept);
	           break;
	        case 3: 
	           System.out.println("Enter id of the employee: ");
	           id=sc.nextInt();
	           employees.deleteEmployee(id);
	           break;
	        case 4:
	           System.out.println("Enter id of the employee: ");
	           id=sc.nextInt();
	           employees.getEmployee(id);
	           break;
	        case 5:
	           System.out.println("The employees are: ");
	           employees.getallEmployee();
	           break;

	        default:
	           break;  
	        
	       }
	       System.out.println("Do you want to continue(y/n): ");
	       ch=sc.next().charAt(0);
	       }while(ch=='y');
	       sc.close();

		
		
		

	}

}

class Employee
{
	int id;
	String name;
	String department;
	public Employee(int id,String name,String department)
	{
		this.id=id;
		this.name=name;
		this.department=department;
	}
}
