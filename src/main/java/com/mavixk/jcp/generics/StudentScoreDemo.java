package com.mavixk.jcp.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * here type parameter is self comparable
 * this avoids classcast exception at runtime
 * if passed generic Objects other than type T
 * @param <T>
 */
class StudentScore<T extends Comparable<T>> /*implements Comparable<StudentScore<T>>*/{
  private T left;
  private T right;

  public StudentScore(T left, T right){
    this.left = left;
    this.right = right;
  }

  public int compareTo(StudentScore<T> o2){
    return this.left.compareTo(o2.getLeft());
  }

  public T getLeft() {
    return left;
  }

  public void setLeft(T left) {
    this.left = left;
  }

  public T getRight() {
    return right;
  }

  public void setRight(T right) {
    this.right = right;
  }

  @Override
  public String toString(){
    return "StudentScore( left = " + this.left + ", right = " + this.right + ")";
  }
}

public class StudentScoreDemo{
  public static void main(String[] args){
    StudentScore<Integer> s1 = new StudentScore<>(79,92);
    StudentScore<Integer> s2 = new StudentScore<>(74,71);
    StudentScore<Integer> s3 = new StudentScore<>(73,49);

    System.out.println(s1.compareTo(s2));
    System.out.println(s2.compareTo(s1));
    List<StudentScore<Integer>> studentScoreList = new ArrayList<>();
    studentScoreList.add(s1);
    studentScoreList.add(s2);
    studentScoreList.add(s3);
    /*Collections.sort(studentScoreList); //debug this later
    System.out.println(studentScoreList);*/
  }
}
