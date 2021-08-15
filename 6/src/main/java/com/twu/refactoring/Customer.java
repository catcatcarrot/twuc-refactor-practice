package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private final String name;
    private final ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalList.add(arg);
    }

    public String statement() {
        Iterator<Rental> rentals = rentalList.iterator();
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        while (rentals.hasNext()) {
            Rental each = rentals.next();
            frequentRenterPoints++;

            if (each.isNewReleaseMovieAndRentedDaysMoreThan1())
                frequentRenterPoints++;

            result.append(each.getFigures());
            totalAmount += each.getAmount();
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
