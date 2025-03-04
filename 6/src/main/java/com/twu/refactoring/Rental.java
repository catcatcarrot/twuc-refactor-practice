package com.twu.refactoring;

public class Rental {

    private final Movie movie;

    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getAmount() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILD:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public String getFigures() {
        return "\t" + movie.getTitle() + "\t" + getAmount() + "\n";
    }

    public boolean isNewReleaseMovieAndRentedDaysMoreThan1() {
        return (movie.getPriceCode() == Movie.NEW_RELEASE)
                && daysRented > 1;
    }
}