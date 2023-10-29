package org._811286;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainEmpl {
    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static int iNumber(String str, int max) {
        boolean flag = false;
        String sName = "";
        int n = 0;
        Scanner iScanner = new Scanner(System.in);
        while (flag == false) {
            System.out.printf(str);
            sName = iScanner.nextLine();
            flag = isNumeric(sName);
            if (flag == true) {
                try {
                    n = Integer.parseInt(sName);
                } catch (NumberFormatException e) {
                    n = 0;
                }
                if ((n < 0) || (n > max))
                    flag = false;
            } else {
                if (sName.equals("")) {
                    n = -1;
                    flag = true;
                }
            }
        }
        if (n < -1)
            iScanner.close();
        return n;
    }

    static String sString(String str) {
        String sStr = "";
        Scanner sScanner = new Scanner(System.in, "Cp866");
        System.out.print(str);
        sStr = sScanner.nextLine();
        sStr = sStr.trim();
        if (isNumeric(sStr)) {
            sStr = "";
        }
        if (sStr.equals("-1")) {
            sScanner.close();
        }
        return sStr;
    }

    public static void main(String[] args) {
        List<Employee> lEmp = new ArrayList<>();
        GuideEmpl guideEmpl = new GuideEmpl(lEmp);
        guideEmpl.addEmpl(1001, 12345001, "Иван", 25);
        guideEmpl.addEmpl(1002, 12345002, "Антон", 20);
        guideEmpl.addEmpl(1003, 12345003, "Андрей", 15);
        guideEmpl.addEmpl(1004, 12345004, "Иван", 18);
        guideEmpl.addEmpl(1005, 12345005, "Артем", 15);
        System.out.println();

        String sMenu = "  Введите цифру, соответствующую меню справочника (0-5):\n";
        sMenu += "1. Список всех сотрудников                    ";
        sMenu += "3. Поиск сотрудника по стажу (по умолч. 15, Enter)\n";
        sMenu += "2. Добавить нового сотрудника в справочник    ";
        sMenu += "4. Поиск номера телефона по имени (по умолч. Иван, Enter)\n";
        sMenu += "0. Выход из справочника (0 или Enter)         ";
        sMenu += "5. Поиск по табельному номеру (по умолч. 1004, Enter)\n";
        sMenu += "--> ";

        int nMenu = 1, nServ = 1000, nTel = 12345678, nExp = 1;
        int numbMenu = 5;
        int numbServ = 9999;
        int numbTel = 999999999;
        int numbExp = 65;
        String sStr = "";
        while (nMenu > 0) {
            nMenu = iNumber(sMenu, numbMenu);
            System.out.println();
            if ((nMenu == 0) || (nMenu == -1)) {
                System.out.println(">>>>> Выход из справочника");
                System.out.println();
                break;
            } else if (nMenu == 1) {
                System.out.println(">>>>> Список всех сотрудников:");
                System.out.println(guideEmpl.toString());
            } else if (nMenu == 2) {
                int iCount = 0;
                sStr = sString("Введите Имя: ");
                if (isNumeric(sStr)) {
                    System.out.println("Имя не должно быть числом!\n");
                    break;
                }
                if (sStr.equals("")) {
                } else {
                    iCount++;
                    while (true) {
                        nServ = iNumber("Введите табельный номер (до 4 цифр): ",
                                numbServ);
                        iCount++;
                        if ((nServ == 0) || (nServ == -1)) {
                            break;
                        }
                        nTel = iNumber("Введите номер телефона (до 9 цифр): ",
                                numbTel);
                        iCount++;
                        if ((nTel == 0) || (nTel == -1)) {
                            break;
                        }
                        nExp = iNumber("Введите cтаж (0-65): ", numbExp);
                        if (nExp == -1) {
                            break;
                        } else {
                            iCount++;
                            if (iCount == 4) {
                                guideEmpl.addEmpl(nServ, nTel, sStr, nExp);
                                System.out.println(
                                        ">>>>> Новый сотрудник добавлен успешно!\n");
                                break;
                            }
                        }
                    }
                }
                if (iCount < 4) {
                    System.out.println(
                            "    Недостаточно данных для добавления сотрудника!\n");
                }
            } else if (nMenu == 3) {
                nExp = iNumber("Введите cтаж (0-65) (по умолч. 15, Enter): ",
                        numbExp);
                if (nExp == -1) {
                    nExp = 15;
                }
                System.out.println("\n>>>>> Все сотрудники со стажем " + nExp + " лет:");
                System.out.println(guideEmpl.findExper(nExp));
            } else if (nMenu == 4) {
                sStr = sString("Введите Имя (по умолч. Иван, Enter): ");
                if (isNumeric(sStr)) {
                    System.out.println("Имя не должно быть числом!\n");
                    sStr = "";
                }
                if (sStr.equals("")) {
                    sStr = "Иван";
                }
                System.out.println("\n>>>>> Номера телефонов сотрудников с именем " +
                        sStr + ":");
                System.out.println(guideEmpl.findName(sStr));
            } else if (nMenu == 5) {
                nServ = iNumber("Введите табельный номер (до 4 цифр) " +
                        "(по умолч. 1004, Enter): ", numbServ);
                if ((nServ == 0) || (nServ == -1)) {
                    nServ = 1004;
                }
                System.out.println("\n>>>>> Сотрудник с табельным номером " +
                        nServ + ":");
                System.out.println(guideEmpl.findServNumb(nServ));
            }
        }
    }
}
