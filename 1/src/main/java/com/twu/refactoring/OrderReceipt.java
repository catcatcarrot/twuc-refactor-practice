package com.twu.refactoring;

public class OrderReceipt {
    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		return "======Printing Orders======\n" +
				order.getCustomerName() +
				order.getCustomerAddress() +
				order.getAllLineItemInfo() +
				"Sales Tax" + '\t' + order.getTotalTax() +
				"Total Amount" + '\t' + order.getTotal();
	}

}