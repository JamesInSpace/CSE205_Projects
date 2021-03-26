//**************************************************************************************************
// CLASS: OnCampusStudent
//
// DESCRIPTION
// The OnCampusStudent class for Project 2.
// Class designed to model an onCampusStudent object and extends Student.

// AUTHOR
// Myron Walters  (mlwalte3@asu.edu)
// Mark Bushong   (mdbushon@asu.edu)
// James Laurita  (jrlaurit@asu.edu)
// Computer Science & Engineering
// School of Computing, Informatics, and Decision Systems Engineering
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//**************************************************************************************************

public class OnCampusStudent extends Student{
   final int RESIDENT = 1;
   final int NON_RESIDENT = 2;
   private int mResident;
   private double mProgramFee;

    public OnCampusStudent(String pId, String pFirstName, String pLastName) {
        super(pId, pFirstName, pLastName);
    }

    /*
        totalTuition based off RESIDENT or NON_RESIDENT final variables
        if credits were grater then ONCAMP_MAX_CREDITS, the addon credit amount was added.
        @param - data from student object
        @return - total tuition owed
     */
    @Override
    public void calcTuition() {
        double totalTuition = 0;
        if (mResident == RESIDENT){
            totalTuition += TuitionConstants.ONCAMP_RES_BASE;
        } else if (mResident == NON_RESIDENT){
            totalTuition += TuitionConstants.ONCAMP_NONRES_BASE;
        }
        if (this.getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS){
            totalTuition += (this.getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
        }

        totalTuition += mProgramFee;
        this.setTuition(totalTuition);
    }

    public int getResident(){
        return this.mResident;
    }

    public void setResident(int mResident){
        this.mResident = mResident;
    }

    public double getmProgramFee() {
        return this.mProgramFee;
    }

    public void setProgramFee(double mProgramFee) {
        this.mProgramFee = mProgramFee;
    }

    /*
        Left for future debugging.
     */
//    @Override
//    public String toString(){
//        return ("ID: " + this.getId() +
//                " FirstName: " + this.getFirstName() +
//                " LastName: " + this.getLastName() +
//                " Resident: " + this.mResident +
//                " Program Fee: " + this.mProgramFee +
//                " Credit: " + this.getCredits() +
//                " Tuition: " + this.getTuition());
//    }

}
