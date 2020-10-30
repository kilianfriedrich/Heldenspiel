package de.friedrichk.creature;

public abstract class Creature {

    Creature(int maxPossibleStrength, int maxPossibleHealth) {

        this(1, maxPossibleStrength, 1, maxPossibleHealth);

    }
    
    Creature(int minPossibleStrength, int maxPossibleStrength, int minPossibleHealth, int maxPossibleHealth) {
        
        this.strength = (int)(Math.random() * (maxPossibleStrength - minPossibleStrength)) + minPossibleStrength;
        this.health = (int)(Math.random() * (maxPossibleHealth - minPossibleHealth)) + minPossibleHealth;

        setAttackValue(calcAttackValue());
        
    }

    private int attackValue, strength, health;

    protected int calcAttackValue() {

        return strength;

    }

    void setAttackValue(int attackValue) {

        this.attackValue = attackValue;

    }

    public int getAttackValue() {

        return attackValue;

    }

    int getStrength() {

        return strength;

    }

    public void reduceHealthBy(int amount) {

        if(amount > health) amount = health;

        health -= amount;

    }

    public boolean isDead() {

        return health <= 0;

    }

    protected void setHealth(int health) {

        this.health = health;

    }

    public int getHealth() {

        return health;

    }
}
