package HW5.animals;

public abstract class Animal {

    String name;
    int maxDistRun;
    int maxDistSwim;
    public static int count = 0;

    public Animal(String name) {
        this.name = name;
        count = count + 1;
    }

    public void run(int dist) {
        if (dist <= maxDistRun) {
            System.out.printf("%s пробежал %d м.\n", name, dist);
        } else {
            System.out.printf("%s не может пробежать %d м.\n", name, dist);
        }
    }

    ;

    public void swim(int dist) {

        if (dist <= maxDistSwim) {
            System.out.printf("%s проплыл %d м.\n", name, dist);
        } else {
            System.out.printf("%s не может проплыть %d м.\n", name, dist);
        }
    }

    ;
}
