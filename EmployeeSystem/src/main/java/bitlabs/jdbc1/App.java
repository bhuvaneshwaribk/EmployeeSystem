package bitlabs.jdbc1;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException 
    {
    	Scanner sc=new Scanner(System.in);
    	DaoImpl dao=new DaoImpl();
    	while(true) {
    	System.out.println(" 1.Add Employe \n 2.Update Employee Name \n 3.Update Employee Address \n 4.Update Employee Designation \n 5.Search Employee \n 6.Remove Employee \n 7.Display Employee \n 8.Display Employee Based on Department\n 9.Exit");
    	System.out.println("enter your choice");
    	int choice=sc.nextInt();
    	
    	switch(choice) {
    	
    	case 1:
    		System.out.println("enter number of employe to be added");
    		int num=sc.nextInt();
    		Employee emp[]=new Employee[num];
    		for(int i=0;i<num;i++) {
    			emp[i]=new Employee();
    			System.out.println("enter id");
    			int id=sc.nextInt();
    			emp[i].setId(id);
    			sc.nextLine();
    			System.out.println("enter name");
    			String name=sc.nextLine();
    			emp[i].setName(name);
    			System.out.println("enter address");
    			String addrs=sc.nextLine();
    			emp[i].setAddress(addrs);
    			System.out.println("enter designation");
    			String desig=sc.nextLine();
    			emp[i].setDesignation(desig);
    			System.out.println("enter salary");
    			double salary=sc.nextDouble();
    			emp[i].setSalary(salary);
    			
    			try {
    			dao.addEmployee(emp[i]);
    			}
    			catch(Exception e2) {
    				System.out.println(e2);
    			}
    		}
    		break;
    		
    	case 2:
    		System.out.println("enter employee id to update");
    		int id1=sc.nextInt();
    		System.out.println("enter name to be updated as");
    		String name=sc.next();
    		try {
    		dao.updateEmployeeName(id1,name);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		break;
    		
    	case 3:
    		System.out.println("enter employee id to update");
    		int id2=sc.nextInt();
    		System.out.println("enter address to be updated as");
    		String addrs=sc.next();
    		try {
    		dao.updateEmployeeAddress(id2,addrs);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		break;
    		
    	case 4:
    		System.out.println("enter employee id to update");
    		int id3=sc.nextInt();
    		System.out.println("enter designation to be updated as");
    		String desig=sc.next();
    		try {
    		dao.updateEmployeeDesignation(id3,desig);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		break;
    		
    		
    	case 5:
    		
    		System.out.println("enter id to search employee");
    		int id4=sc.nextInt();
    		try {
    		dao.searchEmployee(id4);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		break;
    		
    	case 6:
    		System.out.println("enter id to remove employee");
    		int id5=sc.nextInt();
    		try {
    		dao.removeEmployee(id5);
    		}
    		catch(Exception e) {
    		System.out.println(e);
    		}
    		break;
    		
    	case 7:
    		try {
    		dao.displayEmployee();
    		}
    		catch(Exception e) {
        		System.out.println(e);
    		}
    		break;
    		
    	case 8:
    		try {
    			System.out.println("enter designation");
        		String desig1=sc.next();
        		dao.displayEmployeeBasedOnDesignation(desig1);
        		}
        		catch(Exception e) {
            		System.out.println(e);
        		}
        		break;
    	case 9:
    		System.exit(0);
    	
    	}
    	
    }
    }
}
