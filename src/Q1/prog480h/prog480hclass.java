package Q1.prog480h;

public class prog480hclass{
    private int[] ans;
    private int Id;
    private int outOfTen;
    private String Grade;
    public prog480hclass(int[] a, int b) {
        ans = a;
        Id = b;
        outOfTen = 0;
        Grade = null;
    }

    public void grade(int[] arr){
        int cnt = 0;
        for (int lcv = 0; lcv < arr.length; ++lcv){
            if (ans[lcv] == arr[lcv]){
                ++cnt;
            }
        }
        outOfTen = cnt;
        if (10 - cnt == 0 || 10 - cnt == 1){
            Grade = "A";
        }
        if (10 - cnt == 2 || 10 - cnt == 3){
            Grade = "C";
        }
        else Grade = "F";
    }

    public void print(){
        System.out.print(Id+"\t");
        for (int i : ans){
            System.out.print(i+" ");
        }
        System.out.println("  " + outOfTen + "   " + Grade);
    }

    public int getAnswer(int index){ return ans[index]; }
}