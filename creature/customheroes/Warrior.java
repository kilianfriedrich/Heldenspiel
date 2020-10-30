package de.friedrichk.creature.customheroes;

import de.friedrichk.creature.Hero;

public class Warrior extends Hero {

    public Warrior(String name) {

        super(name);
        this.endurance = (int)(Math.random() * 100 + 1);

    }

    private int endurance;

    @Override
    protected int calcAttackValue() {

        return super.calcAttackValue() + endurance;

    }

    @Override
    protected void printSpecialSummary() {

        System.out.println("His/Her endurance level is " + endurance + ".");

    }

    @Override
    public boolean isWizard() { return false; }

}