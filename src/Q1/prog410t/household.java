package Q1.prog410t;

public class household {
    private int myId;
    private int myIncome;
    private int myMembers;
    private double myPoverty;

    public household(int id, int income, int members) {
        myId = id;
        myIncome = income;
        myMembers = members;
        myPoverty = 3750.00 + 750.00 * (myMembers - 2);
    }
    public boolean calc() { return myIncome < myPoverty; }

    public void print() {
        System.out.print(myId + "\t" + myIncome + "\t" + myMembers + "\n");
    }

    public int getId() { return myId; }
    public int getIncome() { return myIncome; }
    public int getMembers() { return myMembers; }
    public void setId(int id) { myId = id; }
    public void setIncome(int income) { myIncome = income; }
    public void setMembers(int members) { myMembers = members; }
    
}
