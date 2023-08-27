package edu.mum.cs.cs425.demos;

import edu.mum.cs.cs425.demos.model.Student;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) throws Exception {


        MyStudentRecordsMgmtApp myStudentRecordsMgmtApp = new MyStudentRecordsMgmtApp();
        myStudentRecordsMgmtApp.bootstrap();


    }


    public void bootstrap() throws Exception {

        List<Student> students = List.of(


                new Student(110001, "Dave", LocalDate.of(1951, 11, 18)),
                new Student(110002, "Anna", LocalDate.of(1990, 12, 7)),
                new Student(110003, "Erica", LocalDate.of(1974, 1, 31)),
                new Student(110004, "Carlos", LocalDate.of(2009, 8, 22)),
                new Student(110005, "Bob", LocalDate.of(1990, 3, 5))
        );

        printListOfStudents(new ArrayList<>(students));
        getListOfPlatinumAlumniStudents(new ArrayList<>(students));


        printHelloWorld(new int[]{35, 34, 25, 42});


        findSecondBiggest(new int[]{1, 2, 3, 4, 5});
    }


    public void printHelloWorld(int[] arr) {
        System.out.println("\nPrint Hello World:");
        System.out.println("______________________________________________________________");


        for (int i : arr) {
            if (i % 5 == 0 && i % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (i % 5 == 0) {
                System.out.println("Hello");
            } else if (i % 7 == 0) {
                System.out.println("World");
            } else
                System.out.println();
        }

    }


    public void findSecondBiggest(int[] data) throws Exception {
        System.out.println("\nPrint Second Largest:");
        System.out.println("______________________________________________________________");


        if (data.length < 2) {
            throw new Exception("Array does not have second biggest number");
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : data) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new Exception("Array does not have second biggest number");
        }

        System.out.println("=-====second largetst" + secondLargest);
    }

    public void printListOfStudents(List<Student> studentList) {
        studentList.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("List of all students:");
        System.out.println("______________________________________________________________");
        studentList.forEach(System.out::println);
    }

    public void getListOfPlatinumAlumniStudents(List<Student> students) {
        System.out.println("\nList of platinum students:");
        System.out.println("______________________________________________________________");
        for (Student s : students) {
            Period period = Period.between(s.getDateOfAdmission(), LocalDate.now());
            int noOfYears = period.getYears();
            if (noOfYears > 29) {
                System.out.println(s);
            }
        }
    }


}