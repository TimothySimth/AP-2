package Q1;

import java.util.*;
import java.io.*;

public class prog404a {
    public static void main(String[] args) throws IOException {
        String file1 = "prg404a1.dat";
        String file2 = "prg404a2.dat";
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1 = makeInts(file1);
        arr2 = makeInts(file2);
        System.out.println("Positive\tNegative\nNumber\tNumber");
        thing(arr1);
        System.out.println();
        System.out.println("Positive\tNegative\nNumber\tNumber");
        thing(arr2);



    }
    public static ArrayList<Integer> makeInts(String file) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>(); 
        Scanner input = new Scanner(new File(file));
        while (input.hasNextInt()) {
            int i = input.nextInt();
            arr.add(i);
        }

        return arr;
    }
    public static void thing(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i : arr) {
            if (i > 0) pos.add(i);
            if (i < 0) neg.add(i);
        }
        int poSize  = pos.size();
        int negSize = neg.size(); 
        int max = Math.max(poSize, negSize);
        int min = Math.min(poSize, negSize);
        for (int lcv = 0; lcv < min; ++lcv) 
                System.out.println(pos.get(lcv) + "\t" + neg.get(lcv));
        for (int i = min; i < max; ++i) {
            if (i < poSize) System.out.println(pos.get(i));
            else System.out.println("\t" + neg.get(i));
        }
        
    }
}
/*
Positive        Negative
Number  Number
3       -8
66      -16
54      -56
22      -34
19      -22
21      -55
34      -3
64      -55
55      -76
9       -45
39
54
33

Positive        Negative
Number  Number
8       -3
10      -66
56      -54
34      -22
22      -19
55      -21
3       -34
55      -64
76      -55
45      -9
        -89
        -54
        -3
 */