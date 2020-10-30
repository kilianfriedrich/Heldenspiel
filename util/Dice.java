package de.friedrichk.util;

public class Dice {

    public Dice(int diceSides) {

        this.diceSides = diceSides;

    }

    public Dice() {

        this(6);

    }

    private int diceSides;

    public int roll() {

        return (int)(Math.random() * diceSides + 1);

    }

}