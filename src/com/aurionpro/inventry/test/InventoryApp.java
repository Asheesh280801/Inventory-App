package com.aurionpro.inventry.test;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.aurionpro.inventry.model.InventoryManagementFacade;

public class InventoryApp {
	 public static void main(String[] args) {
	        InventoryManagementFacade facade = new InventoryManagementFacade();
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("\nWelcome to the Inventory Management System");
	            System.out.println("1. Product Management");
	            System.out.println("2. Supplier Management");
	            System.out.println("3. Transaction Management");
	            System.out.println("4. Generate Report");
	            System.out.println("5. Exit");

	            System.out.print("Enter your choice: ");
	            int choice;

	            // Use try-catch to handle invalid input and continue running smoothly
	            try {
	                choice = scanner.nextInt();
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number between 1 and 5.");
	                scanner.nextLine(); // Clear the invalid input
	                continue;
	            }

			switch (choice) {
			case 1:
				System.out.println("1. Add Product");
				System.out.println("2. Update Product");
				System.out.println("3. Delete Product");
				System.out.println("4. View Product");
				System.out.println("5. View All Products");
				System.out.print("Enter your choice: ");
				int productChoice = scanner.nextInt();

				switch (productChoice) {
				case 1: facade.addProduct(); break;
				case 2: facade.updateProduct(); break;
				case 3: facade.deleteProduct(); break;
				case 4: facade.viewProduct(); break;
				case 5: facade.viewAllProducts(); break;
				default: System.out.println("Invalid choice.");
				}
				break;

			case 2:
				System.out.println("1. Add Supplier");
				System.out.println("2. Update Supplier");
				System.out.println("3. Delete Supplier");
				System.out.println("4. View Supplier");
				System.out.println("5. View All Suppliers");
				System.out.print("Enter your choice: ");
				int supplierChoice = scanner.nextInt();

				switch (supplierChoice) {
				case 1: facade.addSupplier(); break;
				case 2: facade.updateSupplier(); break;
				case 3: facade.deleteSupplier(); break;
				case 4: facade.viewSupplier(); break;
				case 5: facade.viewAllSuppliers(); break;
				default: System.out.println("Invalid choice.");
				}
				break;

			case 3:
				System.out.println("1. Add Stock");
				System.out.println("2. Remove Stock");
				System.out.println("3. View Transaction History");
				System.out.print("Enter your choice: ");
				int transactionChoice = scanner.nextInt();

				switch (transactionChoice) {
				case 1: facade.addStock(); break;
				case 2: facade.removeStock(); break;
				case 3: facade.viewTransactionHistory(); break;
				default: System.out.println("Invalid choice.");
				}
				break;

			case 4:
				facade.generateReport();
				break;

			case 5:
				exit = true;
				System.out.println("Exiting the system. Goodbye!");
				break;

			default:
				System.out.println("Invalid choice.");
			}
		}
		scanner.close();
	}
}


