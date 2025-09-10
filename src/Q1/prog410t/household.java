package Q1.prog410t;

public class household {
    private int myId;
    private int myIncome;
    private int myMembers;

    public household(int id, int income, int members) {
        myId = id;
        myIncome = income;
        myMembers = members;
    }

    public int getId() { return myId; }
    public int getIncome() { return myIncome; }
    public int getMembers() { return myMembers; }
    public void setId(int id) { myId = id; }
    public void setIncome(int income) { myIncome = income; }
    public void setMembers(int members) { myMembers = members; }
    
}
