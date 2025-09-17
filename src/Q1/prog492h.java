package Q1;
import java.util.*;
import java.io.*;

public class prog492h {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("langdat/prog492h.dat"));

        String[][] mat = new String[30][30];
        int r = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] stuff = line.split("");
            mat[r] = stuff;
            r++;
        }
        for (String[] row : mat) {
            for (String col : row) {
                System.out.print(col+" ");
            }
            System.out.println();
        }

        String[][] mat2 = new String[30][30];

        for (r = 0; r < 30; r++) {
            int cnt=0;
            for (int c = 0; c < 30; c++) {
                //1
                if (r>=1) {
                    String ch = mat[r-1][c];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
                //2
                if (r >= 1 && c <= mat[0].length-2) {
                    String ch = mat[r-1][c+1];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
                //3
                if ( c <= mat[0].length-2) {
                    String ch = mat[r][c+1];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
                //4
                if (r <= mat.length-2 && c <= mat[0].length-2) {
                    String ch = mat[r+1][c+1];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
                //5
                if (r <= mat.length-2) {
                    String ch = mat[r+1][c];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
                //6
                if (r <= 2 && c <= mat[0].length-2) {
                    String ch = mat[r+1][c-1];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
                //7
                if (r >= 2) {
                    String ch = mat[r][c-1];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
                //8
                if (r >= 2 && c >= 2) {
                    String ch = mat[r-1][c-1];
                    if (ch.equals("*")) {
                        cnt++;
                    }
                }
            }
        }

    }
}
