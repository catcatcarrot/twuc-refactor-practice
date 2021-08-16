package com.twu.refactoring;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        return getDirection('E', 'W');
    }

    public Direction turnLeft() {
        return getDirection('W', 'E');
    }

    private Direction getDirection(char toN, char toS) {
        //TODO: SOLUTION1: extract NSEW to Enum
        //TODO: SOLUTION2: extract NSEW to different sub-class and inherit from parent class
        switch (direction) {
            case 'N':
                return new Direction(toN);
            case 'S':
                return new Direction(toS);
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
