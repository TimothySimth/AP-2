package Q1.prog410t;

import java.util.*;
import java.io.*;

public class prog410t {
    public static void main(String[] args) throws IOException {
        ArrayList<household> houses = new ArrayList<>();
        Scanner input = new Scanner(new File("langdat/survey2.dat"));
        while (input.hasNext()){
            int id = input.nextInt();
            int income = input.nextInt();
            int members = input.nextInt();
            household house = new household(id, income, members);
            houses.add(house);
        }
        System.out.println("Id\t\tIncome\tMembers");
        for (household house : houses) {
            house.print();
        }

        double avrIncome = 0.0;
        for (int lcv = 0; lcv < houses.size(); ++lcv) {
            avrIncome += houses.get(lcv).getIncome();
        }
        avrIncome /= houses.size();
        System.out.println();
        System.out.println("Households with income exceeding an \naverage income of " + avrIncome);
        System.out.println("Id\t\tIncome\tMembers");

        ArrayList<household> houses2 = new ArrayList<>();
        for (household house : houses) {
            if (house.getIncome() > avrIncome) {
                houses2.add(house);
            }
        }
        for (household house : houses2) {
            house.print();
        }
        double num = 0.0;
        System.out.println();
        System.out.println("Percent of households below poverty level =");
        for (household house : houses) {
            if (house.calc()) { ++num;}
        }
        System.out.println(num/houses.size());

    }
}
/*
Id		Income	Members
1041	12180	4
1062	13240	3
1327	19800	2
1483	22458	8
1900	17000	2
2112	18125	7
2345	15623	2
3210	3200	6
3600	6500	5
3601	11970	2
4725	8900	3
6217	10000	2
9280	6200	1

Households with income exceeding an
average income of 12707.384615384615
Id		Income	Members
1062	13240	3
1327	19800	2
1483	22458	8
1900	17000	2
2112	18125	7
2345	15623	2

Percent of households below poverty level =
0.07692307692307693

*/