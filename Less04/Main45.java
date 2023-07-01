import java.util.Scanner;

/**
 * Задание. Необходимо превратить собранное на семинаре дерево поиска
 * в полноценное левостороннее красно-черное дерево. И реализовать 
 * в нем метод добавления новых элементов с балансировкой.
 * Красно-черное дерево имеет следующие критерии:
 * Каждая нода имеет цвет (красный или черный)
 * Корень дерева всегда черный
 * Новая нода всегда красная
 * Красные ноды могут быть только левым ребенком
 * У краной ноды все дети черного цвета
 */

class BinTree {
    Node root;

    public static boolean RED = false;
    public static boolean BLACK = true;

    static class Node {
        public boolean color = RED;
        int value;
        Node left;
        Node right;
        Node parent;
    }

    public void add44(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            root.color = BLACK;
        }
        Node cur = root;
        root.color = BLACK;
        Node nodeStop = cur;
        Node nodeStopR = cur;
        while (cur != null) {
            if (cur.value == value) {
                break;
            } else {
                nodeStop = cur;
                if (cur.value < value) {
                    cur = cur.right;
                    if (cur == null) {
                        nodeStop.right = newNode;
                        nodeStop.right.color = RED;
                        newNode.parent = nodeStop;
                        if (nodeStop.left != null && nodeStop.right != null) {
                            while (nodeStop.left.color == RED &&
                                    nodeStop.right.color == RED &&
                                    nodeStop.color == BLACK) {
                                flipColors(nodeStop);
                                if (nodeStop.parent == null) {
                                    nodeStop.color = BLACK;
                                } else {
                                    nodeStop = nodeStop.parent;
                                }
                            }
                        }
                        if (nodeStop.right.color == RED) {
                            if (nodeStop.parent == null) {
                                root = rotateLeft(nodeStop);
                            } else {
                                nodeStop.parent.right = rotateLeft(nodeStop);
                            }
                        }
                    }
                } else {
                    cur = cur.left;
                    if (cur == null) {
                        nodeStop.left = newNode;
                        nodeStop.left.color = RED;
                        newNode.parent = nodeStop;
                        nodeStopR = nodeStop.parent;
                        if (nodeStopR != null) {
                            if (nodeStopR.left != null &&
                                    nodeStopR.right != null) {
                                while (nodeStopR.left.color == RED &&
                                        nodeStopR.right.color == RED &&
                                        nodeStopR.color == BLACK) {
                                    flipColors(nodeStopR);
                                    if (nodeStopR.parent == null) {
                                        nodeStopR.color = BLACK;
                                    } else {
                                        nodeStopR = nodeStopR.parent;
                                    }
                                }
                            }
                        }

                        boolean bBool = true;
                        while (bBool == true) {
                            bBool = false;
                            if (nodeStop.color == RED &&
                                    nodeStop.left.color == RED) {
                                if (nodeStopR.parent == null) {
                                    root = rotateRight(nodeStopR);
                                } else {
                                    nodeStop = rotateRight(nodeStopR);
                                }
                            }
                            if (nodeStop != null) {
                                if (nodeStop.left != null &&
                                        nodeStop.right != null) {
                                    while (nodeStop.left.color == RED &&
                                            nodeStop.right.color == RED &&
                                            nodeStop.color == BLACK) {
                                        flipColors(nodeStop);
                                        if (nodeStop.parent == null) {
                                            nodeStop.color = BLACK;
                                        } else {
                                            nodeStop = nodeStop.parent;
                                        }
                                    }
                                }
                            }
                            if (nodeStop != null) {
                                if (nodeStop.color == RED &&
                                        nodeStop.left.color == RED) {
                                    bBool = true;
                                    nodeStopR = nodeStop.parent;
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    public void flipColors(Node node) {
        if (node == null || node.left == null || node.right == null)
            return;
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    private Node rotateRight(Node node) {
        Node nodeX = node.left;
        Node nodeY = node.parent;
        node.left = nodeX.right;
        node.parent = nodeX;
        nodeX.parent = nodeY;
        nodeX.right = node;
        if (nodeY != null) {
            nodeY.left = nodeX;
        }
        nodeX.color = node.color;
        node.color = RED;
        return nodeX;
    }

    private Node rotateLeft(Node node) {
        Node nodeX = node.right;
        Node nodeY = node.parent;
        node.right = nodeX.left;
        node.parent = nodeX;
        nodeX.parent = nodeY;
        nodeX.left = node;
        nodeX.color = node.color;
        node.color = RED;
        return nodeX;
    }

    public boolean gcolor(Node node) {
        return node == null ? BLACK : node.color;
    }

    public String color45(boolean bcolor) {
        if (bcolor == true) {
            return "░░░ b";
        } else {
            return "███ R";
        }
    }

    public void print45() {
        print45(root);
    }

    private void print45(Node node) {
        if (node != null) {
            print45(node.left);
            for (int i = 0; i < depth45(node); i++) {
                System.out.print(" ...");
            }
            System.out.println(" " + color45(node.color) + " " + node.value);
            print45(node.right);
        }
    }

    public int depth45() {
        return depth45(root);
    }

    private int depth45(Node node) {
        if (node != null) {
            int right_depth;
            int left_depth = depth45(node.left);
            right_depth = depth45(node.right);
            int r_d = right_depth;
            int l_d = left_depth;
            return l_d > (r_d) ? l_d + 1 : r_d + 1;
        }
        return 0;
    }
}

public class Main45 {
    public static void main(String[] args) {
        BinTree bitree = new BinTree();

        Scanner iScanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Создание левостороннего красно-чёрного дерева");
        System.out.println(" из 14 (1-15) узлов числами по возрастающей:");
        bitree.add44(1);
        bitree.add44(2);
        bitree.add44(3);
        bitree.add44(4);
        bitree.add44(5);
        bitree.add44(6);
        bitree.add44(7);
        bitree.add44(8);
        bitree.add44(9);
        bitree.add44(10);
        bitree.add44(11);
        bitree.add44(12);
        bitree.add44(13);
        bitree.add44(14);

        bitree.print45();

        System.out.println();
        System.out.println("Создание дерева 15 узлами числами по убывающей:");
        bitree.add44(15);
        bitree.add44(14);
        bitree.add44(13);
        bitree.add44(12);
        bitree.add44(11);
        bitree.add44(10);
        bitree.add44(9);
        bitree.add44(8);
        bitree.add44(7);
        bitree.add44(6);
        bitree.add44(5);
        bitree.add44(4);
        bitree.add44(3);
        bitree.add44(2);
        bitree.add44(1);

        bitree.print45();
        System.out.println();
        iScanner.close();
    }
}
