package entities;

import java.util.Objects;
import java.util.Random;

public abstract class Character {
    private String name;
    private int hp;
    private int gold;
    private int dexterity;
    private int experience;
    private int strength;

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getGold() {
        return gold;
    }

    public int getExperience() {
        return experience;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    //общий для всех метод атаки. Включает в себя проверку по ловкости: персонаж попал/или промахнулся и критический удар
    public void attack(Character character) {
        if (isLucky()) {
            if (isCritical()) {
                System.out.println("Критический удар!!!");
                character.setHp(character.getHp() - (this.getStrength() * 2));
            } else {
                System.out.println("Удар!!!");
                character.setHp(character.getHp() - this.getStrength());
            }
        } else {
            System.out.println(this.getName() + " промахнулся!");
        }
    }

    public boolean isLucky() {
        int randomNumber = new Random().nextInt(100);
        if ((dexterity * 3) > randomNumber) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCritical() {
        int randomNumber = new Random().nextInt(100);
        if ((strength + dexterity) == randomNumber/2 || (strength + dexterity) == randomNumber) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDead() {
        if (this.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

}
