//**************************************************************************************************
// CLASS: OnlineStudent
//
// DESCRIPTION
// The OnlineStudent class for Project 2.
// Class designed to model an onlineStudent object and extends Student.

// AUTHOR
// Myron Walters  (mlwalte3@asu.edu)
// Mark Bushong   (mdbushon@asu.edu)
// James Laurita  (jrlaurit@asu.edu)
// Computer Science & Engineering
// School of Computing, Informatics, and Decision Systems Engineering
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//**************************************************************************************************

public class OnlineStudent extends Student{
    private boolean mTechFee = false;

    public OnlineStudent(String pId, String pFirstName, String pLastName) {
        super(pId,pFirstName, pLastName);
    }

    public boolean getTechFee() {
        return mTechFee;
    }

    public void setTechFee(boolean techFee) {
        this.mTechFee = techFee;
    }

    /*
        if techFee set True, added ONLINE_TECH_FEE to the totalTuition
        based on getCredits for online students multiplied by ONLINE_CREDIT_RATE
        @param - data from student object
        @return - total tuition owed
     */
    @Override
    public void calcTuition() {
        double totalTuition = 0;
        if (this.mTechFee == true) {
            totalTuition += (TuitionConstants.ONLINE_TECH_FEE);
        }
        totalTuition += this.getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        this.setTuition(totalTuition);

    }

    @Override
    public int compareTo(Student pStudent) {
        return super.compareTo(pStudent);
    }

    /*
        Left for future debugging.
     */
//    @Override
//    public String toString(){
//        return ("ID: " + this.getId() +
//                " FirstName: " + this.getFirstName() +
//                " LastName: " + this.getLastName() +
//                " Tech Fee: " + this.mTechFee +
//                " Credit: " + this.getCredits() +
//                " Tuition: "+ this.getTuition());
//    }
}
