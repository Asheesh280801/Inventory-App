package com.aurionpro.inventry.model;


import java.util.Scanner;

import com.aurionpro.inventry.exception.InventoryException;

public class InventoryManagementFacade {
    private InventoryService inventoryService;

    public InventoryManagementFacade() {
        this.inventoryService = new InventoryService();
    }

    public void addProduct() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Product Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Supplier ID: ");
            String supplierId = scanner.nextLine();

            Product product = new Product(productId, name, description,price, quantity,  supplierId);
            inventoryService.addProduct(product);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateProduct() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID to update: ");
            String productId = scanner.nextLine();
            System.out.print("Enter New Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Product Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter New Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter New Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter New Supplier ID: ");
            String supplierId = scanner.nextLine();

            Product updatedProduct = new Product(productId, name, description, price, quantity,  supplierId);
            inventoryService.updateProduct(productId, updatedProduct);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteProduct() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID to delete: ");
            String productId = scanner.nextLine();
            inventoryService.deleteProduct(productId);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewProduct() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID to view: ");
            String productId = scanner.nextLine();
            inventoryService.viewProduct(productId);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAllProducts() {
        inventoryService.viewAllProducts();
    }

    public void addSupplier() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Supplier ID: ");
            String supplierId = scanner.nextLine();
            System.out.print("Enter Supplier Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Contact Information (Phone or Email): ");
            String contactInfo = scanner.nextLine();

            Supplier supplier = new Supplier(supplierId, name, contactInfo);
            inventoryService.addSupplier(supplier);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateSupplier() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Supplier ID to update: ");
            String supplierId = scanner.nextLine();
            System.out.print("Enter New Supplier Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Contact Information (Phone or Email): ");
            String contactInfo = scanner.nextLine();

            Supplier updatedSupplier = new Supplier(supplierId, name, contactInfo);
            inventoryService.updateSupplier(supplierId, updatedSupplier);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteSupplier() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Supplier ID to delete: ");
            String supplierId = scanner.nextLine();
            inventoryService.deleteSupplier(supplierId);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewSupplier() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Supplier ID to view: ");
            String supplierId = scanner.nextLine();
            inventoryService.viewSupplier(supplierId);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAllSuppliers() {
        inventoryService.viewAllSuppliers();
    }

    public void addStock() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID to add stock: ");
            String productId = scanner.nextLine();
            System.out.print("Enter Quantity to add: ");
            int quantity = scanner.nextInt();

            inventoryService.addStock(productId, quantity);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeStock() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID to remove stock: ");
            String productId = scanner.nextLine();
            System.out.print("Enter Quantity to remove: ");
            int quantity = scanner.nextInt();

            inventoryService.removeStock(productId, quantity);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewTransactionHistory() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID to view transaction history: ");
            String productId = scanner.nextLine();
            inventoryService.viewTransactionHistory(productId);
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void saveData() {
        inventoryService.saveData();
    }

    public void loadData() {
        inventoryService.loadData();
    }

    public void generateReport() {
        inventoryService.generateReport();
    }
}
