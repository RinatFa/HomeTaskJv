import java.util.Scanner;

// Задание 4. Разработайте программу, которая выбросит Exception, когда
// пользователь вводит пустую строку. Пользователю должно показаться
// сообщение, что пустые строки вводить нельзя.

public class Less064 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Введите непустую строку и не пробелы!");
        System.out.println(" *** Ваша строка:  \"" + sString(
                "Введите строку: ") + "\"  ***");
        System.out.println();
    }

    static String sString(String str) {
        String sStr = "";
        Scanner sScanner = new Scanner(System.in, "Cp866");
        boolean flag = false;
        while (!flag) {
            System.out.printf(str);
            sStr = sScanner.nextLine();
            sStr = sStr.trim();
            if (sStr == "") {
                sStr = null;
            } else {
                flag = true;
            }
            try {
                int iN = sStr.length();
            } catch (NullPointerException e) {
                System.out.println("Пустую строку вводить нельзя, исключение: " +
                        e.getClass().getSimpleName());
            }
        }
        sScanner.close();
        return sStr;
    }
}
