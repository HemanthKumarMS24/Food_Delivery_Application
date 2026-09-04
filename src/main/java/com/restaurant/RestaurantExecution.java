package com.restaurant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class RestaurantExecution {
	
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//name,cuisine_type,address,phone_number,email,delivery_time,rating,image,is_active,created_at
		System.out.println("Enter the Name of the Restaurant: ");
		String name = scan.next();
		scan.nextLine();
		
		
		System.out.println("Enter the cuisine_type: ");
		String cuisine_type = scan.next();
		scan.nextLine();
		
		
		System.out.println("Enter the address: ");
		String address = scan.next();
		scan.nextLine();
		
		
		System.out.println("Enter the phone_number of the Restaurant :  ");
		String phone_number = scan.next();
		scan.nextLine();
		
		
		System.out.println("Enter the email : ");
		String email = scan.next();
		scan.nextLine();
		
		
		System.out.println("Enter the delivery_time: ");
		int delivery_time = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter the rating: ");
		BigDecimal rating = scan.nextBigDecimal();
		scan.nextLine();
		
		
		System.out.println("Enter the restaurant image path:");
		String path = scan.nextLine();

		FileInputStream image = null;

		try {
		    image = new FileInputStream(path);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		    return;
		}
		
		
		
		System.out.println("Enter is_active");
		Boolean is_active = scan.nextBoolean();
		
		Restaurant r = new Restaurant(name,cuisine_type,address,phone_number,email,delivery_time,rating,image,is_active);
		ReastorantImplementation ri = new ReastorantImplementation();
		
		ri.add(r);
		
		
		
		
	}

}
