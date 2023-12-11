package org._811286;

/**
 * Класс Пес
 */
public class Dog extends Animal {
    private String color;

    public Dog() {
        color = "серый";
    }

    public void displayInfo() {
        System.out.println("Выходит пес с именем '" + name +
                "', с возрастом = " + age +
                ", c цветом шерсти: " + color);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " издает звук: Гав! Гав! Гав!");
    }

    public void wag_tail() {
        System.out.println(name + " виляет хвостом!");
    }

    public void jump() {
        System.out.println("Вызываем игрой прыжок " + name + "а!");
    }
}
