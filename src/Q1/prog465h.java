package Q1;
import java.util.*;
import java.io.*;

public class prog465h{
	
	public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("langdat/prog465h.dat"));
		
		while (sc.hasNextLine()){
            System.out.println("Original Matrix");
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[][] arr = new int[x][y];
			int cnt = 0;
            for (int r = 0; r < arr.length; ++r){
	            for (int c = 0; c < arr[0].length; ++c){
		            arr[r][c] = sc.nextInt();
		            if (arr[r][c] != 0) ++cnt;
	            }
            }
            int[][] arr2 = new int[cnt][3];
            for (int[] r : arr){
	            for (int c : r) { 
                    System.out.print(c+" ");
                }
                System.out.println();
            }       
            if (x*y < 3*cnt) {
	        System.out.println("The Original Matrix is Abundant\n");
            }else{
                int thing = 0;
                for (int r = 0; r < arr.length; ++r){
                    for (int c = 0; c < arr[0].length; ++c){
                        if (arr[r][c] != 0){
                            arr2[thing][0] = r+1;
                            arr2[thing][1] = c+1;
                            arr2[thing][2] = arr[r][c];
                            ++thing;
                        }
                        
                    }
                }
                for (int[] r : arr2){
                    for (int c : r) { 
                        System.out.print(c+" ");
                    }
                    System.out.println();
                }
                if (x*y == 3*cnt)
                    System.out.println("The Original Matrix and the Sparse Matrix are Equally Efficient");
                else System.out.println("The Original Matrix is Sparse\n");
            }
        } 
    }

}
/*
Original Matrix
0 0 7 0 0 0 
0 0 0 0 -8 0 
0 0 0 0 0 0 
2 0 0 0 0 0 
0 0 0 0 0 0 
1 3 7 
2 5 -8 
4 1 2 
The Original Matrix is Sparse

Original Matrix
0 2 0 3 0 1 
8 0 4 0 1 0 
0 3 0 1 0 -7 
5 0 9 0 6 0 
0 2 0 -1 0 7 
The Original Matrix is Abundant

Original Matrix
0 0 1 0 0 2 
3 0 0 4 0 0 
0 0 5 0 0 6 
7 0 0 8 0 0 
0 0 9 0 0 1 
1 3 1 
1 6 2 
2 1 3 
2 4 4 
3 3 5 
3 6 6 
4 1 7 
4 4 8 
5 3 9 
5 6 1 
The Original Matrix and the Sparse Matrix are Equally Efficient
 */
