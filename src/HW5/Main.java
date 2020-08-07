package HW5;

import HW5.animals.Animal;
import HW5.animals.Cat;
import HW5.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Dog Bobik = new Dog("Бобик");
        Bobik.run(600);
        Bobik.run(400);
        Bobik.swim(15);
        Bobik.swim(5);
        Cat Pushok = new Cat("Пушок");
        Pushok.run(300);
        Pushok.run(100);
        Pushok.swim(5);
        Cat Rizik = new Cat("Рыжик");
        Rizik.run(250);
        Rizik.run(150);
        Rizik.swim(0);
        System.out.printf("Создано %d животных", Animal.count);

    }
}
