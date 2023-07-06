/**
 * Посмотрите на код и подумайте сколько разных типов исключений
 * вы тут сможете получить?
 */

public class Less052 {
    public static void main(String[] args) {
        String[][] arr = { { "1", "2" }, { "3", "4" }, { "1", "6" } };
        System.out.println(sum2d(arr));
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { // NullPointerException
            for (int j = 0; j < 5; j++) { // ArrayIndexOutOfВoundsException
                int val = Integer.parseInt(arr[i][j]); // ClassCastException
                sum += val;
            }
        }
        return sum;
    }
}
