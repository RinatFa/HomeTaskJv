package org._811286;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class MainParadox {

    public static int[] rand(int iNumb) {
        int[] arr = new int[iNumb];
        for (int i = 0; i < iNumb; i++) {
            arr[i] = (int) (Math.random() * (iNumb)) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println();
        int iNumb = 3;
        int iIter = 1000;

        Map mapPlayer1 = new HashMap();
        Map mapPlayer2Change = new HashMap();
        Double rdPlayerWin1 = 0.0;
        Double rdPlayerWin2Change = 0.0;

        int iPlayerWin1 = 0;
        int iPlayerWin2Change = 0;
        double dPlayerWin1 = 0.0;
        double dPlayerWin2Change = 0.0;
        for (int i = 0; i < iIter; i++) {
            int[] arrDoor = rand(iNumb);

            iPlayerWin1 = arrDoor[0];
            if (arrDoor[1] != 1) {
                iPlayerWin2Change = arrDoor[2];
            } else {
                iPlayerWin2Change = arrDoor[1];
            }

            if (iPlayerWin1 == 1) {
                dPlayerWin1 += 1.0;
            }
            if (iPlayerWin2Change == 1) {
                dPlayerWin2Change += 1.0;
            }

            rdPlayerWin1 = Double.valueOf(dPlayerWin1 / (i + 1));
            rdPlayerWin2Change = Double.valueOf(dPlayerWin2Change / (i + 1));
            mapPlayer1.put(i, rdPlayerWin1);
            mapPlayer2Change.put(i, rdPlayerWin2Change);
        }

        for (int i = 0; i < iIter; i++) {
            rdPlayerWin1 = (Double) mapPlayer1.get(i);
            rdPlayerWin2Change = (Double) mapPlayer2Change.get(i);
            dPlayerWin1 = rdPlayerWin1.doubleValue();
            dPlayerWin2Change = rdPlayerWin2Change.doubleValue();
            System.out.println("шаг " + (i + 1) +
                    " победа не меняя дверь = " + dPlayerWin1 +
                    ", победа меняя дверь  " + dPlayerWin2Change);
        }

        rdPlayerWin1 = (Double) mapPlayer1.get(iIter - 1);
        rdPlayerWin2Change = (Double) mapPlayer2Change.get(iIter - 1);
        dPlayerWin1 = rdPlayerWin1.doubleValue();
        dPlayerWin2Change = rdPlayerWin2Change.doubleValue();

        System.out.println();
        System.out.print("Вероятность победы в игре не меняя дверь = ");
        System.out.printf("%.3f\n", dPlayerWin1);
        System.out.print("Вероятность победы в игре меняя дверь = ");
        System.out.printf("%.3f\n", dPlayerWin2Change);
        System.out.println();
    }
}
