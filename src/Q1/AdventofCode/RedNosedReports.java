package Q1.AdventofCode;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.*;

public class RedNosedReports {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("src/Q1/AdventofCode/day2sample.dat"));
        ArrayList<int[]> arr = new ArrayList<>();

        while (input.hasNextLine()) {
            String[] line = input.nextLine().split(" ");
            int[] arr2 = new int[line.length];
            for (int i = 0; i < line.length; ++i) {
                arr2[i] = Integer.parseInt(line[i]);
            }
            arr.add(arr2);
        }
        int cnt = 0;
        boolean[] flag = new boolean[arr.size()];
        boolean flag2 = true;

        for (int i = 0; i < arr.size(); ++i) {
            while (flag2){
                for (int j = 1; j < arr.get(i).length-1; j+=2) {
                    int[] temp = arr.get(i);
                    int[] temp2 = temp.clone();
                    Arrays.sort(temp2);
                    int[] temp3 = temp.clone();
                    Arrays.sort(temp3,
                            Collections.reverseOrder());
                    int diff = Math.abs(arr.get(i)[j] - temp[j+1]);
                    int diff2 = Math.abs(arr.get(i)[j] - temp[j-1]);
                    if (diff > 3 || diff < 1 || diff2 > 3 || diff2 < 1) {
                        flag2 = false;
                    }
                    if (temp2 != temp) {

                    }

                }
            }
        }

        for (boolean b : flag) {
            if (b){
                cnt++;
            }
        }
        System.out.println(cnt);




    }
}
