package Q1.prog480h;
import java.util.*;
import java.io.*;

public class prog480h{

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("langdat/prog480h.dat"));
        ArrayList<prog480hclass> arr = new ArrayList<>();
        
        int[] ansKey = new int[10];
        while (sc.hasNext()) {
            int id = sc.nextInt();
            int[] ans = new int[10];
        
            for (int lcv = 0; lcv < 10; ++lcv){
                int temp = sc.nextInt();
                if (id == -1){
                    ansKey[lcv] = temp;
                }else {
                    ans[lcv] = temp;
                }
            }
            if (id != -1){
                prog480hclass student = new prog480hclass(ans, id);
                student.grade(ansKey);
                arr.add(student);
            }
        }
        System.out.println("ID\t1 2 3 4 5 6 7 8 9 10 Right Grade");
        System.out.print("Key\t");
        for (int i : ansKey){
            System.out.print(i+" ");
        }
        System.out.println();
        for (prog480hclass i : arr){
            i.print();
        }
        System.out.print("Right\t");
        for (int lcv = 0; lcv < ansKey.length; ++lcv){
            int right = 0;
            for (prog480hclass student : arr){
                int question = student.getAnswer(lcv);
                if (question == ansKey[lcv]){
                    ++right;
                }
            }
            System.out.print(right+" ");
        }
        System.out.println();
                System.out.print("Wrong\t");
        for (int lcv = 0; lcv < ansKey.length; ++lcv){
            int wrong = 0;
            for (prog480hclass student : arr){
                int question = student.getAnswer(lcv);
                if (question != ansKey[lcv]){
                    ++wrong;
                }
            }
            System.out.print(wrong+" ");
        }
        System.out.println();

    }
}
/*
ID      1 2 3 4 5 6 7 8 9 10 Right Grade
Key     0 1 0 0 1 0 0 1 0 1 
180     0 1 1 0 1 0 1 1 0 1   8   C
340     0 1 0 1 0 1 1 1 0 0   5   F
341     0 1 1 0 1 1 1 1 1 1   6   F
401     1 1 0 0 1 0 0 1 1 1   8   C
462     1 1 0 1 1 1 0 0 1 0   4   F
463     1 1 1 1 1 1 1 1 1 1   4   F
464     0 1 0 0 1 0 0 1 0 1   10   F
512     1 0 1 0 1 0 1 0 1 0   3   F
618     1 1 1 0 0 1 1 0 1 0   2   F
619     0 0 0 0 0 0 0 0 0 0   6   F
687     1 0 1 1 0 1 1 0 1 0   0   F
700     0 1 0 0 1 1 0 0 0 1   8   C
712     0 1 0 1 0 1 0 1 0 1   7   C
837     1 0 1 0 1 1 0 1 0 1   6   F
Right   7 10 7 9 9 5 7 8 7 8 
Wrong   7 4 7 5 5 9 7 6 7 6 
*/