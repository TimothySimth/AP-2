package Q1.prog285b;

import java.util.*;

public class Prog285bHelper {
    private Node myroot;

    public Prog285bHelper() {
        myroot = null;
    }

    public void addFront(Node spot) {
        if (myroot == null) {
            myroot = spot;
        }
        else {
            spot.myNext = myroot;
            myroot = spot;
        }
    }

    public void addBack(Node spot) {
        if (myroot == null) {
            myroot = spot;
        }
        else {
            Node temp = myroot;
            while (temp.myNext!=null) {
                temp = temp.myNext;
            }
            temp.myNext = spot;
        }
    }

    public void print() {
        Node temp =  myroot;
        while (temp != null) {
            System.out.println(temp.getCom());
            temp = temp.myNext;
        }
    }

    public void calc(){
        Node temp = myroot;
        while (temp != null) {
            Com wow = temp.getCom();
            wow.calc();
            temp = temp.myNext;
        }
    }

    public void delete0(){
        while (myroot != null && myroot.getCom().getCommission() == 0) {
            myroot = myroot.myNext;
        }
        Node prev = myroot;
        Node temp = myroot;
        while (temp != null) {
            if (temp.getCom().getCommission() == 0){
                prev.myNext = temp.myNext;
            } else {
                prev = temp;
            }
            temp = temp.myNext;
        }
    }

    public Iterator<Com> iterator(){
        ArrayList<Com> stuff = new ArrayList<>();
        Node temp = myroot;
        while (temp != null) {
            stuff.add(temp.getCom());
            temp = temp.myNext;
        }
        return stuff.iterator();
    }
}