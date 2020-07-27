import java.util.Random;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Играем в первую игру, угадываем число.
        guessValue(sc);

        //Играем в другую игру, угадываем слово!
        guessWord(sc);
        sc.close();
    }

    /**
     * Игра "угадай число"
     **/
    static void guessValue(Scanner sc) {

        Random r = new Random();
        int value = r.nextInt(10);
        int useranswer = 0;

        do {
            Boolean win = false;
            for (int i = 0; i < 3; i++) {
                System.out.println("Угадайте число");
                int uservalue = sc.nextInt();
                if (uservalue == value) {
                    win = true;
                    break;
                } else if (uservalue > value) {
                    System.out.println("Это число больше, чем надо");
                } else {
                    System.out.println("Это число меньше, чем надо");
                }
            }
            if (win) {
                System.out.println("Вы угадали!");
            } else {
                System.out.println("Вы проиграли!");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            useranswer = sc.nextInt();
        } while (useranswer == 1);

    }

    /**
     * Игра "угадай слово"
     **/
    public static void guessWord(Scanner sc) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random r = new Random();
        String value = words[r.nextInt(words.length)];

        Boolean win = false;
        do {
            System.out.println("\nУгадайте слово");
            String uservalue = sc.next();
            if (uservalue.equals(value)) {
                win = true;
                break;
            } else {
                for (int i = 0; i < Math.min(uservalue.length(), value.length()); i++) {
                    if (value.charAt(i) == uservalue.charAt(i)) {
                        System.out.print(value.charAt(i));
                    } else {
                        System.out.print("#");
                    }

                }
                for (int j = Math.min(uservalue.length(), value.length()); j < 15; j++) {
                    System.out.print("#");
                }
            }
        } while (win == false);
        System.out.println("Вы угадали слово " + value);

    }
}
