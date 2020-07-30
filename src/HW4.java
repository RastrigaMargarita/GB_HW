import java.util.Random;
import java.util.Scanner;

public class HW4 {

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '∙';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, symb) ||
                    checkLine(i, j, 1, 0, symb) ||
                    checkLine(i, j, 1, 1, symb) ||
                    checkLine(i, j, -1, 1, symb)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean checkLine(int i, int j, int movei, int movej, char symb) {
        boolean returnValue = true;
        if ((i + (DOTS_TO_WIN - 1) * movei >= SIZE) || (j + (DOTS_TO_WIN - 1) * movej >= SIZE) || (i + (DOTS_TO_WIN - 1) * movei < 0) || (j + (DOTS_TO_WIN - 1) * movej < 0)) {
            returnValue = false;
        } else {
            for (int k = 0; k < DOTS_TO_WIN; k++) {
                if (map[i + k * movei][j + k * movej] != symb) {
                    returnValue = false;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;

    }

    public static void aiTurn() {
        boolean isTurned = false;

        // Компьютер пытается выиграть
        for (int x = 0; x < SIZE; x++) {
            if (isTurned) {
                break;
            }
            for (int y = 0; y < SIZE; y++) {
                if (map[x][y] == DOT_EMPTY) {
                    map[x][y] = DOT_O;
                    if (checkWin(DOT_O)) {
                        System.out.println("Компьютер походил в точку " + (y + 1) + " " + (x + 1));
                        isTurned = true;
                        break;
                    } else {
                        map[x][y] = DOT_EMPTY;
                    }
                }
            }
        }

        //Если не получилось, пытается помешать выиграть человеку
        if (!isTurned) {
            for (int x = 0; x < SIZE; x++) {
                if (isTurned) {
                    break;
                }
                for (int y = 0; y < SIZE; y++) {
                    if (map[x][y] == DOT_EMPTY) {
                        map[x][y] = DOT_X;
                        if (checkWin(DOT_X)) {
                            map[x][y] = DOT_O;
                            System.out.println("Компьютер походил в точку " + (y + 1) + " " + (x + 1));
                            isTurned = true;
                            break;
                        } else {
                            map[x][y] = DOT_EMPTY;
                        }
                    }
                }
            }
        }

        //Если не получилось - тыкает куда попало
        if (!isTurned) {
            int x, y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            map[x][y] = DOT_O;
            System.out.println("Компьютер походил в точку " + (y + 1) + " " + (x + 1));
            isTurned = true;
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
