import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// 1. Напишите приложение, которое будет запрашивать у пользователя
// следующие данные в произвольном порядке, разделенные пробелом:
//     Фамилия Имя Отчество датарождения номертелефона пол
//   Форматы данных:
//     фамилия, имя, отчество - строки
//     датарождения - строка формата dd.mm.yyyy
//     номертелефона - целое беззнаковое число без форматирования
//     пол - символ латиницей f или m.
//   Приложение должно проверить введенные данные по количеству. Если 
// количество не совпадает с требуемым, вернуть код ошибки, обработать его
// и показать пользователю сообщение, что он ввел меньше и больше данных,
// чем требуется.
//   Приложение должно попытаться распарсить полученные значения и выделить
// из них требуемые параметры. Если форматы данных не совпадают, нужно
// бросить исключение, соответствующее типу проблемы. Можно использовать
// встроенные типы java и создать свои. Исключение должно быть корректно
// обработано, пользователю выведено сообщение с информацией, что именно
// неверно.
//   Если всё введено и обработано верно, должен создаться файл с названием,
// равным фамилии, в него в одну строку должны записаться полученные данные,
// вида
//     <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//   Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//   Не забудьте закрыть соединение с файлом. 
//   При возникновении проблемы с чтением-записью в файл, исключение должно
// быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

public class Less071 {

    static void FileOutputApp(String FileName, String str) {
        File file = new File(FileName);
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(str + "\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println();
        String s1 = "  Для быстрой проверки - шаблоны ввода (#1-#9):          ";
        s1 += "*** Минимум проходит без ошибок: \"1 ов вич им f 11.11.1991\" ***\n";
        s1 += "#1 = Петров Сергей Иванович 20.05.2000 9123456789 m      ";
        s1 += "#6 = МалоПолей 5 Петров Иван Сергеевич\n";
        s1 += "#2 = m Петров Иван Сергеевич 12.12.1986 9123456987       ";
        s1 += "#7 = МногоПолей 8 m Петров Иван Сергеевич 12.12.1986 9123456987\n";
        s1 += "#3 = 9123459876 f Ирина Пекина Сергеевна 18.10.1995      ";
        s1 += "#8 = ErrTelNumb Иван Сергеевич 12.12.1986 abc3456987 m\n";
        s1 += "#4 = 19.01.1978 9123498765 m Андрей Грачёв Павлович      ";
        s1 += "#9 = ErrDate Иван Сергеевич 42.42.1986 96987 m\n";
        s1 += "#5 = Ринатовна 9123987654 10.05.1993 f Абеева Лейсан     ";
        s1 += "#10 = Выход из программы\n";

        String s2 = "  Введите строку, содержащую 6 полей данных через пробел: \n";
        s2 += "Фамилия Имя Отчество - 3 поля, дата_рождения - dd.mm.yyyy\n";
        s2 += "номер_телефона - целое_число, обычно 10 цифр, пол - f/m (жен/муж): ";
        String fio_bts = sString(s1 + s2);
        System.out.println(" *** Ваша строка:  \"" + fio_bts + "\"  ***");
        System.out.println();
    }

    static String sString(String str) {
        String[] sArr = new String[0];
        String[] sReal = new String[6];
        String sStr = "";
        Scanner sScanner = new Scanner(System.in, "Cp866");
        boolean flag = false;
        while (!flag) {
            int iBox = 21;
            System.out.printf(str);
            sStr = sScanner.nextLine();
            sStr = sStr.trim();
            if (sStr.equals("#6")) {
                sStr = "МалоПолей 5 Петров Иван Сергеевич";
            } else if (sStr.equals("#7")) {
                sStr = "МногоПолей 8 m Петров Иван Сергеевич 12.12.1986 9123456987";
            } else if (sStr.equals("#8")) {
                sStr = "ErrTelNumb Иван Сергеевич 12.12.1986 abc3456987 m";
            } else if (sStr.equals("#9")) {
                sStr = "ErrDate Иван Сергеевич 42.42.1986 96987 m";
            } else if (sStr.equals("#1")) {
                sStr = "Петров Сергей Иванович 20.05.2000 9123456789 m";
            } else if (sStr.equals("#2")) {
                sStr = "m Петров Иван Сергеевич 12.12.1986 9123456987";
            } else if (sStr.equals("#3")) {
                sStr = "9123459876 f Пекина Ирина Сергеевна 18.10.1995";
            } else if (sStr.equals("#4")) {
                sStr = "19.01.1978 9123498765 m Андрей Грачёв Павлович";
            } else if (sStr.equals("#5")) {
                sStr = "Ринатовна 9123987654 10.05.1993 f Абеева Лейсан";
            } else if (sStr.equals("#10")) {
                sStr = "Выход из программы";
                break;
            }

            sArr = sStr.split(" ");
            System.out.println();
            System.out.println();
            System.out.println();
            if (sArr.length > 6) {
                System.out.println(" !!! Неверные количество данных в строке: " + sStr);
                System.out.println("Данных больше, чем требуется: " +
                        sArr.length + " > 6 полей");
                System.out.println();
            } else if (sArr.length < 6) {
                System.out.println(" !!! Неверные количество данных в строке: " + sStr);
                System.out.println("Данных меньше, чем требуется: " +
                        sArr.length + " < 6 полей");
                System.out.println();
            } else {
                while (true) {
                    int iBoxTemp = iBox;
                    for (int i = 0; i < sArr.length; i++) {
                        if (sArr[i].equals("f") || sArr[i].equals("m")) {
                            sReal[5] = sArr[i];
                            iBox -= (i + 1);
                        }
                    }
                    if (iBox == iBoxTemp) {
                        System.out.println(" !!! Неверный формат данных (пол f или m)");
                        break;
                    }
                    iBoxTemp = iBox;
                    for (int i = 0; i < sArr.length; i++) {
                        try {
                            Long value = Long.parseLong(sArr[i]);
                            sReal[4] = sArr[i];
                            iBox -= (i + 1);
                        } catch (NumberFormatException e) {
                        }
                    }
                    if (iBox == iBoxTemp) {
                        System.out.println(" !!! Неверный формат данных (числовой номер телефона)");
                        break;
                    }
                    iBoxTemp = iBox;
                    for (int i = 0; i < sArr.length; i++) {
                        try {
                            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                            df.setLenient(false);
                            df.parse(sArr[i]);
                            sReal[3] = sArr[i];
                            iBox -= (i + 1);
                        } catch (ParseException e) {
                        }
                    }
                    if (iBox == iBoxTemp) {
                        System.out.println(" !!! Неверный формат данных (дата рождения dd.MM.yyyy)");
                        break;
                    }
                    iBoxTemp = iBox;
                    String sStr2;
                    String sStr3;
                    for (int i = 0; i < sArr.length; i++) {
                        sStr2 = sArr[i].substring(Math.max(0, sArr[i].length() - 2));
                        sStr3 = sArr[i].substring(Math.max(0, sArr[i].length() - 3));
                        if (sStr2.equals("ов") || sStr3.equals("ова") ||
                                sStr2.equals("ов") || sStr3.equals("ова") ||
                                sStr2.equals("ев") || sStr3.equals("ева") ||
                                sStr2.equals("ёв") || sStr3.equals("ёва") ||
                                sStr2.equals("ин") || sStr3.equals("ина") ||
                                sStr3.equals("кий") || sStr3.equals("кая") ||
                                sStr2.equals("ко") || sStr3.equals("идт")) {
                            if (sStr3.equals("ина")) { // 20 популярных имен из 307
                                if (sArr[i].equals("Ирина") || sStr3.equals("Арина") ||
                                        sStr2.equals("Марина") || sStr3.equals("Карина") ||
                                        sStr2.equals("Дарина") || sStr3.equals("Зарина") ||
                                        sStr2.equals("Екатерина") || sStr3.equals("Дина") ||
                                        sStr2.equals("Галина") || sStr3.equals("Валентина") ||
                                        sStr2.equals("Ангелина") || sStr3.equals("Антонина") ||
                                        sStr2.equals("Мальвина") || sStr3.equals("Регина") ||
                                        sStr2.equals("Алина") || sStr3.equals("Сабина") ||
                                        sStr3.equals("Эвелина") || sStr3.equals("Нина") ||
                                        sStr2.equals("Эльвина") || sStr3.equals("Альбина")) {
                                } else {
                                    sReal[0] = sArr[i];
                                    iBox -= (i + 1);
                                }
                            } else {
                                sReal[0] = sArr[i];
                                iBox -= (i + 1);
                            }
                        }
                    }
                    if (iBox == iBoxTemp) {
                        System.out.println(" !!! Неверный формат данных (Фамилия)");
                        break;
                    }
                    iBoxTemp = iBox;
                    String sStr23;
                    for (int i = 0; i < sArr.length; i++) {
                        sStr23 = sArr[i].substring(Math.max(0, sArr[i].length() - 3));
                        if (sStr23.equals("вич") || sStr23.equals("вна")) {
                            sReal[2] = sArr[i];
                            iBox -= (i + 1);
                        }
                    }
                    if (iBox == iBoxTemp) {
                        System.out.println(" !!! Неверный формат данных (Отчество)");
                        break;
                    }
                    sReal[1] = sArr[iBox - 1];
                    if (sReal[1].length() < 2) {
                        System.out.println(" !!! Неверный формат данных (Имя минимум 2 буквы)");
                        break;
                    }
                    sStr = sReal[0];
                    for (int i = 1; i < sReal.length; i++) {
                        sStr += " " + sReal[i];
                    }
                    if (sReal[0] != null) {
                        String FileName = sReal[0] + ".txt";
                        FileOutputApp(FileName, sStr);
                    }
                    break;
                }
                System.out.println(" *** Ваша строка:  \"" + sStr + "\"  ***");
                System.out.println();
            }
        }
        sScanner.close();
        return sStr;
    }
}
