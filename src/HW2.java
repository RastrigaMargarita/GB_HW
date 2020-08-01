import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] intmas = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i : intmas) {
            i = (i == 0) ? 1 : 0;
            System.out.print(i);
        }

        System.out.println("\n");

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] intmas2 = new int[8];
        for (int i = 0; i < intmas2.length; i++) {
            intmas2[i] = i * 3;
            System.out.print(intmas2[i] + " ");
        }

        System.out.println("\n");

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] intmas3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i :
                intmas3) {
            if (i < 6) {
                i *= 2;
            }
            System.out.print(i + " ");

        }

        System.out.println("\n");

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int sizeMas = 8;
        int[][] intmas4 = new int[sizeMas][sizeMas];
        for (int i = 0; i < sizeMas - 1; i++) {
            for (int j = 0; j < sizeMas - 1; j++) {
                if ((i == j) || (i + j == (sizeMas - 2))) {
                    intmas4[i][j] = 1;
                }
                System.out.print(intmas4[i][j]);
            }
            System.out.println("");
        }

        System.out.println("");

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] intmas5 = new int[]{5, 4, 8, 10, 45651, 5, 7, -2, 0};
        int maxvalue = intmas5[0];
        int minvalue = intmas5[0];

        for (int i : intmas5
        ) {
            maxvalue = (i > maxvalue) ? i : maxvalue;
            minvalue = (i > minvalue) ? minvalue : i;

        }
        System.out.println(minvalue + " " + maxvalue);

        System.out.println("");
        System.out.println(checkBalance(new int[]{0, 2, 5, 10, 17}));

        System.out.println("");
        moveValues(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -9);
        moveValues(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 9);

    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance(int[] intmas6) {
        int sum = 0;
        for (int i = 0; i < intmas6.length; i++) {
            sum += intmas6[i];
        }
        int sumleft = 0;
        for (int i = 0; i < intmas6.length; i++) {
            sumleft += intmas6[i];
            if ((sumleft) == (sum - sumleft)) {
                System.out.println(sumleft);

                return true;
            }
        }
        return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.

    public static void moveValues(int[] intmas7, int n) {
        System.out.println(Arrays.toString(intmas7));
        int jumpValue;

        n = (n>0)?intmas7.length-n:-n;
        for (int i = 0; i < n; i++) {
                jumpValue = intmas7[0];
                for (int j = 0; j < (intmas7.length - 1); j++) {
                    intmas7[j] = intmas7[j + 1];
                }
                intmas7[intmas7.length - 1] = jumpValue;
            }
        System.out.println(Arrays.toString(intmas7));

    }

}
