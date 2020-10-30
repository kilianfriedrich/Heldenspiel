package de.friedrichk.object;

public class Weapon {

    public Weapon() {

        this.magic = (int)(Math.random() * 10);

        if(Math.random() * 3 > 1) this.material = "wood";
        else if(Math.random() * 3 > 1) this.material = "stone";
        else if(Math.random() * 3 > 1) this.material = "iron";
        else if(Math.random() * 3 > 1) this.material = "gold";
        else if(Math.random() * 3 > 1) this.material = "diamond";

        this.bonus = calcBonus();

    }

    private String material;
    private int bonus, magic;

    private int calcBonus() {

        return magic + calcMaterialBonus();

    }

    private int calcMaterialBonus() {

        if(material.equals("wood")) return 1;
        if(material.equals("stone")) return 2;
        if(material.equals("iron")) return 3;
        if(material.equals("gold")) return 4;
        if(material.equals("diamond")) return 5;

        return 0;

    }

    public int getBonus() {

        return bonus;

    }

    public String getMaterial() {

        return material;

    }

    public int getMagic() {

        return magic;

    }
}