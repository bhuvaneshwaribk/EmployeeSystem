package bitlabs.jdbc1;

import java.sql.SQLException;

public interface DaoEmployee {
public void addEmployee(Employee e) throws SQLException;
public void updateEmployeeName(int id,String name) throws SQLException;
public void updateEmployeeAddress(int id,String addrs) throws SQLException;
public void updateEmployeeDesignation(int id,String desig) throws SQLException;
public void searchEmployee(int id)throws SQLException;
public void removeEmployee(int id)throws SQLException; 
public void displayEmployee()throws SQLException;
public void displayEmployeeBasedOnDesignation(String desig)throws SQLException;

}
