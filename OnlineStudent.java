public class OnlineStudent extends Student{
    private boolean mTechFee;

    public OnlineStudent(String pId, String pFirstName, String pLastName, boolean mTechFee) {
        super(pId, pFirstName, pLastName);
        this.mTechFee = mTechFee;
    }

    @Override
    public void calcTuition() {
        super.calcTuition();
    }

    @Override
    public int compareTo(Student pStudent) {
        return super.compareTo(pStudent);
    }
}
