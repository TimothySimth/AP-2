package Q1.AdventofCode;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class RedNosedReports {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("src/Q1/AdventofCode/day2.dat"));
        int cnt = 0;
        while (input.hasNextInt()) {
            String[] line = input.nextLine().split(" ");
            ArrayList<Integer> arr2 = new ArrayList<>();
            for (int i = 0; i < line.length; ++i) {
                arr2.add(Integer.parseInt(line[i]));
            }
            for (int i : arr2){
                System.out.print(i+" ");
            }
            System.out.println();
            
            // is positive
            boolean oneBad = true;
            int[] check = new int[arr2.size()-1];
            int temp = arr2.get(0);
            for (int lcv= 1; lcv < check.length; ++lcv){
                int temp2 = arr2.get(lcv);
                if ((temp2 < temp || oneBad) && !(temp2 > temp)){
                    if (temp2 >= temp) {
                        System.out.println("Right");
                        arr2.remove(lcv);
                        int[] check2 = new int[check.length-1];
                        check2[0] = check[0];
                        for (int j = 1; j < check.length;++j){
                            check2[j-1] = check[j];
                        }
                        check = check2;
                        oneBad = false;

                    }
                    check[lcv-1] = -1; 
                }
                if ((temp2 > temp || oneBad)  && !(temp2 < temp)){ 
                    if (temp2 <= temp) {
                        System.out.println("Left");
                        arr2.remove(lcv);
                        int[] check2 = new int[check.length-1];
                        check2[0] = check[0];
                        for (int j = 1; j < check.length;++j){
                            check2[j-1] = check[j];
                        }
                        check = check2;
                        oneBad = false;

                    }
                    check[lcv-1] =  1; 
                }
                temp = temp2;
            }
            for (int i : arr2){
                System.out.print(i+" ");
            }
            System.out.println();

            boolean safe = true;
            temp = check[0];
            System.out.print("  " + temp+"  ");
            for (int i = 1; i < check.length; ++i){
                System.out.print(check[i]+"  ");
                int temp2 = check[i];
                if (temp != temp2){
                    if (oneBad){
                        arr2.remove(i+1);
                        int[] check2 = new int[check.length-1];
                        check2[0] = check[0];
                        for (int j = 1; j < check.length;++j){
                            check2[j-1] = check[j];
                        }
                        check = check2;
                        oneBad = false;

                    }else
                        safe = false;
                }
                temp = check[i-1];
            }
            System.out.println(safe);
            for (int i : arr2){
                System.out.print(i+" ");
            }
            System.out.println();

            int diff = 0; 
            int diff2 = 0;
            for (int i = 1; i<arr2.size()-1; ++i){
                
            }
            
            for (int i = 1; i<arr2.size()-1; ++i){
                diff = Math.abs(arr2.get(i-1) - arr2.get(i)); 
                diff2 = Math.abs(arr2.get(i+1) - arr2.get(i));
                System.out.println(diff + " " + diff2);
                if (safe){
                    if (oneBad && !(diff > 0 && diff < 4 && diff2 > 0 && diff2 < 4)){
                        arr2.remove(i);
                        int[] check2 = new int[check.length-1];
                        check2[0] = check[0];
                        for (int j = 1; j < check.length;++j){
                            check2[j-1] = check[j];
                        }
                        check = check2;
                        oneBad = false;
                    }
                    if (diff > 0 && diff < 4 && diff2 > 0 && diff2 < 4){

                        if (i == arr2.size()-2){
                            cnt++;
                            System.out.println(cnt);
                        }
                            
                    }
                    
                    
                    else break;
                    
                }
            }
            System.out.println();

        }
        System.out.println(cnt);
    }
}
