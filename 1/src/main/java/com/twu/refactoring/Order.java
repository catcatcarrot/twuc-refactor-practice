package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<LineItem> lineItems;

    public Order(String name, String address, List<LineItem> lineItems) {
        this.name = name;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalTax() {
        double totSalesTx = 0d;
        for (LineItem lineItem : getLineItems()) {
            // calculate sales tax @ rate of 10%
            totSalesTx += lineItem.totalAmount() * .10;
        }
        return totSalesTx;
    }

    public double getTotal() {
        double tot = 0d;
        for (LineItem lineItem : getLineItems()) {
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + lineItem.totalAmount() * .10;
        }
        return tot;
    }
}
