package Q1.AdventofCode;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class MullItOver {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/Q1/AdventofCode/day3.dat"));
        String st = "";
        while (scanner.hasNextLine()) {
            st += scanner.nextLine();
        }
        boolean name = true;
        System.out.println(st);
        int result = 0;
        for (int lcv =0; lcv<st.length()-4; ++lcv){
            if (lcv >= st.length()) break;
            int jghk = findDont(st, lcv);
            System.out.println(jghk);
            if (st.substring(lcv,lcv+1).equals("m") && name) {
                if(st.substring(lcv+1,lcv+2).equals("u")){
                    if(st.substring(lcv+2,lcv+3).equals("l")){
                        if (st.substring(lcv+3, lcv+4).equals("(")) {
                            int result2 = 0;
                            String temp2 = st.substring(lcv, lcv+4);
                            int lcv2 = lcv + 4;
                            String front = "";
                            String thing = st.substring(lcv2, lcv2+1);
                            
                            
                            while (!thing.equals(")") && (isInteger(thing) || thing.equals(","))) {
                                front += thing;
                                lcv2++;
                                thing = st.substring(lcv2, lcv2+1);
                                
                                
                            }
                            if (!st.substring(lcv2, lcv2+1).equals(")")) front = "";
                            if (front.equals("")) continue;
                            String[] parts = front.split(",");
                            int top = Integer.parseInt(parts[0]);
                            int bottom = Integer.parseInt(parts[1]);
                            result2 = top * bottom;
                            result += result2;
                                                    



                            
                         
                    } 
                } 
            }
        }
        }
        System.out.println(result);
    }
        

    private static boolean isInteger(String thing) {
        return thing.equals("0") || thing.equals("1") || thing.equals("2") || thing.equals("3") || thing.equals("4") || thing.equals("5") || thing.equals("6") || thing.equals("7") || thing.equals("8") || thing.equals("9");
    }
    private static int findDo(String thing, int start) {
        int index = -1;
        for (int i = start; i < thing.length(); i++) {
            String temp = thing.substring(i, i+4);
            if (temp.equals("do()")) { index = i; break; }
        }
        return index;
    }
    private static int findDont(String thing, int start) {
        int index = -1;
        for (int i = start; i < thing.length()-7; i++) {
            String temp = thing.substring(i, i+7);
            if (temp.equals("don't()")) { index = i; }
        }
        return index;
    }
}
                            
