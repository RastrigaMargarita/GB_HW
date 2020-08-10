package HW6;

public class Cat {
    private String name;
    private int appetite;
    private boolean fed;

    public boolean isFed() {
        return fed;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fed = false;
    }

    public void eat(Plate p) {

        if (p.decreaseFood(appetite * (fed ? 0 : 1))) {
            fed = true;
        }
        this.info();
    }

    public void info() {
        if (this.isFed()) {
            System.out.printf("%s съел %d корма и теперь сыт\n",name, appetite);
        } else {
            System.out.printf("%s голоден на %d\n", name, appetite);
        }

    }
}
