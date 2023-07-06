
/** 
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных 
 * массива, и возвращающий новый массив, каждый элемент которого равен
 * частному элементов двух входящих массивов в той же ячейке. 
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 * Важно: При выполнении метода единственное исключение, 
 * которое пользователь может увидеть - RuntimeException, т.е. ваше.
*/

import java.util.Arrays;

public class Less054 {
    public static void main(String[] args) {
        int[] arr1 = { 8, 10, 0, 7 };
        int[] arr2 = { 4, 5, 0 };
        try {
            int[] result = divArr(arr1, arr2);
            System.out.println(Arrays.toString(result));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int[] divArr(int[] arr1, int[] arr2) throws RuntimeException {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы имеют разную длину");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Деление на 0");
            } else {
                result[i] = arr1[i] / arr2[i];
            }
        }
        return result;
    }
}
