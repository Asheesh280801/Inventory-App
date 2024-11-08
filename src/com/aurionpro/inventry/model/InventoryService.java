package com.aurionpro.inventry.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import com.aurionpro.inventry.exception.InventoryException;

public class InventoryService {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Supplier> suppliers = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    // Product CRUD Operations
    public void addProduct(Product product) throws InventoryException {
        if (products.containsKey(product.getProductId())) {
            throw new InventoryException("Product with the same ID already exists.");
        }
        if (!suppliers.containsKey(product.getSupplier_id())) {
            throw new InventoryException("Supplier not found. Please add the supplier first.");
        }
        products.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    public void updateProduct(String productId, Product updatedProduct) throws InventoryException {
        if (!products.containsKey(productId)) {
            throw new InventoryException("Product not found.");
        }
        products.put(productId, updatedProduct);
        System.out.println("Product updated successfully.");
    }

    public void deleteProduct(String productId) throws InventoryException {
        if (!products.containsKey(productId)) {
            throw new InventoryException("Product not found.");
        }
        products.remove(productId);
        System.out.println("Product deleted successfully.");
    }

    public void viewProduct(String productId) throws InventoryException {
        Product product = products.get(productId);
        if (product == null) {
            throw new InventoryException("Product not found.");
        }
        System.out.println(product);
    }

    public void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            products.values().forEach(System.out::println);
        }
    }

    // Supplier CRUD Operations
    public void addSupplier(Supplier supplier) throws InventoryException {
        if (suppliers.containsKey(supplier.getSupplierId())) {
            throw new InventoryException("Supplier with the same ID already exists.");
        }
        suppliers.put(supplier.getSupplierId(), supplier);
        System.out.println("Supplier added successfully.");
    }

    public void updateSupplier(String supplierId, Supplier updatedSupplier) throws InventoryException {
        if (!suppliers.containsKey(supplierId)) {
            throw new InventoryException("Supplier not found.");
        }
        suppliers.put(supplierId, updatedSupplier);
        System.out.println("Supplier updated successfully.");
    }

    public void deleteSupplier(String supplierId) throws InventoryException {
        if (!suppliers.containsKey(supplierId)) {
            throw new InventoryException("Supplier not found.");
        }
        suppliers.remove(supplierId);
        System.out.println("Supplier deleted successfully.");
    }

    public void viewSupplier(String supplierId) throws InventoryException {
        Supplier supplier = suppliers.get(supplierId);
        if (supplier == null) {
            throw new InventoryException("Supplier not found.");
        }
        System.out.println(supplier);
    }

    public void viewAllSuppliers() {
        if (suppliers.isEmpty()) {
            System.out.println("No suppliers available.");
        } else {
            suppliers.values().forEach(System.out::println);
        }
    }

    // Transaction Management
    public void addStock(String productId, int quantity) throws InventoryException {
        Product product = products.get(productId);
        if (product == null) {
            throw new InventoryException("Product not found.");
        }
        product.setProductQuantity(product.getProductQuantity() + quantity);
        transactions.add(new Transaction(UUID.randomUUID().toString(), productId, "add", quantity));
        System.out.println("Stock added successfully.");
    }

    public void removeStock(String productId, int quantity) throws InventoryException {
        Product product = products.get(productId);
        if (product == null) {
            throw new InventoryException("Product not found.");
        }
        if (product.getProductQuantity() < quantity) {
            throw new InventoryException("Insufficient stock.");
        }
        product.setProductQuantity(product.getProductQuantity() - quantity);
        transactions.add(new Transaction(UUID.randomUUID().toString(), productId, "remove", quantity));
        System.out.println("Stock removed successfully.");
    }

    public void viewTransactionHistory(String productId) throws InventoryException {
        if (!products.containsKey(productId)) {
            throw new InventoryException("Product not found.");
        }
        transactions.stream()
                .filter(t -> t.getProductId().equals(productId))
                .forEach(System.out::println);
    }

    // Report generation
    public void generateReport() {
        System.out.println("Inventory Report:");
        products.values().forEach(System.out::println);
        transactions.forEach(System.out::println);
    }

    public void saveData() {
        try (ObjectOutputStream productStream = new ObjectOutputStream(new FileOutputStream("products.dat"));
             ObjectOutputStream supplierStream = new ObjectOutputStream(new FileOutputStream("suppliers.dat"));
             ObjectOutputStream transactionStream = new ObjectOutputStream(new FileOutputStream("transactions.dat"))) {
            productStream.writeObject(products);
            supplierStream.writeObject(suppliers);
            transactionStream.writeObject(transactions);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadData() {
        try (ObjectInputStream productStream = new ObjectInputStream(new FileInputStream("products.dat"));
             ObjectInputStream supplierStream = new ObjectInputStream(new FileInputStream("suppliers.dat"));
             ObjectInputStream transactionStream = new ObjectInputStream(new FileInputStream("transactions.dat"))) {
            products = (Map<String, Product>) productStream.readObject();
            suppliers = (Map<String, Supplier>) supplierStream.readObject();
            transactions = (List<Transaction>) transactionStream.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
	
		
	}


