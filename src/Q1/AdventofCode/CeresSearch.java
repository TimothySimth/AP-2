package Q1.AdventofCode;

import java.util.ArrayList;
import java.util.Scanner;

public class CeresSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner("src/Q1/AdventofCode/day4.dat");
        ArrayList<String> list = new ArrayList<>();
        while (input.hasNext()) {
            list.add(input.next());
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
