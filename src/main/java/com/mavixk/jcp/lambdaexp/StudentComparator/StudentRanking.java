package com.mavixk.jcp.lambdaexp.StudentComparator;

import java.util.ArrayList;
import java.util.function.Supplier;

public class StudentRanking {

  private static ArrayList<Student> students;

  private static Supplier<Student> stGen = () -> {
    int LEN = 4;
    String fname = "";
    String lname = "";
    int age = -1;
    int score = -1;
    for (int i = 0; i < LEN; i++) {
      int val1 = (int) (Math.random() * 10 + 65);
      int val2 = (int) (Math.random() * 10 + 97);
      fname = fname + String.valueOf((char) val1);
      lname = lname + String.valueOf((char) val2);
    }
    age = (int) (Math.random() * 100);
    score = (int) (Math.random() * 100);
    return new Student(fname, lname, age, score);
  };

  static {
    students = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      students.add(stGen.get());
    }
  }

  public static void main(String[] args) {
    demoBasicComparators();
    demoComparing();
    demoChaining();
  }

  public static void demoComparing() {
    Comparator<Student> cmpAge = Comparator.comparing(Student::getAge);
    Comparator<Student> cmpfName = Comparator.comparing(Student::getFirstname);
    System.out.println(cmpAge.compare(students.get(0), students.get(1)));
  }

  /**
   * multiple comparison steps first scores are compared , if equal firstnames are compared
   *
   * @param
   * @return
   * @author Pritesh
   */
  public static void demoChaining() {
    Comparator<Student> cmpScore = Comparator.comparing(Student::getScore);
    Comparator<Student> cmpfName = Comparator.comparing(Student::getFirstname);
    Comparator<Student> cmplName = Comparator.comparing(Student::getLastname);

    //add score + firstname comparison
    Comparator<Student> cmpStudent = cmpScore.thenComparing(cmpfName);

    Student s1 = new Student("mavixk", "kasper", 32, 75);
    Student s2 = new Student("avixk", "jasper", 33, 70);
    System.out.println(cmpStudent.compare(s1, s2));

    //add last name comparison too
    Comparator<Student> cmpStudentAll = cmpStudent.thenComparing(cmplName);
    s2.setScore(75);
    s2.setFirstname("mavixk");
    System.out.println(cmpStudentAll.compare(s1, s2));
  }

  public static void demoBasicComparators() {
    Comparator<Student> cmpAge = (p1, p2) -> p1.getAge() - p2.getAge();
    Comparator<Student> cmpFirstname = (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname());
    Comparator<Student> cmpLastname = (p1, p2) -> p1.getFirstname().compareTo(p2.getLastname());
    Comparator<Student> cmpScore = (p1, p2) -> p1.getScore() - p2.getScore();
    //System.out.println(students);
    System.out.println(cmpAge.compare(students.get(0), students.get(1)));
    System.out.println(cmpFirstname.compare(students.get(0), students.get(1)));
  }
}
