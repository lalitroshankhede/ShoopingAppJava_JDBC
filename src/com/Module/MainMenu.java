package com.Module;

 
import java.util.Scanner;

 

 

public class MainMenu {

	public void mainMenu()     {
		System.out.println("----- Choose Option -------");
		System.out.println("1.Add Product");
		System.out.println("2.Update Product");
		System.out.println("3.Delete Product");
		System.out.println("4.Get Single Product");
		System.out.println("5.Display All Product");
		System.out.println("6.Get No. of Product");
		

		int choose;
		Scanner input = new Scanner(System.in);
		choose = input.nextInt();
		switch (choose) {
		case 1:
			 ProductDaoImpl obj=new ProductDaoImpl();
			 obj.insertProduct();
                
			break;

		case 2:
			 ProductDaoImpl obj2=new ProductDaoImpl();
			 obj2.updateProduct();

			break;
		case 3:
			 ProductDaoImpl obj3=new ProductDaoImpl();
			 obj3.deleteProduct();
			break;
		case 4:
			 ProductDaoImpl obj4=new ProductDaoImpl();
			 obj4.getSingleData();
			break;
		case 5:
			 ProductDaoImpl obj5=new ProductDaoImpl();
			 obj5.getProducts();
			break;
		 
		case 6:
			ProductDaoImpl obj6=new ProductDaoImpl();
			obj6.getNoProducts();
			 break;

		default:
			System.out.println("Invalid Option Try Again !");
			new MainMenu();
			break;
		}
	}
}
