package HW5.animals;

import HW5.animals.Animal;

public class Cat extends Animal {
    {
        maxDistRun = 200;
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void swim(int dist) {//можно это условие написать в классе Animal, но хочу переопределить метод
        System.out.printf("%s не умеет плавать!\n", name);
    }
}
