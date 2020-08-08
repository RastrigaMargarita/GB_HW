package HW6;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        } else {
            return false;
        }
    }

    public void info() {

        System.out.println("В тарелке сейчас: " + food);
    }

    public void increaseFood(int n) {
        this.food = this.food + n;
    }
}
