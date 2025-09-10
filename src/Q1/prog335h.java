package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog335h {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Prog127a.dat"));
        System.out.println("P\tQ\tValue");
        while (input.hasNextInt()) {
            int P = input.nextInt();
            int Q = input.nextInt();
            System.out.print(P + "\t" + Q + " ");

            if (P%2 == 0 && Q%2 != 0) {
                System.out.println((2*P + Q));
            }
        }

    }
}
