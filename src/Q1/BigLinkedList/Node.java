package Q1.BigLinkedList;


public class Node {
    private int myData;
    public Node myNext;

    public Node(int data) {
        myData = data;
        myNext = null;
    }

    public int getData() {
        return myData;
    }
}