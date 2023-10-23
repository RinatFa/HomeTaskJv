package org._811286;

public class MainPair {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>(
                "fifteen", 15);
        System.out.println();
        System.out.println("first = " + pair.getFirst());
        System.out.println("second = " + pair.getSecond());
        System.out.println(pair.toString());
        System.out.println();
    }
}
