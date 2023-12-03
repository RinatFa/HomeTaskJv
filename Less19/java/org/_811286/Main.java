package org._811286;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 1. Напишите программу, которая использует Stream API 
// для обработки списка чисел. Программа должна вывести 
// на экран среднее значение всех четных чисел в списке.
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.printf(
                "Среднее значение всех четных чисел (Loop) : %.2f\n", loop());

        System.out.printf(
                "Среднее значение всех четных чисел (Stream API) : %.2f\n", streamAPI());
        System.out.println();
    }

    static double streamAPI() {
        return Arrays.asList(1, 2, 3, 4, 8).stream().filter(iNumb -> iNumb % 2 == 0)
                .collect(Collectors.averagingInt(iNumb -> iNumb));
    }

    static double loop() {
        List<Integer> iNumList = Arrays.asList(1, 2, 3, 4, 8);
        System.out.println("Список чисел: " + iNumList.toString());
        double dSum = 0;
        int even = 0;
        double dAverage;
        for (int i = 0; i < iNumList.size(); i++) {
            if (iNumList.get(i) % 2 == 0) {
                dSum += iNumList.get(i);
                even++;
            }
        }
        if (even > 0) {
            dAverage = dSum / even;
        } else {
            dAverage = 0.0;
        }
        return dAverage;
    }
}
