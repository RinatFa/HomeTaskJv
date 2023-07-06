/**
 * Реализуйте 3 метода, чтобы в каждом из них
 * получить разные исключения
 */

public class Less051 {
    public static void main(String[] args) {
        int[] iArr = { 1, 2, 3, 4, 5 };
        met1(10, 0);
        met2(iArr);
        met3("s");
    }

    public static int met1(int a1, int a2) {
        return a1 / a2;
    }

    public static int[] met2(int[] arr) {
        for (int i = 1; i < 7; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public static int met3(String s) {
        return Integer.parseInt(s);
    }

}
