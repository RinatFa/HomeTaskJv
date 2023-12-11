package org._811286;

/**
 * Абстрактный класс Животное
 */
public abstract class Animal {
    protected String name;
    protected int age;

    abstract void makeSound();

    public Animal() {
        name = "Animal";
        age = 1;
    }
}
