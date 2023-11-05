package org._811286;

public class fork {
    private int iNumber;
    private boolean bBusyFree = false;

    public fork(int iNumber, boolean bFreeBusy) {
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
