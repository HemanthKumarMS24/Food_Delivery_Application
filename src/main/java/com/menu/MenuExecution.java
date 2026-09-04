package com.menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class MenuExecution {
	
	static Scanner scan= new Scanner(System.in);

	public static void main(String[] args) {
//restaurantid,itemname,description,price,category,image,isavailable
		System.out.println("Enter the Restaurant ID: ");
		int restaurantid = scan.nextInt();
		
		scan. nextLine();
		System.out.println("Enter the itemname ");
		String itemname = scan.nextLine();
		
		System.out.println("Enter the description");
		String description = scan.nextLine();
		
		
		System.out.println("Enter the price");
		BigDecimal price = scan.nextBigDecimal();
		scan. nextLine();
		
		System.out.println("Enter the category");
		String category = scan.nextLine();
		
		System.out.println("Enter the menu image path:");
		String path = scan.nextLine();

		FileInputStream image = null;

		try {
		    image = new FileInputStream(path);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		    return;
		}
		
		System.out.println("Enter isavailable");
		Boolean isavailable = scan.nextBoolean();
		
		
		Menu m = new Menu(restaurantid, itemname,description,price,category,image,isavailable);
		MenuImplementation mi  = new MenuImplementation();
		mi.addmenu(m);
		
	}

}
