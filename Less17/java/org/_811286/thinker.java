package org._811286;

public class thinker implements Runnable {
    private String name;
    private fork lfork;
    private fork rfork;
    private int iNumbEat;
    private boolean bEating = false;

    public thinker(String name, fork lfork, fork rFork, int iNumbEat, boolean bEating) {
        this.name = name;
        this.lfork = lfork;
        this.rfork = rFork;
        this.iNumbEat = iNumbEat;
        this.bEating = bEating;
    }

    @Override
    public void run() {
        boolean bStop = false;
        while (!bStop) {
            if (!lfork.isbBusyFree() && !rfork.isbBusyFree()) {
                lfork.setbBusyFree(true);
                rfork.setbBusyFree(true);
                bEating = true;
                System.out.println(this.toString());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lfork.setbBusyFree(false);
                rfork.setbBusyFree(false);
                bEating = false;
                iNumbEat++;
                if (iNumbEat > 2) {
                    bStop = true;
                }
                System.out.println(this.toString());
            } else {
                System.out.println(this.toString());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("***** Мыслитель " + name + " поел 3 раза! *****");
        main5Thinkers.count++;
        if (main5Thinkers.count == 5) {
            System.out.println();
            System.out.println("***** Каждый из 5 Мыслителей поел три раза! *****");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String sLeft, sRight, sEating;
        if (lfork.isbBusyFree()) {
            sLeft = " занята";
        } else {
            sLeft = " своб. ";
        }
        if (rfork.isbBusyFree()) {
            sRight = " занята";
        } else {
            sRight = " своб. ";
        }
        if (bEating) {
            sEating = "Ест   ";
        } else {
            sEating = "Мыслит";
        }
        return "Мыслитель " + name +
                " - сейчас " + sEating +
                " , уже поел " + iNumbEat + " раза" +
                ", вилки: левая " + lfork.getiNumber() + sLeft +
                ", правая " + rfork.getiNumber() + sRight;
    }
}
