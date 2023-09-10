package org._811286;

import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Employee> employees = Worker.getEmployees(15);
        List<Employee> employees2 = Freelancer.getEmployees(15);
        for (Employee employee : employees2) {
            employees.add(employee);
        } // _Объединение коллекций

        System.out.println();
        Collections.sort(employees, new EmployeeNameComparator());
        System.out.println();
        System.out.println("1. Список сотрудников (сортировка по Фамилия + Имя): ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Collections.sort(employees);
        System.out.println();
        System.out.println("2. Список сотрудников (сортировка по Зарплате): ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Collections.sort(employees, new EmployeeExpComparator());
        System.out.println();
        System.out.println("3. Список сотрудников (сортировка по Стажу работы): ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.print("4. Список сотрудников массива класса (for): ");
        Employee[] empl1 = employees.toArray(
                new Employee[employees.size()]);
        EmplArray EmplArr1 = new EmplArray(empl1);
        System.out.println(EmplArr1.getEmpl());

        System.out.println();
        System.out.println("5. Список сотрудников массива класса (foreach): ");
        System.out.println(EmplArr1.getEmpl2());

        System.out.println("( Количество сотрудников: " + employees.size() +
                ", количество исключений повторения пары 'Фамилия + Имя': "
                + Employee.countTwoNames + " )");
        System.out.println();
    }
}
