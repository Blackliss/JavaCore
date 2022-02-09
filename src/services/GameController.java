package services;

import entities.Hero;
import entities.Trader;

import java.io.BufferedReader;
import java.io.IOException;


public class GameController {
    private static GameController gameControllerEntity = new GameController();


    private GameController() {
    }

    public static GameController getGameController() {
        if (gameControllerEntity == null) {
            gameControllerEntity = new GameController();
        }
        return gameControllerEntity;
    }
/*
в данном классе метод выводящий главное меню игры и контролирующий игровой процесс
 */

    public void mainMenuGame(BufferedReader reader) throws IOException {
        System.out.println("Куда Вы хотите пойти? Введите числовое значение от 1 до 3.");
        System.out.println("1.К торговцу");
        System.out.println("2.В темный лес");
        System.out.println("3.На выход");
        String answer = reader.readLine();
        switch (answer) {
            case "1":
                System.out.println("Приветствую тебя: " + Hero.getHeroEntity().getName() + "!");
                Trader.getTraderEntity().buyHealingPotion();
                System.out.println(Hero.getHeroEntity());
                mainMenuGame(reader);
                break;
            case "2":
                System.out.println("Да начнется битва!!!");
                Battle battle = new Battle();
                battle.startBattle(Hero.getHeroEntity());
                if (!Hero.getHeroEntity().isDead()) {
                    mainMenuGame(reader);
                }
                break;
            case "3":
                System.out.println("Game over");
                break;
            default:
                System.out.println("Некорретное значение. Введите номер пункта меню.");
                mainMenuGame(reader);
                break;
        }
    }


}
