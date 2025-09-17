package Q1;
import java.util.*;
import java.io.*;

public class prog470t {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("langdat/prg470t1.dat"));

        int[][] mat = new int[4][4];
        for (int r = 0; r < 4; ++r){
            for (int c = 0; c < 4; c++){
                int thing = sc.nextInt();
                mat[r][c] = thing;
            }
        }
        for (int[] row : mat) {
            for (int col : row) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    public static void doThings(int[][] arr){
        for (int[] r : arr){
            int temp = 0;
            for (int c : r) {
                temp += c;
            }
            
        }
    }
}