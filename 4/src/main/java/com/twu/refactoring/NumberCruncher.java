package com.twu.refactoring;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        IntPredicate numberType = x -> x % 2 == 0;
        return getCount(numberType);
    }

    public int countOdd() {
        IntPredicate numberType = x -> x % 2 == 1;
        return getCount(numberType);
    }

    public int countPositive() {
        IntPredicate numberType = x -> x >= 0;
        return getCount(numberType);
    }

    public int countNegative() {
        IntPredicate numberType = x -> x < 0;
        return getCount(numberType);
    }

    private int getCount(IntPredicate numberType) {
        return (int) Arrays.stream(numbers).filter(numberType).count();
    }
}
