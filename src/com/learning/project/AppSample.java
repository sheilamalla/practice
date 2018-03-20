package com.learning.project;

import java.util.Scanner;

public class AppSample {

	final static BankAppServiceSample service = new BankAppServiceSample();
	final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("*********Banking Application**************");
		System.out.println("1. Customer");
		System.out.println("2. Bank Employee");
		System.out.println("3. Bank Admin");
		System.out.println("4. Exit");
		
		System.out.println("select 1 if you are customer, 2 if you are Bank employee or 3 if you are bank admininstration");
		String selection;
		selection = scan.next();
		RegisteredUserSample loggedInUser =null;
		String selectedService;
		switch(selection) {
		case "1":
			
			while(loggedInUser== null)
			{
				System.out.println("1. Register");
				System.out.println("2. Login");
			}
			System.out.println("Enter an valid option from above:");
			switch(selection)
			{
			case "1": 
				System.out.println("Enter username: ");
				String username = scan.next();
				System.out.println("Enter password: ");
				String password = scan.next();
				String registerationStatus= service.register(username, password);
				System.out.println(registerationStatus);
			}
			break;
			
			case "2":
				System.out.println("Enter username: ");
				String username = scan.next();
				System.out.println("Enter password: ");
				String password = scan.next();
				loggedInUser = service.login(username, password);
				if(loggedInUser == null)
				{
					System.out.println("invalid login!");
				}
				else
					System.out.println("************logged in successfully***********");
				
				break;
				
			case "3":
				
			
			
		default:
			System.out.println("Please select a valid option.");
		
	}

	boolean check =true;
	while(check)
	{
		
		if(loggedInUser!= null && !service.hasExistingAccount(loggedInUser.getUsername())) {
			System.out.println("1. Apply for single account");
			System.out.println("2. Apply for joint account");
			System.out.println("Enter an valid option from above:");
			scan.nextLine();
			selection = scan.next();
			switch(selection) {
			
			case "1":
				System.out.println("************Applying for single account**********");
				UserInfo userInfo = userInformationToApply(loggedInUser);
				UserInfo jointUser = new UserInfo();
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter information about joint user below:");
				System.out.print("Enter your first name: ");
				String firstName2 = scanner.next();
				System.out.println("Enter your last name: ");
				String lastName2 = scanner.next();
				System.out.println("Enter your email: ");
				String email2 = scanner.next();
				System.out.println("Enter your address: ");
				String address2 = scanner.next();
				
				jointUser.setFirstName(firstName2);
				jointUser.setLastName(lastName2);
				jointUser.setEmail(email2);
				jointUser.setAddress(address2);
				jointUser.setRegisteredUser(loggedInUser);
				String applyJointStatus = service.applyToOpenJointAccount(userInfo,jointUser,0);
				
			}
		}
		
		
	}
	}

	private static UserInfo userInformationToApply(RegisteredUserSample loggedInUser) {
		UserInfo userInfo = new UserInfo();
		System.out.println("Enter your first name: ");
		String firstName = scan.next();
		System.out.println("Enter your last name: ");
		String lastName = scan.next();
		System.out.println("Enter your email: ");
		String email = scan.next();
		System.out.println("Enter your address: ");
		String address =scan.next();
		
		
		userInfo.setFirstName(firstName);
		userInfo.setLastName(lastName);
		userInfo.setEmail(email);
		userInfo.setAddress(address);
		userInfo.setRegisteredUser(loggedInUser);
		return userInfo;
	}

	
	
}
