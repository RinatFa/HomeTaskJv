class dsList {
    Node head;
    Node tail;

    static class Node {
        int value;
        Node next;
        Node prev;
    }

    public void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if (tail == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.printf("%d ", node.value);
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Задача. Необходимо реализовать метод разворота
     * связного списка.
     * 
     * Метод разворота создан на базе алгоритма
     * сортировки двусвязного списка.
     * Исходный список содержит случайные числа.
     */
    public void reverse() {
        boolean needRev = true;
        Node nodeStop = null;
        do {
            needRev = false;
            Node node = head;
            while (node != nodeStop && node.next != nodeStop) {
                Node before = node.prev;
                Node cur = node;
                Node next = node.next;
                Node after = next.next;

                cur.next = after;
                cur.prev = next;
                next.next = cur;
                next.prev = before;

                if (before != null)
                    before.next = next;
                else
                    head = next;

                if (after != null)
                    after.prev = cur;
                else
                    tail = cur;

                needRev = true;
                if (node.next == nodeStop) {
                    nodeStop = node;
                } else {
                    node = node.next;
                    if (node != null) {
                        node = node.prev;
                    }
                }
            }
        } while (needRev);
    }
}

public class Less03 {
    public static void main(String[] args) {
        dsList list = new dsList();
        for (int i = 1; i <= 10; i++) {
            list.pushBack((int) (Math.random() * 10 + 1));
        }
        list.print();
        list.reverse();
        list.print();
        System.out.println();
    }
}
