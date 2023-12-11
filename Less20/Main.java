package org._811286;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Задача 1:
 * Создайте абстрактный класс "Animal" с полями "name" и "age".
 * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с
 * уникальными полями и методами.
 * Создайте массив объектов типа "Animal" и с использованием Reflection API
 * выполните следующие действия:
 * Выведите на экран информацию о каждом объекте.
 * Вызовите метод "makeSound()" у каждого объекта, если такой метод
 * присутствует.
 */
public class Main {
    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, NoSuchFieldException {
        System.out.println();
        String sPackage = "org._811286"; // _!!!

        Class<?> animClass = Class.forName(sPackage + ".Animal");
        Field[] fields = animClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Поле у cat и dog: " + field.getName());
        }

        Class<?> catClass = Class.forName(sPackage + ".Cat");
        Field[] fields2 = catClass.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("Поле у cat: " + field.getName());
        }
        Constructor[] constructors = catClass.getConstructors();
        Object catInstance = constructors[0].newInstance(null);

        Class<?> dogClass = Class.forName(sPackage + ".Dog");
        Field[] fields3 = catClass.getDeclaredFields();
        for (Field field : fields3) {
            System.out.println("Поле у dog: " + field.getName());
        }
        Constructor[] constructors3 = dogClass.getConstructors();
        Object dogInstance = constructors3[0].newInstance(null);

        Field nameField = animClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(catInstance, "Барсик");
        nameField.set(dogInstance, "Шарик");

        Field ageField = animClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(catInstance, 3);
        ageField.set(dogInstance, 5);

        Field colorField = catClass.getDeclaredField("color");
        colorField.setAccessible(true);
        colorField.set(catInstance, "белый");
        Field colorField2 = dogClass.getDeclaredField("color");
        colorField2.setAccessible(true);
        colorField2.set(dogInstance, "черный");

        System.out.println();
        Animal[] animals = { (Animal) catInstance, (Animal) dogInstance };
        for (int i = 0; i < animals.length; i++) {
            animals[i].getClass().getDeclaredMethod(
                    "displayInfo").invoke(animals[i]);
            animals[i].getClass().getDeclaredMethod(
                    "makeSound").invoke(animals[i]);
            try {
                animals[i].getClass().getDeclaredMethod(
                        "purr").invoke(animals[i]);
            } catch (Exception e) {
            }
            try {
                animals[i].getClass().getDeclaredMethod(
                        "wag_tail").invoke(animals[i]);
            } catch (Exception e) {
            }
            animals[i].getClass().getDeclaredMethod(
                    "jump").invoke(animals[i]);
            System.out.println();
        }
    }
}
