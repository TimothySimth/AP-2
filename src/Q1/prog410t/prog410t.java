package Q1.prog410t;

import java.util.*;
import java.io.*;

public class prog410t {
    public static void main(String[] args) throws IOException {
        ArrayList<household> houses = new ArrayList<>();
        Scanner input = new Scanner(new File("prog285b.txt"));
        while (input.hasNext()){
            int id = input.nextInt();
            int income = input.nextInt();
            int members = input.nextInt();
            household house = new household(id, income, members);
            houses.add(house);
        }
    }
}
