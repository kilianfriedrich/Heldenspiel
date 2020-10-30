package de.friedrichk.game;

import de.friedrichk.creature.Hero;
import de.friedrichk.creature.Monster;
import de.friedrichk.creature.customheroes.Warrior;
import de.friedrichk.creature.customheroes.Wizard;
import de.friedrichk.object.Weapon;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {

        new Game();

    }

    private Game() {

        do {

            createPlayer();

        } while(yesNoDialog("Create another player?"));
        
        play();

    }

    private static Scanner inputScanner = new Scanner(System.in);

    static boolean yesNoDialog(String message) {

        return xOrYDialog(message, "Y", "N") == 0;

    }

    static private int xOrYDialog(String message, String opt1, String opt2) {

        String answer;

        do {

            answer = getUserInput(message + " (" + opt1 + "/" + opt2 + ")");

        } while (!answer.equalsIgnoreCase(opt1) && !answer.equalsIgnoreCase(opt2));

        return answer.equalsIgnoreCase(opt1) ? 0 : 1;

    }

    static private String getUserInput(String message) {

        System.out.print(message + " ");
        return inputScanner.nextLine();

    }

    private ArrayList<Hero> heroes = new ArrayList<Hero>();

    private void createPlayer() {

        String name = getUserInput("Name the player:");

        int type = xOrYDialog("Which type of player should " + name + " be?", "wizard", "warrior");

        if(type == 0) heroes.add(new Wizard(name));
        if(type == 1) heroes.add(new Warrior(name));

        heroes.get(heroes.size() - 1).printSummary();
    }

    private void play() {

        while(true) {

            System.out.println("--------------------");

            Hero curHero = heroes.get((int)(Math.random() * heroes.size()));
            int action = (int)(Math.random() * 3);

            if(action <= 1) {

                System.out.println(curHero.getName() + " found an enemy!");
                curHero.attack(new Monster(), new Fight());
                if(curHero.isDead()) heroes.remove(curHero);
                if(heroes.size() == 0) break;

            } else if(action == 2) {

                if(!yesNoDialog(curHero.getName() + " found a weapon! Collect?")) continue;

                curHero.setWeapon(new Weapon());

                curHero.printWeaponSummary();

            }

            if(curHero.isWizard() && !curHero.isDead() && yesNoDialog("Heilen?")) {
                
                ((Wizard)curHero).heilen();
                System.out.println(curHero.getName() + " has now " + curHero.getHealth() + " health.");
            }

        }

        System.out.println("Game over...");

    }

}