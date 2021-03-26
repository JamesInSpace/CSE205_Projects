//**************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// The Main class for Project 2.
// Program designed to calculate tuition for students and output a sorted list of the data

// AUTHOR
// Myron Walters  (mlwalte3@asu.edu)
// Mark Bushong   (mdbushon@asu.edu)
// James Laurita  (jrlaurit@asu.edu)
// Computer Science & Engineering
// School of Computing, Informatics, and Decision Systems Engineering
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//**************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] pArgs) {
        new Main().run();
    }

    public Main() {
    }

    private void run() {
        ArrayList<Student> Students = new ArrayList<>();
        ArrayList<OnlineStudent> onlineStudents = new ArrayList<>();
        ArrayList<OnCampusStudent> onCampusStudents = new ArrayList<>();
        Scanner studentData;

        studentData = getFile("p02-students.txt");
        while (studentData.hasNext()) {
            String studentStatus = studentData.next();
            if (studentStatus.equals("O")) {
               onlineStudents.add(getOnlineStudentsData(studentData));
               studentData.nextLine();
            } else if (studentStatus.equals("C")) {
                onCampusStudents.add(getOnCampusStudentsData(studentData));
                studentData.nextLine();
            } else {
                studentData.nextLine();
                System.out.println("Unable to determine student status.");
            }
        }

        Students.addAll(onlineStudents);
        Students.addAll(onCampusStudents);

        Collections.sort(Students, Comparator.comparing(Student::getId));

        OutputFile("p02-tuition.txt", Students);
    }

    /*
       This method is used to return the file specified
       @param fileName - This is the complete file path
       @return Scanner - We return the contents of the read file
     */
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

    /*
       This method is used to parse through a Scanner (File) of students and create a OnCampusStudent object
       @param studentData - Parameter to accept a scanned file of student
       @return OnCampusStudent - We return a populated OnCampusStudent object
     */
    public OnCampusStudent getOnCampusStudentsData(Scanner studentData) {
        OnCampusStudent onCampusStudent = new OnCampusStudent(studentData.next(), studentData.next(), studentData.next());

        String residence = studentData.next();

        if (residence.equals("R")){
            onCampusStudent.setResident(1);
        } else if (residence.equals("N")){
            onCampusStudent.setResident(2);
        }

        double fee = studentData.nextDouble();

        onCampusStudent.setProgramFee(fee);
        onCampusStudent.setCredits(studentData.nextInt());
        onCampusStudent.calcTuition();

        return onCampusStudent;
    }

    /*
       This method is used to parse through a Scanner (File) of students and create a OnlineStudent object
       @param studentData - Parameter to accept a scanned file of student
       @return OnlineStudent - We return a populated OnlineStudent object
     */
    public OnlineStudent getOnlineStudentsData(Scanner studentData) {
        OnlineStudent onlineStudent = new OnlineStudent(studentData.next(), studentData.next(), studentData.next());

        String techFee = studentData.next();
        onlineStudent.setCredits(studentData.nextInt());

        if (techFee.equals("T")){
            onlineStudent.setTechFee(true);
        }

        onlineStudent.calcTuition();

        return onlineStudent;
    }


    /*
    This method takes the desired file path to create/update the output file and takes an arraylist of students
    and prints the arraylist to the desired output location
    @param pFileName - Parameter to accept the desired filename/location
    @param students - Parameter to accept an ArrayList of type Student object
    @return void - this method will simply create / update the output file with the data from the Student object array
  */
    public static void OutputFile(String pFileName, ArrayList<Student> students) {
        String Id;
        String firstName;
        String lastName;
        double tuition;
        try {
            File outputFile = new File(pFileName);
            PrintWriter output = new PrintWriter(outputFile);
            for (int k = 0; k < students.size(); k++) {
                Id = students.get(k).getId();
                firstName = students.get(k).getFirstName();
                lastName = students.get(k).getLastName();
                tuition = students.get(k).getTuition();
                output.printf("%-15s" ,Id);
                output.printf("%-15s" , firstName);
                output.printf("%-15s" , lastName);
                output.printf("%15s" , tuition);
                output.printf("\n");
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not write to file. Exception below");
            e.printStackTrace();
            System.exit(-200);
        }
    }
}
