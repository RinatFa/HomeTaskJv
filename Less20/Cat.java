package org._811286;

/**
 * Класс Кот
 */
public class Cat extends Animal {
    private String color;

    public Cat() {
        color = "серый";
    }

    public void displayInfo() {
        System.out.println("Выходит кот с именем '" + name +
                "', с возрастом = " + age +
                ", c цветом шерсти: " + color);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " издает звук: Мяу! Мяу! Мяу!");
    }

    public void purr() {
        System.out.println(name + " мурлычет!");
    }

    public void jump() {
        System.out.println("Вызываем игрой прыжок " + name + "а!");
    }
}
