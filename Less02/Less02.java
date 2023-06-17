// Задача. Реализовать алгоритм пирамидальной 
// сортировки (сортировка кучей)

public class Less02 {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 8, 1, 10, 9, 2, 6, 5, 4, 7 };
        for (int item : arr) {
            System.out.printf("%d ", item);
        }
        System.out.println();

        int temp = 0;
        int n = arr.length;
        for (int i = 1; i <= n; i++) {
            for (int j = (int) ((n + 1) / 2) - (int) (i / 2); j >= 1; j--) {
                if (2 * j + 1 <= n - i + 1) {
                    if (arr[2 * j - 1] > arr[2 * j]) {
                        if (arr[j - 1] < arr[2 * j - 1]) {
                            temp = arr[j - 1];
                            arr[j - 1] = arr[2 * j - 1];
                            arr[2 * j - 1] = temp;
                        }
                    } else {
                        if (arr[j - 1] < arr[2 * j]) {
                            temp = arr[j - 1];
                            arr[j - 1] = arr[2 * j];
                            arr[2 * j] = temp;
                        }
                    }
                } else {
                    if (2 * j <= n - i + 1) {
                        if (arr[j - 1] < arr[2 * j - 1]) {
                            temp = arr[j - 1];
                            arr[j - 1] = arr[2 * j - 1];
                            arr[2 * j - 1] = temp;
                        }
                    }
                }
            }
            temp = arr[0];
            arr[0] = arr[n - i];
            arr[n - i] = temp;
        }
        
        for (int item : arr) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }
}
