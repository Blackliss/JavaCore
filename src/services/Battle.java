package services;

import entities.Character;
import entities.Goblin;
import entities.Hero;
import entities.Skeleton;
import java.util.Random;


public class Battle {

    /*
    вначале битвы проверяем жив ли герой? атакует: сообщение что герой мертв и в классе Игра будет окончания работы программы
    далее проверяем жив ли монстр? атакует в ответ: герой получает золото
    */
    public void battle(Character hero, Character monster) {
        if (!hero.isDead()) {
            System.out.println(hero.getName() + " атакует:");
            hero.attack(monster);
            if (!monster.isDead()) {
                System.out.println(monster.getName() + " атакует:");
                monster.attack(hero);
                battle(hero, monster);
            } else {
                System.out.println(monster.getName() + " мертв!");
                hero.setGold(hero.getGold() + monster.getGold());
                hero.setExperience(hero.getExperience() + monster.getExperience());
                System.out.println(hero);
            }
        } else {
            System.out.println(hero.getName() + " мертв!");
        }
    }

    //запуск боя. Выведено в класс Бой, чтобы не перегружать класс Игра
    public void startBattle(Hero hero){
        Battle battle = new Battle();
        battle.battle(hero, getMonster());
    }

    //метод выбора противника
    public Character getMonster (){
        int randomNumber = new Random().nextInt(3);
        if(randomNumber == 2){
            System.out.println("Противник Скелет!");
            return new Skeleton();
        } else {
            System.out.println("Противник Гоблин!");
            return new Goblin();
        }
    }


}
