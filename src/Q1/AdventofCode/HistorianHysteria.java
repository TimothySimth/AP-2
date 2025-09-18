package Q1.AdventofCode;

import java.io.*;
import java.util.*;

public class HistorianHysteria {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("C:\\Users\\smith.t7\\IdeaProjects\\kgsahip\\src\\Q1\\AdventofCode\\day1.dat"));
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            arr1.add(n);
            arr2.add(m);
        }
        Collections.sort(arr1);
        Collections.sort(arr2);
        int total = 0;
        for (int i =0; i<arr1.size();i++) {
            total += Math.abs(arr1.get(i)-arr2.get(i));
        }
        System.out.println(total);
    }
}
