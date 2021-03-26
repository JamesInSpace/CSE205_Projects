public class OnlineStudent extends Student{
    private boolean mTechFee;

    public OnlineStudent(String pId, String pFirstName, String pLastName) {
        super(pId,pFirstName, pLastName);
    }

    public boolean getTechFee() {
        return mTechFee;
    }

    public void setTechFee(boolean techFee) {
        this.mTechFee = techFee;
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
