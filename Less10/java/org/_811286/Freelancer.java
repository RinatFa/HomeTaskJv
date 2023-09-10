package org._811286;

import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee {

    private Freelancer(String surName, String name, double salary, int exp) {
        super(surName, name, salary, exp);
        this.salary = calculateSalary();
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
        return new Freelancer(surNam, Nam,
                random.nextInt(200, 1500),
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
        salary *= 20.8 * 8; // _выводит зарплату с почасовой ставкой
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%10s %10s;  Фрилансер;  стаж %2d г/л; " +
                " Среднемесячная заработная плата" +
                " (20.8 * 8 * почасовая ставка):  \t%9.2f (руб.)",
                surName, name, exp, salary);
    }
}
