package org._811286;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true, false);

    }

    /**
     * Метод print, печать директорий и файлов
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast, boolean isFile) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        if (isFile)
            System.out.println(" " + file.getName());
        else
            System.out.println("■ [" + file.getName() + "]");

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        int subFilTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
            else if (files[i].isFile())
                subFilTotal++;
        }
        subDirTotal += subFilTotal; // сумма директорий и файлов
        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDirTotal, false);
            }
        }
        int subFilCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                subFilCounter++;
                print(files[i], indent, subFilCounter == subFilTotal, true);
            }
        }
    }
}
