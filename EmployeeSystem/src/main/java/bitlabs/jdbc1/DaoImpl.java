package bitlabs.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoImpl implements DaoEmployee {
	Connection connection;
public DaoImpl() throws ClassNotFoundException, SQLException {
	try {
	//register driver class
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//establish connection
	 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","@Bhuvana9535");
		System.out.println("connection established");

   }
	catch(Exception e) {
		System.out.println(e);
	}
}
	

public void addEmployee(Employee e) throws SQLException {
	
	PreparedStatement ptmt=connection.prepareStatement("insert into employee values(?,?,?,?,?)");
	ptmt.setInt(1,e.getId());
	ptmt.setString(2,e.getName());
	ptmt.setString(3,e.getAddress());
	ptmt.setString(4,e.getDesignation());
	ptmt.setDouble(5,e.getSalary());
	int i=ptmt.executeUpdate();
	if(i>0)
		System.out.println(i+" record affected");
	else
		System.out.println("try again");

}



public void displayEmployee() throws SQLException {
Statement stmt=connection.createStatement();
ResultSet rs=stmt.executeQuery("select * from employee");
while(rs.next()) {
	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDouble(5));
}
}


public void searchEmployee(int id) throws SQLException {
	Statement statement=connection.createStatement();
	String query="select * from employee where id="+id+" ";
    ResultSet rs=statement.executeQuery(query);
    while(rs.next())

    {
    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDouble(5));
    }	
}


public void updateEmployeeAddress(int id,String addrs) throws SQLException {
	PreparedStatement stmt=connection.prepareStatement("update employee set address=? where id="+id+" ");
	stmt.setString(1, addrs);
	int i=stmt.executeUpdate();
	if(i>0)
		System.out.println(i+" record affected");
	else
		System.out.println("try again");
}


public void updateEmployeeName(int id, String name) throws SQLException {
	PreparedStatement stmt=connection.prepareStatement("update employee set name=? where id="+id+" ");
	stmt.setString(1, name);
	int i=stmt.executeUpdate();
	if(i>0)
		System.out.println(i+" record affected");
	else
		System.out.println("try again");
}


public void updateEmployeeDesignation(int id, String desig) throws SQLException {
	PreparedStatement stmt=connection.prepareStatement("update employee set designation=? where id="+id+" ");
	stmt.setString(1, desig);
	int i=stmt.executeUpdate();
	if(i>0)
		System.out.println(i+" records affected");
	else
		System.out.println("try again");
}


public void removeEmployee(int id) throws SQLException {
	PreparedStatement stmt=connection.prepareStatement("delete from employee where id="+id+" ");
	int i=stmt.executeUpdate();	
	if(i>0)
		System.out.println(i+" record affected");
	else
		System.out.println("try again");
}


public void displayEmployeeBasedOnDesignation(String desig) throws SQLException {
	PreparedStatement stmt=connection.prepareStatement("select name,designation from Employee where designation=?");
	stmt.setString(1, desig);
    ResultSet rs=stmt.executeQuery();
    while(rs.next()) {
    	System.out.println(rs.getString(1)+" "+rs.getString(2));
    }
}










}
