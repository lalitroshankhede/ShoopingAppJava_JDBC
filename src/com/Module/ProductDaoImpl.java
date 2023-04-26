package com.Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.db.DBConnection;

public class ProductDaoImpl implements ProductDao{

	// scanner object to take input runtime
	Scanner input = new Scanner(System.in);

	// Object of POJO/BEan class /
	Product prod = new Product();

	// Insert Data

	public void insertProduct() {
		System.out.println("Enter the Id of Product");
		int prod_id = input.nextInt();
		System.out.println("Enter the Name of Product");
		String prod_name = input.next();
		System.out.println("Enter the Price of Product");
		int prod_price = input.nextInt();
		prod.setProd_id(prod_id);
		prod.setProd_name(prod_name);
		prod.setProd_price(prod_price);
		Connection con = DBConnection.getConn();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into Product values(?,?,?)");
			stmt.setInt(1, prod.getProd_id());
			stmt.setString(2, prod.getProd_name());
			stmt.setInt(3, prod.getProd_price());
			stmt.executeUpdate();
			System.out.println("Product Inserted");
			System.out.println("Do you want to Continue? 1.Yes 2.No");
			int choose = input.nextInt();
			if (choose == 1) {
				insertProduct();
			} else {
				new MainMenu().mainMenu();
			}

			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Update Data

	public void updateProduct() {
		System.out.println("Enter the Id of Product");
		int prod_id = input.nextInt();
		System.out.println("Enter the Name of Product want to Update ");
		String prod_name = input.next();
		prod.setProd_id(prod_id);
		prod.setProd_name(prod_name);
		Connection con = DBConnection.getConn();
		try {
			PreparedStatement stmt = con.prepareStatement("update Product set prod_name=? where prod_id=?");
			stmt.setString(1, prod.getProd_name());
			stmt.setInt(2, prod.getProd_id());

			stmt.executeUpdate();
			System.out.println("Product Updated");
			System.out.println("Do you want to Continue? 1.Yes 2.No");
			int choose = input.nextInt();
			if (choose == 1) {
				updateProduct();
			} else {
				new MainMenu().mainMenu();
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// Delete Product

	public void deleteProduct() {
		System.out.println("Enter Id of Product");
		int prod_id = input.nextInt();
		prod.setProd_id(prod_id);
		Connection con = DBConnection.getConn();

		try {

			PreparedStatement pmt = con.prepareStatement("delete from Product where prod_id=?");
			pmt.setInt(1, prod.getProd_id());
			pmt.executeUpdate();
			System.out.println("Product Deleted");
			System.out.println("Do you want to Continue? 1.Yes 2.No");
			int choose = input.nextInt();
			if (choose == 1) {
				deleteProduct();
			} else {
				new MainMenu().mainMenu();
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Getting Single Record From Database using Id

	public void getSingleData() {

		System.out.println("Enter Id of Product");
		int prod_id = input.nextInt();
		prod.setProd_id(prod_id);
		Connection con = DBConnection.getConn();

		try {

			PreparedStatement pmt=con.prepareStatement("select * from Product where prod_id=?");
			pmt.setInt(1, prod.getProd_id());
			ResultSet rs = pmt.executeQuery();
			while (rs.next()) {

				System.out.println("Product Id=" + rs.getInt(1) + " " + "Product Name=" + rs.getString(2) + " "
						+ "Product Price=" + rs.getInt(3));
			}
			
			System.out.println("Do you want to Continue? 1.Yes 2.No");
			int choose = input.nextInt();
			if (choose == 1) {
				getSingleData();
			} else {
				new MainMenu().mainMenu();
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	// Display All Records from the Database
	
	
	public List<Product> getProducts(){
		 
		List<Product> list=new ArrayList<>();
		Connection con= DBConnection.getConn();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Product");
			 while (rs.next()) {
				 prod = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3));
				list.add(prod);
			}
			 
			 Iterator<Product> itr=list.iterator();
			 while (itr.hasNext()) {
				Product product = (Product) itr.next();
				System.out.println("Product Id"+product.getProd_id()+"Product Name="+product.getProd_name()+"Product Price"+product.getProd_price());
			}
			 
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
		
		 
		
	}

	
	
	
	
	
	
	
	
	
	// Display No. of Record
	
	@Override
	public List<Product> getNoProducts() {
		System.out.println("Enter N no. of Record if you want ");
		int totalRecord=input.nextInt();
		
		List<Product> list=new ArrayList<>();
		Connection con= DBConnection.getConn();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Product");
			 while (rs.next()) {
				 prod = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3));
				list.add(prod);
			}
			 for (int i = 1; i <= totalRecord; i++) {
				 Iterator<Product> itr=list.iterator();
				 while (itr.hasNext()) {
					Product product = (Product) itr.next();
					System.out.println("Product Id"+product.getProd_id()+"Product Name="+product.getProd_name()+"Product Price"+product.getProd_price());
				}
				}
			 
			con.close();
			 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	 
	}
	

}
