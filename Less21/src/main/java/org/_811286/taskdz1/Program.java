package org._811286.taskdz1;

import java.io.*;

public class Program {

    /**
     * Задача 1
     * ========
     * <p>
     * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
     * Обеспечьте поддержку сериализации для этого класса.
     * Создайте объект класса Student и инициализируйте его данными. Сериализуйте этот объект в файл.
     * Десериализуйте объект обратно в программу из файла. Выведите все поля объекта, включая GPA,
     * и обсудите, почему значение GPA не было сохранено/восстановлено.
     * <p>
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println();
        Student stdnt = new Student("Андрей", 45, 4.8);
        try (FileOutputStream fileOutputStream = new FileOutputStream("stdnt.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(stdnt);
            System.out.println("Объект Student сериализован.");
        }

        System.out.println();
        Student stdnt2;
        try (FileInputStream fileInputStream = new FileInputStream("stdnt.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            stdnt2 = (Student) objectInputStream.readObject();
            System.out.println("Объект Student-2 десериализован.");
        }

        System.out.println("Имя: " + stdnt2.getName());
        System.out.println("Возраст: " + stdnt2.getAge());
        System.out.println("Средний балл (должен быть 0.0, так как transient): " + stdnt2.getGPA());
    }
}
