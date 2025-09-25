package Q1.AdventofCode;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class MullItOver {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/Q1/AdventofCode/day2.dat"));
        String st = "";
        while (sc.hasNext()){
            st += sc.nextLine();
        }
        for (int lcv =0; lcv<st.length(); ++lcv){
            if (st.substring(lcv,lcv+1).equals("m")) {
                
            }
        }
    }
}
