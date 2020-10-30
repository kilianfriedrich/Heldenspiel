package de.friedrichk.game;

import de.friedrichk.creature.Hero;
import de.friedrichk.creature.Monster;
import de.friedrichk.util.Dice;

public class Fight {

    Fight() {



    }

    public void startFight(Hero hero, Monster monster) {

        Dice dice10 = new Dice(10), dice6 = new Dice();

        do {

            int heroResult, monsterResult;

            if(hero.getAttackValue() > monster.getAttackValue()) {

                heroResult = dice10.roll();
                monsterResult = dice6.roll();

            } else {

                heroResult = dice6.roll();
                monsterResult= dice10.roll();

            }

            if(heroResult > monsterResult) {

                monster.reduceHealthBy((int)(Math.sqrt(hero.getAttackValue())));

            } else {

                hero.reduceHealthBy((int)(Math.sqrt(monster.getAttackValue())));

            }

            System.out.println(hero.getName() + " has " + hero.getHealth() + " health left.");

        } while(!monster.isDead() && !hero.isDead() && Game.yesNoDialog("Continue with fight?"));

    }

}