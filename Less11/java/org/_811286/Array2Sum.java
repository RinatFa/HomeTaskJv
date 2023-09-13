package org._811286;

public class Array2Sum {
    /**
     * Двумерный строковый массив размером 4х4
     */
    public static int dim = 4;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("  Обработка двух возможных исключений (1, 2):");
        String[][] arr1 = { { "1", "2", "3", "4", "5" },
                { "5", "6", "7", "8" },
                { "3", "4", "5", null },
                { "6", "7", "8", "9" } };
        String[][] arr2 = { { "1", "2", "3", "4" },
                { "5", "6", "7", "8" },
                { "3", "4", "5", null },
                { "6", "7", "8", "abcdefgh" } };
        String[][] arr3 = { { "1", "2", "3", "4" },
                { "5", "6", "7", "8" },
                { "3", "4", "5", null },
                { "6", "7", "8", "9" } };
        String[][][] allarr = { arr1, arr2, arr3 };
        String[][] arr;
        for (int i = 0; i < allarr.length; i++) {
            arr = allarr[i];
            try {
                System.out.println("3. Сумма элементов массива = " + sum2(arr));
            } catch (MyArraySizeException ms) {
                System.out.println(ms.getMessage());
            } catch (MyArrayDataException md) {
                System.out.println(md.getMessage());
            }
        }
        System.out.println();
    }

    /**
     * Метод проходит по всем элементам массива,
     * преобразовывает их в int и находит их сумму
     * При подаче массива другого размера - исключение MyArraySizeException
     * Если в элементе массива преобразование не удалось -
     * исключение MyArrayDataException с указанием ячейки
     *
     * @param arr
     * @return
     * @throws MyArraySizeException
     * @throws MyArrayDataException
     */
    public static int sum2(String[][] arr)
            throws MyArraySizeException, MyArrayDataException {
        boolean arrLength = true;
        if (arr.length != dim) {
            arrLength = false;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != dim) {
                    arrLength = false;
                }
            }
        }
        if (!arrLength)
            throw new MyArraySizeException();
        int sum = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != null) {
                        try {
                            sum += Integer.parseInt(arr[i][j]);
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException(
                                    "В ячейке(индексы) (" + i + "," + j + ")");
                        }
                    }
                }
            }
        }
        return sum;
    }
}
