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
        StringBuilder result = new StringBuilder(getRentalRecordHeader());

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

        result.append(getTotalAmountInfo(totalAmount));
        result.append(getFrequentRenterPointsInfo(frequentRenterPoints));
        return result.toString();
    }

    private String getFrequentRenterPointsInfo(int frequentRenterPoints) {
        return "You earned " + frequentRenterPoints + " frequent renter points";
    }

    private String getTotalAmountInfo(double totalAmount) {
        return "Amount owed is " + totalAmount + "\n";
    }

    private String getRentalRecordHeader() {
        return "Rental Record for " + name + "\n";
    }

}
