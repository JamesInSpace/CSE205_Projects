public class OnCampusStudent extends Student{
   final int RESIDENT = 1;
   final int NON_RESIDENT = 2;
   private int mResident;
   private double mProgramFee;

    public OnCampusStudent(String pId, String pFirstName, String pLastName, int mResident, double mProgramFee) {
        super(pId, pFirstName, pLastName);
        this.mResident = mResident;
        this.mProgramFee = mProgramFee;
    }

    @Override
    public void calcTuition() {
        super.calcTuition();
    }

}
