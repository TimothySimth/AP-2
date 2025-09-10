package Q1;

import java.util.Scanner;

public class prog335e {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; ++i) {
            int num = (int) ((Math.random() * 999) + 1);
            arr[i] = num;
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int index = findNum(arr, n);
        if (index == -1) {
            System.out.print(" DOES NOT EXIST IN THIS ARRAY");
        }
        else {
            System.out.println(" IS LOCATED IN POSITION " + index);
        }
    }
    public static int findNum(int[] arr, int num){
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == num) { return i; }
        }
        return -1;
    }

}
