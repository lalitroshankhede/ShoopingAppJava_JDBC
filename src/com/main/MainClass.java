package com.main;

import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		System.out.println("--------- Welcome To MyShoop App ----------");
		 
		
		Authentication obj=new Authentication();
		obj.logAuth();
		

	}

}
