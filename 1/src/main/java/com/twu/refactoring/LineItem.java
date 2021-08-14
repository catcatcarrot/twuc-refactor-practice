package com.twu.refactoring;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	double totalAmount() {
        return price * quantity;
    }

	public String getLineItemInfo() {
		return description + '\t' + price + '\t' + quantity + '\t' + totalAmount() + '\n';
	}
}