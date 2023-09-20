package org._811286;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyDa {
    /**
     * Резервное копирование директорий и файлов
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("\nРезервное копирование" +
                " директорий и файлов");
        System.out.println("    из источника в путь назначения:");
        String sSource = "./src/main/java/org";
        System.out.println("Путь к источнику : " + sSource);
        String sDestin = "./backup";
        System.out.println("Путь назначения : " + sDestin);
        (new File(sDestin)).mkdir();

        copyAll(sSource, sDestin);

        if (iCount != 0) {
            if (bYes)
                System.out.println("\nРезервная копия создана!\n");
            else
                System.out.println("\nПуть нзначения в источнике. Резервная копия не создана!\n");
        } else {
            System.out.println("\nУказан несуществующий путь к источнику!\n");
        }

    }

    public static boolean bYes = true;
    public static int iCount = 0;

    /**
     * Рекурсивный обход директорий
     * 
     * @param sSour
     * @param sDest
     * @throws IOException
     */
    public static void copyAll(String sSour, String sDest) throws IOException {
        String sPathS = new File(sSour).getCanonicalPath();
        String sPathD = new File(sDest).getCanonicalPath();

        List<String> result = getDir(new File(sSour));

        if (result == null)
            return;
        String sConcatPathS = "";
        String sConcatPathD = "";
        String sConcatS = "";
        String sConcatD = "";
        for (String s : result) {
            if (s.indexOf("backup") == 1) {
                bYes = false;
                return;
            }
            sConcatPathS = sPathS.concat(s);
            sConcatPathD = sPathD.concat(s);
            if (s.substring(s.length() - 1).endsWith("\\")) {
                (new File(sConcatPathD)).mkdir();
                sConcatS = sSour.concat(s);
                sConcatD = sDest.concat(s);

                copyAll(sConcatS, sConcatD);

                System.out.printf("Создано: %s\n", s);
            } else {

                copyFile(sConcatPathS, sConcatPathD);

                System.out.printf("Скопировано: %s\n", s);
            }
            iCount++;
        }
    }

    /**
     * Получение содержимого директория
     * 
     * @param dir
     * @return
     * @throws IOException
     */
    private static List<String> getDir(File dir) throws IOException {
        File fPath = new File(dir.getCanonicalPath());
        List<String> list = new ArrayList<>();

        File[] files = fPath.listFiles();
        if (files == null)
            return list;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                list.add("\\" + files[i].getName() + "\\");
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile())
                list.add("\\" + files[i].getName());
        }
        return list;
    }

    /**
     * Копирование файлов побайтово
     * 
     * @param fileIn
     * @param fileOut
     * @throws IOException
     */
    private static void copyFile(String fileIn, String fileOut) throws IOException {
        // На запись
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {
            int c;
            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn)) {
                while ((c = fileInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
        }
    }
}
