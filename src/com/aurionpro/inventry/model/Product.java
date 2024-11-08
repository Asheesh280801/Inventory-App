package com.aurionpro.inventry.model;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Product implements Serializable
{
	private static AtomicInteger productIdCounter = new AtomicInteger(0);
	private String productId;
	private String productName;
	private String productDescription;
	private double productPrice;
	private int  productQuantity;
	private String supplier_id;


	public Product(String productId, String productName, String productDescription, double productPrice, int productQuantity,
			String supplier_id) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.supplier_id = supplier_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int  getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return String.format("%-10s %-20s %-30s %-10.2f %-10d%n", productId, productName, 
				productDescription, productPrice, productQuantity);

	}
}