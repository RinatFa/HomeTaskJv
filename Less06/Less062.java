// Задание 2. Если необходимо, исправьте данный код.

public class Less062 {

    public static void main(String[] args) {
        System.out.println();
        int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int d;
        try {
            d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Указан индекс за пределами массива");
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
            System.out.println("Деление на 0");
            d = 1;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        System.out.println();
    }
}
