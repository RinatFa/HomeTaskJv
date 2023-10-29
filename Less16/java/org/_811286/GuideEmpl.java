package org._811286;

import java.util.ArrayList;
import java.util.List;

public class GuideEmpl {
    List<Employee> lEmpl = new ArrayList<>();

    public GuideEmpl(List<Employee> lEmpl) {
        this.lEmpl = lEmpl;
    }

    public void addEmpl(int servNumb, int phoneNumb, String sName, int exper) {
        lEmpl.add(new Employee(servNumb, phoneNumb, sName, exper));
    }

    public String findName(String sName) {
        String sStr = "";
        for (int i = 0; i < lEmpl.size(); i++) {
            if (lEmpl.get(i).compareTo(sName) == 0) {
                sStr += "  Сотрудник " + lEmpl.get(i).name +
                        ": номер телефона = " + lEmpl.get(i).phoneNumber + "\n";
            }
        }
        if (sStr.equals("")) {
            sStr = "      Не найдено!\n";
        }
        return sStr;
    }

    public String findServNumb(int iServ) {
        String sStr = "";
        for (int i = 0; i < lEmpl.size(); i++) {
            if (lEmpl.get(i).compareServ(iServ) == 0) {
                sStr += lEmpl.get(i).toString();
            }
        }
        if (sStr.equals("")) {
            sStr = "      Не найдено!\n";
        }
        return sStr;
    }

    public String findExper(int iExper) {
        String sStr = "";
        for (int i = 0; i < lEmpl.size(); i++) {
            if (lEmpl.get(i).compareExper(iExper) == 0) {
                sStr += lEmpl.get(i).toString();
            }
        }
        if (sStr.equals("")) {
            sStr = "      Не найдено!\n";
        }
        return sStr;
    }

    @Override
    public String toString() {
        String sStr = "";
        for (int i = 0; i < lEmpl.size(); i++) {
            sStr += lEmpl.get(i).toString();
        }
        return sStr;
    }

}