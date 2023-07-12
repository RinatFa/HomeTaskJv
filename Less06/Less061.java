import java.util.Scanner;

// Задание 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа
// (типа float), и возвращает введенное значение. Ввод текста вместо числа
// не должно приводить к падению приложения, вместо этого, необходимо
// повторно запросить у пользователя ввод данных.

public class Less061 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(" *** Дробное число: " + fNumber(
                "Введите дробное число (типа float, с точкой): ") + "f ***");
        System.out.println();
    }

    static float fNumber(String str) {
        String sName = "";
        float fNumb = 0.0f;
        Scanner sScanner = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            System.out.printf(str);
            sName = sScanner.nextLine();
            flag = isFloat(sName);
            if (flag) {
                fNumb = Float.parseFloat(sName);
            }
        }
        sScanner.close();
        return fNumb;
    }

    static boolean isFloat(String str) {
        boolean fFlat = false;
        try {
            Float.parseFloat(str);
            fFlat = true;
            var vN = Integer.parseInt(str);
            String sN = ((Object) vN).getClass().getSimpleName();
            if (sN.equals("Integer")) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            if (fFlat) {
                return true;
            } else {
                return false;
            }
        }
    }
}
