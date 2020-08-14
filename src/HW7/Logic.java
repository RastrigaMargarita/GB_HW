package HW7;

import java.util.Random;

public class Logic {

    public static int SIZE;
    public static int DOTS_TO_WIN;
    public static final char DOT_EMPTY = '∙';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;

    public static int status = 0;//0 - игра, 1 - победил человек, 2, победил ИИ, 3 - ничья

    public static Random rand = new Random();

    public static void go() {


        go1();
        if (status == 0) {
            aiTurn();
            //printMap();

            go2();
        }

    }

    public static void go1() {


        if (checkWin(DOT_X, DOTS_TO_WIN)) {
            status = 1;
            return;
        }

        if (isMapFull()) {
            status = 3;
            return;
        }


    }

    public static void go2() {

        if (checkWin(DOT_O, DOTS_TO_WIN)) {
            status = 2;
            return;
        }

        if (isMapFull()) {
            status = 3;
            return;
        }


    }

    public static boolean checkWin(char symb, int k) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, symb, k) ||
                        checkLine(i, j, 1, 0, symb, k) ||
                        checkLine(i, j, 1, 1, symb, k) ||
                        checkLine(i, j, -1, 1, symb, k)) {
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean checkLine(int i, int j, int movei, int movej, char symb, int checkedDots) {
        boolean returnValue = true;


        if (returnValue == true) {
            if ((i + (DOTS_TO_WIN - 1) * movei >= SIZE) || (j + (DOTS_TO_WIN - 1) * movej >= SIZE) || (i + (DOTS_TO_WIN - 1) * movei < 0) || (j + (DOTS_TO_WIN - 1) * movej < 0)) {
                returnValue = false;
            } else {
                for (int k = 0; k < checkedDots; k++) {
                    if (map[i + k * movei][j + k * movej] != symb) {
                        returnValue = false;
                        break;
                    }
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

        //Компьютер пытается думать на два шага вперед

        for (int i = DOTS_TO_WIN; i > Math.max(DOTS_TO_WIN - 2, 2); i--) {


            // Компьютер пытается выиграть
            for (int x = 0; x < SIZE; x++) {
                if (isTurned) {
                    break;
                }
                for (int y = 0; y < SIZE; y++) {
                    if (map[x][y] == DOT_EMPTY) {
                        map[x][y] = DOT_O;
                        if (checkWin(DOT_O, i)) {

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
                            if (checkWin(DOT_X, i)) {
                                map[x][y] = DOT_O;

                                isTurned = true;
                                break;
                            } else {
                                map[x][y] = DOT_EMPTY;
                            }
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

        }
    }

    public static void humanTurn(int x, int y) {

        if (!isCellValid(x, y)) ;
        {
            map[y][x] = DOT_X;
        }
    }

    public static void human2Turn(int x, int y) {

        if (!isCellValid(x, y)) ;
        {
            map[y][x] = DOT_O;
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        status = 0;
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
