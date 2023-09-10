package org._811286;

import java.util.Comparator;

public class EmployeeExpComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getExp().compareTo(o2.getExp());
        return res;
    }
}
