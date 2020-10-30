package de.friedrichk.creature.customheroes;

import de.friedrichk.creature.Hero;

public class Wizard extends Hero {

    public Wizard(String name) {

        super(name);
        maxHealth = getHealth();
        this.magicPower = (int)(Math.random() * 100 + 1);

    }

    private int magicPower, maxHealth;

    public void heilen() {

        setHealth(getHealth() + (int)(Math.sqrt(magicPower)));
        if(getHealth() > maxHealth) setHealth(maxHealth);

    }

    @Override
    protected void printSpecialSummary() {

        System.out.println("His/Her magic power is " + magicPower + ".");

    }

    @Override
    public boolean isWizard() { return true; }

}