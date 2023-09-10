package org._811286;

public class EmplArray implements Iterable {
    private Employee[] empl;

    public EmplArray(Employee[] empl) {
        this.empl = empl;
    }

    public String getEmpl() {
        String sStr = "";
        for (int i = 0; i < empl.length; i++) {
            sStr += "\nId= " + this.empl[i].getId() +
                    "   Фамилия= " + this.empl[i].getSurName() +
                    "\tИмя= " + this.empl[i].getName() +
                    "\tСтаж= " + this.empl[i].getExp() + " г/л " +
                    String.format("\tЗарплата= %9.2f (руб.)",
                            this.empl[i].getSalary());
        }
        return sStr;
    }

    @Override
    public String getEmpl2() {
        String sStr = "";
        for (Employee item : empl) {
            sStr += item + "\n";
        }
        return sStr;
    }
}
