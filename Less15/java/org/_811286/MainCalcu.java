package org._811286;

public class MainCalcu {
        public static void main(String[] args) {
                System.out.println();
                System.out.println("3.0 + 2.0 = " +
                                Calcu.sum(3.0, 2.0));
                System.out.println("3 - 2.0 = " +
                                Calcu.subtract(3, 2.0));
                System.out.println("3.0 * 2.0f = " +
                                Calcu.multiply(3.0, 2.0f));
                System.out.println("3.0f / 2 = " +
                                Calcu.divide(3.0f, 2));
                System.out.println();
        }
}
