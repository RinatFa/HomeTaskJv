package org._811286;

// 2. Напишите обобщенный метод compareArrays(), который
// принимает два массива и возвращает true, если они
// одинаковые, и false в противном случае. Массивы могут
// быть любого типа данных, но должны иметь одинаковую длину
// и содержать элементы одного типа.
public class compArr {

    public static <T, P> boolean compareArrays(T[] arr1, P[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] sStr = new String[] { "a", "b", "c", "d", "e" };
        String[] sStr2 = new String[] { "a", "b", "c", "d" };
        Character[] cChar = new Character[] { 'a', 'b', 'c', 'd', 'e' };
        Integer[] iInt = new Integer[] { 1, 2, 3, 4, 5 };
        Double[] dDoub = new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0 };
        System.out.println();
        System.out.println("String_5 VS String_4 = " +
                compareArrays(sStr, sStr2));
        System.out.println("  2 String_5 = " +
                compareArrays(sStr, sStr) + " !");
        System.out.println("String VS Integer = " +
                compareArrays(sStr, iInt));
        System.out.println("Integer VS Double = " +
                compareArrays(iInt, dDoub));
        System.out.println("Character VS String = " +
                compareArrays(cChar, sStr));
        System.out.println();
    }
}
