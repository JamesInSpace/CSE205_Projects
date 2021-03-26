//**************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// The Main class for Project 2.
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering
// School of Computing, Informatics, and Decision Systems Engineering
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//**************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] pArgs) {
        new Main().run();
    }

    public Main() {
    }

    private void run() {
        ArrayList<OnlineStudent> onlineStudents = new ArrayList<>();
        ArrayList<OnCampusStudent> onCampusStudents = new ArrayList<>();
        String input = "";
        Scanner studentData;

        studentData = getFile("p02-students.txt");
        while (studentData.hasNext()) {
            String studentStatus = studentData.next();
            if (studentStatus.equals("O")) {
                OnlineStudent onlineStudent = new OnlineStudent(studentData.next(), studentData.next(), studentData.next());
                onlineStudents.add(onlineStudent);
                System.out.println(onlineStudent.toString());
                studentData.nextLine();

            } else if (studentStatus.equals("C")) {
                OnCampusStudent onCampusStudent = new OnCampusStudent(studentData.next(), studentData.next(), studentData.next());
                onCampusStudents.add(onCampusStudent);
                System.out.println(onCampusStudent.toString());
                studentData.nextLine();
            } else {
                studentData.nextLine();
                System.out.println("This is not a online student");
            }
        }
    }

    public Scanner getFile(String fileName) {
        Scanner scanner = new Scanner("");
        try {
            File file = new File(fileName);
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }

    /**
     * Instantiate a Main object and call run() on the object. Note that essentially now, run()
     * becomes the starting point of execution for the program.
     */
    /**
     *  Calls other methods to implement the sw requirements.
     *
     * PSEUDOCODE
     * Declare ArrayList<Student> object named studentList and initialize it to null
     *
     * -- In the try-catch block we try to read the list of students from p02-students.txt
     * -- storing the students in the studentList list. If we cannot open the input file for
     * -- reading, then we output an error message and terminate the program.
     * try
     *     studentList = readFile()
     * catch (FileNotFoundException)
     *     Print "Sorry, could not open 'p02-students.txt' for reading. Stopping."
     *     Call System.exit(-1)
     * end try-catch
     *
     * -- Calculate the tuition for each Student in studentList
     * calcTuition(studentList)
     *
     * -- Sort the students in studentList into ascending order based on student identifier
     * -- Note that Sorter.insertionSort() is a static/class method so we do not have to instantiate
     * -- an object of the Sorter class, we just write class-name.static-method-name() to call a 
     * -- static method in a class.
     * Call Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING) to sort the list
     *
     * -- In the try-catch block we try to write the list of students and their calculated tuitions
     * -- to p02-tuition.txt If we cannot open the output file for writing, then we output an error
     * -- message and terminate the program.
     * try
     *     writeFile(studentList)
     * catch (FileNotFoundException)
     *     Print "Sorry, could not open 'p02-tuition.txt' for writing. Stopping."
     *     Call System.exit(-1)
     * end try-catch
     */


    /**
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object. Note: this is a polymorphic method call. What does that mean?
     * <p>
     * PSEUDOCODE
     * Enhanced ForEach student in pStudentList Do
     * student.calcTuition()
     * End Enhanced ForEach
     */
    private void calcTuition() {

    }

    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as
     * an ArrayList<Student> object. Note that this method throws FileNotFoundException if the
     * input file could not be opened. The exception is caught and handled in run().
     *
     * PSEUDOCODE
     * Declare and create an ArrayList<Student> object named studentList
     * Open "p02-students.txt" for reading using a Scanner object named in
     * While in.hasNext() returns true Do
     *     String studentType <= read next string from in
     *     If studentType is "C" Then
     *         studentList.add(readOnCampusStudent(in))
     *     Else
     *         studentList.add(readOnlineStudent(in))
     *     End If
     * End While
     * Close the scanner
     * Return studentList
     */


    /**
     * Reads the information for an on-campus student from the input file.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
     * Declare String object named res and assign pIn.next() to res
     * Declare double variable named fee and assign pIn.nextDouble() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If res.equals("R") Then
     *    Call setResidency(OnCampusStudent.RESIDENT) on student
     * Else
     *    Call setResidency(OnCampusStudent.NON_RESIDENT) on student
     * End If
     * Call setProgramFee(fee) on student
     * Call setCredits(credits) on student
     * Return student
     */


    /**
     * Reads the information for an online student from the input file.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnlineStudent student. Pass id, fname, lname as params to the ctor.,
     * Declare String object named fee and assign pIn.next() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If fee.equals("T")) Then
     *     Call setTechFee(true) on student
     * Else
     *     Call setTechFee(false) on student
     * End If
     * Call setCredits(credits) on student
     * Return student
     */


    /**
     * Writes the output to "p02-tuition.txt" per the software requirements. Note that this method 
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     *
     * PSEUDOCODE
     * Declare and create a PrintWriter object named out, opening "p02-tuition.txt" for writing
     * Enhanced ForEach student in pStudentList Do
     *     Using out.printf() output the student information per SW Requiremment 3
     * End Enhanced ForEach
     * Close the output file
     */


}
