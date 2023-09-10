package org._811286;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee {

    private Worker(String surName, String name, double salary, int exp) {
        super(surName, name, salary, exp);
    }

    public static Employee getInstance() {
        String surNam = "";
        String Nam = "";
        while (true) {
            surNam = surNames[random.nextInt(surNames.length)];
            Nam = names[random.nextInt(names.length)];
            if (!twoNames.contains(surNam + Nam)) {
                twoNames.add(surNam + Nam);
                break;
            }
            countTwoNames += 1;
        } // _Исключение повторения пары "Фамилия + Имя"
        return new Worker(surNam, Nam,
                random.nextInt(30000, 250000),
                random.nextInt(3, 35));
    }

    public static List<Employee> getEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%10s %10s;  Рабочий;    стаж %2d г/л; " +
                " Среднемесячная заработная плата" +
                " (фиксированная месячная оплата):\t%9.2f (руб.)",
                surName, name, exp, salary);
    }
}
