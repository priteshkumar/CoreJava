package com.mavixk.jcp.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class GenericComparator<T> implements Comparator<T> {
  private Comparator<T> delegateComparator;

  public GenericComparator(Comparator<T> delegateComparator){
    this.delegateComparator = delegateComparator;
  }

  //reverse sorting order
  public int compare(T o1, T o2){
    return -1 * this.delegateComparator.compare(o1,o2);
  }
}

class StudentComparator implements Comparator<Student>{
  public int compare(Student o1,Student o2){
    return Integer.compare(o1.getScore(),o2.getScore());
  }
}

public class GenericComparatorTest{
  public static void main(String[] args){
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("mavixk", 29, 94));
    studentList.add(new Student("kasper", 32, 73));
    studentList.add(new Student("mikhail", 31, 79));
    //System.out.println(studentList);
    Collections.sort(studentList,new GenericComparator<>(new StudentComparator()));
    System.out.println(studentList);
  }
}