package com.mavixk.jcp.lambdaexp.StudentComparator;

/**
 * <p>Comparison based on multiple fields
 *
 * <p>if score is equal ,
 * compare firstname if firstname is equal , compare lastname</p>
 *
 * @author Pritesh Kumar
 */
public class StudentCompSummary {

  public static void main(String[] args) {
    Comparator<Student> cmpStudent =
        Comparator.comparing(Student::getScore).
            thenComparing(Student::getFirstname)
            .thenComparing(Student::getLastname);

    Student s1 = new Student("mavixk", "kasper", 32, 75);
    Student s2 = new Student("mavixk", "jasper", 33, 75);
    System.out.println(cmpStudent.compare(s1, s2));

    //test java.util.Comparator
    testJavaComparator();
  }

  public static void testJavaComparator() {
    Student s1 = new Student("mavixk", "kasper", 32, 75);
    Student s2 = new Student("mavixk", "jasper", 33, 75);
    //single field comparison
    java.util.Comparator<Student> comparator = (p1,p2) -> p1.getAge() - p2.getAge();
    System.out.println(comparator.compare(s1,s2));

    java.util.Comparator<Student> studentComparator =
        java.util.Comparator.comparing(Student::getScore).
            thenComparing(Student::getFirstname)
            .thenComparing(Student::getLastname);
    System.out.println(studentComparator.compare(s1, s2));
  }
}
