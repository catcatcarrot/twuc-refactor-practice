package com.twu.refactoring;

import java.util.Arrays;
import java.util.function.IntPredicate;

//TODO: this is awesome
public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return getCount(x -> x % 2 == 0);
    }

    public int countOdd() {
        return getCount(x -> x % 2 == 1);
    }

    public int countPositive() {
        return getCount(x -> x >= 0);
    }

    public int countNegative() {
        return getCount(x -> x < 0);
    }

    private int getCount(IntPredicate numberType) {
        return (int) Arrays.stream(numbers).filter(numberType).count();
    }
}
