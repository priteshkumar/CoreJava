package com.mavixk.jcp.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {

  private String name;
  private int age;
  private int score;

  public Student(String name, int age, int score) {
    this.name = name;
    this.age = age;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return "Student(name = " + this.name + ", age = " + this.age + ", score = " +
        this.score + ")";
  }
}

public class ComparatorTest {

  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("mavixk", 29, 94));
    studentList.add(new Student("kasper", 32, 73));
    studentList.add(new Student("mikhail", 31, 79));
    System.out.println(studentList);

    //use generics in comparator
    Collections.sort(studentList, new Comparator<Student>() {
      public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getScore(), o2.getScore());
      }
    });
    System.out.println(studentList);
  }
}
