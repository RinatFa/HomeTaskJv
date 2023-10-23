package org._811286;

// 1. Написать класс Калькулятор (необобщенный), который 
// содержит обобщенные статические методы: 
// sum(), multiply(), divide(), subtract(). 
// Параметры этих методов – два числа разного типа 
// (но необязательно разного между собой), над которыми 
// должна быть произведена операция.
public class Calcu {
    public static <T extends Number> Double sum(T item1, T item2) {
        double sum = 0.0;
        sum = item1.doubleValue() + item2.doubleValue();
        return sum;
    }

    public static <T extends Number> Double subtract(T item1, T item2) {
        double sub = 0.0;
        sub = item1.doubleValue() - item2.doubleValue();
        return sub;
    }

    public static <T extends Number> Double multiply(T item1, T item2) {
        double mult = 1.0;
        mult = item1.doubleValue() * item2.doubleValue();
        return mult;
    }

    public static <T extends Number> Double divide(T item1, T item2) {
        double div = 0.0;
        if (item2.doubleValue() != 0) {
            div = item1.doubleValue() / item2.doubleValue();
        } else {
            System.out.println("Деление на ноль!");
        }
        return div;
    }
}
