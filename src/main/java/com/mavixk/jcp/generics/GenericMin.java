package com.mavixk.jcp.generics;

import com.mavixk.jcp.lambdaexp.StudentComparator.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

class StudentV1{
  private int score;
  private int age;
  public StudentV1(int score,int age){
    this.score = score;
    this.age = age;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

public class GenericMin {
  public static void main(String[] args){
    List<Integer> list = Arrays.asList(23, 34, 12, 89, 76);
    System.out.println(min(list,new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2){
        return o1 - o2;
      }
    }));
  }

  public static <T> T min(List<T> list, Comparator<T> comparator){

    T lowestElement = list.get(0);
    ListIterator<T> listIterator = list.listIterator();
    listIterator.next();
    while(listIterator.hasNext()){
      T val = listIterator.next();
      if(comparator.compare(val,lowestElement) < 0)
        lowestElement = val;
    }
    return lowestElement;
  }
}
