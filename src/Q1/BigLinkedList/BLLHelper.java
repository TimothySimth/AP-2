package Q1.BigLinkedList;

import Q1.prog285b.Node;

public class BLLHelper {
    private Node myroot;

    public BLLHelper(Node root) { myroot = root; }

    public void addFront(int value) {
        add(value, 0);
    }

    public void addBack(int value) {

    }

    public void print() {
        Node temp =  myroot;
        while (temp != null) {
            System.out.println(temp.getCom());
            temp = temp.myNext;
        }
    }

    public int getCount() {
        int count = 0;
        Node temp = myroot;
        while (temp != null) {
            count++;
            temp = temp.myNext;
        }
        return count;
    }

    public void add(int value, int index) {

    }

}
