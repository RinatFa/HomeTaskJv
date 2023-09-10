package org._811286;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Employee implements Comparable<Employee> {

    // region Public Methods

    /**
     * Расчет среднемесячной заработной платы
     *
     * @return
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(getSalary(), o.getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary + '\'' +
                ", exp=" + exp +
                '}';
    }

    // endregion

    // region Constructors And Initializers

    {
        id = ++counter;
    }

    private Employee() {
        this("#Surnane#", "#Name#");
    }

    private Employee(String surName, String name) {
        this(surName, name, 200, 3);
    }

    protected Employee(String surName, String name, double salary, int exp) {
        this.surName = surName;
        this.name = name;
        this.setSalary(salary);
        this.setExp(exp);
    }

    // endregion

    // region Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public Integer getExp() {
        return exp;
    }

    public void setSalary(double salary) {
        if (salary < 200) {
            throw new RuntimeException("Ставка/уровееь заработной платы" +
                    " должна быть не менее 200/30000");
        }
        this.salary = salary;
    }

    public void setExp(int exp) {
        if ((exp < 3) || (exp > 35)) {
            throw new RuntimeException("Стаж работы должна быть от 3 до 35 лет");
        }
        this.exp = exp;
    }

    // endregion

    // region Fields

    private int id;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    /**
     * Стаж работы experience
     */
    protected int exp;

    // endregion

    // region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб",
            "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий",
            "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин",
            "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов",
            "Лыткин", "Соколов" };
    protected static Random random = new Random();
    private static int counter = 1000;
    protected static List<String> twoNames = new ArrayList<>();
    protected static int countTwoNames = 0;

    // endregion
}
