package main;

import entities.Hero;
import services.GameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Hero hero = Hero.getHeroEntity();
        GameController game = GameController.getGameController();
        hero.setHeroName(reader);
        game.mainMenuGame(reader);
        reader.close();

    }
}
