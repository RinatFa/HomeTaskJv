package org._811286.sample;

import org._811286.regular.OtherClass;
import org._811286.regular.OtherClass2;

/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 */
public class Main {
    /**
     * Точка входа в программу. С нее всегда все начинается.
     *
     * @param args стандартные аргументы командной строки.
     */
    public static void main(String[] args) {
        // использование класса из другого пакета:
        int iNmb1 = 6, iNmb2 = 2;
        int result = OtherClass.sum(iNmb1, iNmb2);
        int result2 = OtherClass.diff(iNmb1, iNmb2);
        int result3 = OtherClass2.mult(iNmb1, iNmb2);
        int result4 = OtherClass2.div(iNmb1, iNmb2);
        System.out.println("Функции для двух целых чисел " + iNmb1 + " и " + iNmb2 + " :");
        System.out.println("Сумма " + OtherClass.decorate(result));
        System.out.println("Разность " + OtherClass.decorate(result2));
        System.out.println("Умножение " + OtherClass.decorate(result3));
        System.out.println("Деление " + OtherClass.decorate(result4));
    }

    /**
     * Конструктор по умолчанию
     */
    public Main() {
    }
}
