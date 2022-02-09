package entities;

import java.io.BufferedReader;
import java.io.IOException;


public class Hero extends Character {
    private static Hero heroEntity = new Hero();

    private Hero() {
        this.setHp(150);
        this.setDexterity(25);
        this.setStrength(30);
        this.setGold(0);
        this.setExperience(0);
    }

    public static Hero getHeroEntity() {
        if (heroEntity == null) {
            heroEntity = new Hero();
        }
        return heroEntity;
    }

    //сетим имя персонажа с введенных даных с консоли
    public void setHeroName(BufferedReader reader) throws IOException {
        System.out.println("Введите имя героя");
        String name = reader.readLine();
        heroEntity.setName(name);
    }

    @Override
    public String toString() {
        return "Имя героя: " + heroEntity.getName() + "; " +
                "Здоровье героя: " + heroEntity.getHp() + "; " +
                "Золото героя: " + heroEntity.getGold() + "; " +
                "Опыт героя: " + heroEntity.getExperience();
    }
}
