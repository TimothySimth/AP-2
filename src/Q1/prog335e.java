package Q1;

import java.util.Scanner;

public class prog335e {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; ++i) {
            int num = (int) ((Math.random() * 999) + 1);
            arr[i] = num;
        }
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int index = findNum(arr, n);
        if (index == -1) {
            System.out.println(" DOES NOT EXIST IN THIS ARRAY");
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
/*
92 643 774 311 765 876 479 719 250 395 17 540 501 548 907 514 468 441 380 531 615 78 965 222 158 274 707 220 795 342 95 919 477 863 461 850 510 377 666 695 914 397 305 598 485 30 584 635 459 350 248 241 31 851 634 928 211 519 14 855 711 499 857 692 549 921 569 719 109 164 527 331 224 703 985 901 646 808 499 522 981 446 55 227 726 209 17 159 589 522 343 590 667 96 242 827 365 394 604 809 
790 
 DOES NOT EXIST IN THIS ARRAY
*/