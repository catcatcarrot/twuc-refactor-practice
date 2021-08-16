package com.twu.refactoring;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final String name;
    private final String address;
    private final List<LineItem> lineItems;

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

    public double getTotalTax() {
        return lineItems
                .stream()
                .mapToDouble(lineItem -> lineItem.totalAmount() * .10) //TODO: 0.10 extract to constant
                .sum();
    }

    public double getTotal() {
        return lineItems
                .stream()
                .mapToDouble(lineItem -> lineItem.totalAmount() + lineItem.totalAmount() * .10) //TODO: 0.10 extract to constant
                .sum();
    }

    public String getAllLineItemInfo() {
        return lineItems
                .stream()
                .map(LineItem::getLineItemInfo)
                .collect(Collectors.joining());
    }
}
