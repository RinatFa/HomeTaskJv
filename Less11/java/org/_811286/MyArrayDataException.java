package org._811286;

class MyArrayDataException extends Exception {
    String message;

    public MyArrayDataException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "2. " + message + " лежит символ или текст вместо числа!";
    }
}
