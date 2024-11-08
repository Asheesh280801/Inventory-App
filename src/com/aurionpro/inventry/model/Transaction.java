package com.aurionpro.inventry.model;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private String productId;
    private String type; // "add" or "remove"
    private int quantity;
    private Date date;

    public Transaction(String transactionId, String productId, String type, int quantity) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.date = new Date();
    }

    // Getters and Setters for Transaction properties
   
    
    
   
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	 @Override
	    public String toString() {
	        return String.format("Transaction[ID=%s, ProductID=%s, Type=%s, Quantity=%d, Date=%s]", 
	                             transactionId, productId, type, quantity, date);
	    }

}
