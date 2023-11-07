package org._811286;

public class Fork {
    private int iNumber;
    private volatile boolean bBusyFree = false;

    public Fork(int iNumber, boolean bFreeBusy) {
        this.iNumber = iNumber;
        this.bBusyFree = bFreeBusy;
    }

    @Override
    public String toString() {
        return iNumber + " " + bBusyFree;
    }

    public int getiNumber() {
        return iNumber;
    }

    public boolean isbBusyFree() {
        return bBusyFree;
    }

    public void setiNumber(int iNumber) {
        this.iNumber = iNumber;
    }

    public void setbBusyFree(boolean bBusyFree) {
        this.bBusyFree = bBusyFree;
    }
}
