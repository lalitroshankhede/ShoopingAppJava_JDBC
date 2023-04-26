package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.Module.MainMenu;

public class Authentication {

	String username="LalitR", password="Pass@123";
	Scanner input=new Scanner(System.in);
	@SuppressWarnings("static-access")
	public void logAuth() throws ClassNotFoundException, SQLException 
	{
		
		String user,pass;
	   System.out.println("Enter Username");
	   user=input.next();
	   System.out.println("Enter Password");
	   pass=input.next();
	   
	   if (user.equals(username) && pass.equals(password)) {
	
		   System.out.println("****** Success ******");
		   MainMenu obj=new MainMenu();
		   obj.mainMenu();
	}
	   else
	   {
		   System.out.println("**** Wrong Username and Password Try Again! *****");
		   MainClass obj=new MainClass();
		   obj.main(null);
	   }
		
	}
}
