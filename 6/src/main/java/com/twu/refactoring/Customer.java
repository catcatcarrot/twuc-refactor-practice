package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private String name;
    private ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalList.add(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = rentalList.iterator();
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

        while (rentals.hasNext()) {
            Rental each = rentals.next();
            frequentRenterPoints++;

            if (each.isNewReleaseMovieAndRentedDaysMoreThan1())
                frequentRenterPoints++;

            result.append(each.getFigures());
            totalAmount += each.getAmount();
        }

        result.append("Amount owed is " + totalAmount + "\n");
        result.append("You earned " + frequentRenterPoints + " frequent renter points");
        return result.toString();
    }

}
