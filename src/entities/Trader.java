package entities;

public class Trader {
    private static Trader traderEntity = new Trader();
    private int countHealingPotions;

    private Trader() {
        this.countHealingPotions = 3;
    }

    public static Trader getTraderEntity() {
        if (traderEntity == null) {
            traderEntity = new Trader();
        }
        return traderEntity;
    }

    public void buyHealingPotion() {
        if (Hero.getHeroEntity().getGold() >= 100 && countHealingPotions > 0) {
            Hero.getHeroEntity().setGold(Hero.getHeroEntity().getGold() - 100);
            Hero.getHeroEntity().setHp(Hero.getHeroEntity().getHp() + 100);
            countHealingPotions = --countHealingPotions;
            System.out.println("Герой купил зелье и выпил его.");
        } else if (countHealingPotions <= 0) {
            System.out.println("У торговца закончились зелья!");
        } else {
            System.out.println("Не хватает золота для покупки зелья!");
        }
    }

}
