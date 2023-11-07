package org._811286;

public class Thinker implements Runnable {
    private String name;
    private Fork lfork;
    private Fork rfork;
    private int iNumbEat;
    private volatile boolean bEating = false;

    public Thinker(String name, Fork lfork, Fork rFork, int iNumbEat, boolean bEating) {
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
            if (!lfork.isbBusyFree() && !rfork.isbBusyFree() && Main5Thinkers.countFork < 4) {
                lfork.setbBusyFree(true);
                rfork.setbBusyFree(true);
                Main5Thinkers.countFork += 2;
                bEating = true;
                System.out.println(this.toString() + " начал есть");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lfork.setbBusyFree(false);
                rfork.setbBusyFree(false);
                Main5Thinkers.countFork -= 2;
                bEating = false;
                iNumbEat++;
                if (iNumbEat > 2) {
                    bStop = true;
                }
                System.out.println(this.toString());
            } else {
                System.out.println(this.toString());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("***** Мыслитель " + name + " поел 3 раза! *****");
        Main5Thinkers.count++;
        if (Main5Thinkers.count == 5) {
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
        String[] sArray = new String[] { "", "_", "_", "_", "_", "_" };
        sArray[lfork.getiNumber()] = Integer.toString(lfork.getiNumber());
        sArray[rfork.getiNumber()] = Integer.toString(rfork.getiNumber());
        return "Мыслитель " + name +
                " - сейчас " + sEating +
                " , уже поел " + iNumbEat + " раза" +
                ", вилки: левая " + lfork.getiNumber() + sLeft +
                ", правая " + rfork.getiNumber() + sRight +
                " " + String.join("", sArray) +
                " " + Main5Thinkers.countFork;
    }
}
