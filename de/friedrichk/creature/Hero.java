package de.friedrichk.creature;

import de.friedrichk.game.Fight;
import de.friedrichk.object.Weapon;

public abstract class Hero extends Creature {

    public Hero(String name) {

        super(1, 100, 10, 50);

        this.name = name;

    }


    private String name;
    private Weapon weapon;

    public void attack(Monster monster, Fight fight) {

        fight.startFight(this, monster);

    }

    protected int calcAttackValue() {

        int attackValue = super.calcAttackValue();

        if(weapon != null) attackValue += weapon.getBonus();

        return attackValue;

    }

    public void setWeapon(Weapon weapon) {

        this.weapon = weapon;
        setAttackValue(calcAttackValue());

    }

    public void printWeaponSummary() {

        if(weapon != null) System.out.println(name + "'s weapon is made of " + weapon.getMaterial() + " and has a magic level of " + weapon.getMagic() + "!");
        else System.out.println(name + " doesn't have a weapon.");

    }

    public void printSummary() {

        System.out.println(name + " has a health of " + getHealth() + " and a strengh of " + getStrength() + ".");
        printSpecialSummary();
        printWeaponSummary();

    }

    public abstract boolean isWizard();

    protected abstract void printSpecialSummary();

    public String getName() {

        return name;

    }

}