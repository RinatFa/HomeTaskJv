package org._811286.taskdz2;

import java.io.File;

import static org._811286.taskdz2.StudentApp.*;
import static org._811286.taskdz2.StudentApp.FILE_XML;

public class Program {

    public static void main(String[] args) {
        System.out.println();
        Student stdnt = new Student("Андрей", 45, 4.8);
        Student stdnt2;
        Student stdnt3;
        Student stdnt4;

        StudentApp.saveTasksToFile(FILE_BIN, stdnt);
        StudentApp.saveTasksToFile(FILE_JSON, stdnt);
        StudentApp.saveTasksToFile(FILE_XML, stdnt);

        File fB = new File(FILE_BIN);
        if (fB.exists() && !fB.isDirectory()) {
            stdnt2 = loadTasksFromFile(FILE_BIN);
            System.out.print("*** from FILE_BIN:  ");
            displayStud(stdnt2);
        }
        File fJ = new File(FILE_JSON);
        if (fJ.exists() && !fJ.isDirectory()) {
            stdnt3 = loadTasksFromFile(FILE_JSON);
            System.out.print("*** from FILE_JSON:  ");
            displayStud(stdnt3);
        }
        File fX = new File(FILE_XML);
        if (fX.exists() && !fX.isDirectory()) {
            stdnt4 = loadTasksFromFile(FILE_XML);
            System.out.print("*** from FILE_XML:  ");
            displayStud(stdnt4);
        }
    }
}
