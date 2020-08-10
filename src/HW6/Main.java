package HW6;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static ArrayList<Cat> arrayCats = new ArrayList<>();
    static Plate plate;
    static final int foodPack = 200;
    static final int theMostHungryCat = 50;

    public static void main(String[] args) {

        int CountCats = 18;
        Random rnd = new Random();

        //Зовем всех уличных котов
        for (int i = 0; i < CountCats; i++) {
            arrayCats.add(new Cat("Кот" + (i + 1), rnd.nextInt(theMostHungryCat)+5));
        }

        //Ставим пустую тарелку
        plate = new Plate(0);

        //Будем докладывать пакетики еды в тарелку пока не накормим всех котов!
        do {
            plate.increaseFood(foodPack);
            plate.info();
            feedCats();
            plate.info();
            System.out.println("\n----------------- ");

        } while (!isAllCatsFed());
    }

    private static boolean isAllCatsFed() {
        boolean returningValue = true;
        for (Cat c : arrayCats) {
            if (!c.isFed()) {
                returningValue = false;
            }
        }
        return returningValue;
    }

    private static void feedCats() {
        for (Cat c : arrayCats) {
            if (!c.isFed()) {
                c.eat(plate);
            }
        }
    }
}
