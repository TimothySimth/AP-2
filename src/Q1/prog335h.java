package Q1;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class prog335h {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Prog127a.dat"));
        System.out.println("P\tQ\tValue");
        while (input.hasNextInt()) {
            int P = input.nextInt();
            int Q = input.nextInt();
            System.out.print(P + "\t" + Q + "\t");

            if (P%2 == 0 && Q%2 != 0) {
                System.out.println((2*P + Q));
            } else if (P%2 != 0 && Q%2 == 0){
                System.out.println((P + 2*Q));
            } else if (P == Q && P%2 == 0) {
                System.out.println((3*P));
            } else if (P == Q && P%2 != 0){
                System.out.println((3*Q));
            } else {System.out.println((P + Q));}
        }

    }
}
/*
P       Q       Value
2       5       9
4       4       12
6       2       8
1       3       4
5       5       15
1       2       5
*/