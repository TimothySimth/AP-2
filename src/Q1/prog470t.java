package Q1;
import java.util.*;
import java.io.*;

public class prog470t {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("langdat/prg470t2.dat"));

        int[][] mat = new int[4][4];
        for (int r = 0; r < 4; ++r){
            for (int c = 0; c < 4; c++){
                int thing = sc.nextInt();
                mat[r][c] = thing;
            }
        }
        int Diagonal = mat[0][0] + mat[1][1] + mat[2][2] + mat[3][3];
        int Diagonal2 = mat[0][3] + mat[1][2] + mat[2][1] + mat[3][0];
        boolean check = true;
        for (int[] row : mat) {
            int temp = 0;
            for (int col : row) {
                temp += col;
                System.out.print(col+"\t");
            }
            if (temp == Diagonal){ System.out.println(temp); }
            else { check = false; }
        }
        for (int c = 0; c < mat[0].length; ++c){
            int temp = 0;
            for (int r = 0; r < mat.length; ++r){
                temp += mat[r][c];
            }
            if (temp == Diagonal){ System.out.print(temp+"\t"); }
            else { check = false; }
        }
        System.out.println("\n");
        if (Diagonal == Diagonal2 && check) {System.out.printf("Main Diagonal: %d\nOther Diagonal:%d\n\nAbove configuration is a perfect square\n", Diagonal, Diagonal2);}
        else { System.out.println("Above configuration does not form a perfect square");}
    }
}
/*
16      3       2       13      34
5       10      11      8       34
9       6       7       12      34
4       15      14      1       34
34      34      34      34

Main Diagonal: 34
Other Diagonal:34

Above configuration is a perfect square

16      3       2       13      34
5       10      8       11      34
9       6       7       12      34
4       15      14      1       34
34      34

Above configuration does not form a perfect square
*/