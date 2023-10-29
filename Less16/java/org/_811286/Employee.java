package org._811286;

public class Employee {
    int serviceNumber;
    int phoneNumber;
    String name;
    int experience;

    public Employee(int serviceNumber, int phoneNumber, String name, int experience) {
        this.serviceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "  Сотрудник " + name + ": табельный номер = " + serviceNumber +
                ", номер телефона = " + phoneNumber +
                ", стаж = " + experience + " лет\n";
    }

    public int compareTo(String sName) {
        return this.name.compareTo(sName);
    }

    public int compareExper(int iExper) {
        return this.experience - iExper;
    }

    public int compareServ(int iServ) {
        return this.serviceNumber - iServ;
    }

}
