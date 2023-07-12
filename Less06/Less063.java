// Задание 3. Дан следующий код, исправьте его там, где требуется.

public class Less063 {

    public static void main(String[] args) throws Exception {
        System.out.println();
        try {
            int a = 90;
            int b = 3;
            try {
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                System.out.println("Деление на 0");
            }
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
        System.out.println();
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
