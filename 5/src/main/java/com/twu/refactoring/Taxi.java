package com.twu.refactoring;

public class Taxi {
    private final boolean airConditioned;
    private final int totalKms;
    private final boolean peakTime;

    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;

    public Taxi(boolean airConditioned, int totalKms, boolean peakTime) {
        this.airConditioned = airConditioned;
        this.totalKms = totalKms;
        this.peakTime = peakTime;
    }

    //TODO: inline variables and make this look easier

    // public double getTaxiCharge() {
    //     double totalTaxiCharge = 0;
    //     return airConditioned ? getChargeByAirConditioned(totalTaxiCharge, PRE_RATE_CHANGE_AC_RATE, POST_RATE_CHANGE_AC_RATE)
    //             : getChargeByAirConditioned(totalTaxiCharge, PRE_RATE_CHANGE_NON_AC_RATE, POST_RATE_CHANGE_NON_AC_RATE);
    // }
    public double getTaxiCharge() {
        double totalTaxiCharge = 0;
        if (airConditioned) {
            totalTaxiCharge = getChargeByAirConditioned(totalTaxiCharge, PRE_RATE_CHANGE_AC_RATE, POST_RATE_CHANGE_AC_RATE);
        } else {
            totalTaxiCharge = getChargeByAirConditioned(totalTaxiCharge, PRE_RATE_CHANGE_NON_AC_RATE, POST_RATE_CHANGE_NON_AC_RATE);
        }
        return totalTaxiCharge;
    }

    private double getChargeByAirConditioned(double totalTaxiCharge, int preRateChangeAcRate, int postRateChangeAcRate) {
        // TODO: can extract to different methods to calculate different kinds of fees
        int totalKms = this.totalKms;
        double peakTimeMultiple = peakTime ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
        totalTaxiCharge += Math.min(RATE_CHANGE_DISTANCE, totalKms) * preRateChangeAcRate * peakTimeMultiple;
        totalTaxiCharge += Math.max(0, totalKms - RATE_CHANGE_DISTANCE) * postRateChangeAcRate * peakTimeMultiple;
        return totalTaxiCharge;
    }
}
