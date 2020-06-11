package com.mavixk.jcp;
import java.util.*;

public class UpperBoundWld {

  //upper bound wildcard
  //works on List<Integer>,List<Double> etc (subclasses of Number)
  public static double uppersumval(List<? extends Number> list){
    double sum = 0;
    for(Number val:list){
      sum += val.doubleValue();
    }
    return sum;
  }

  //unbounded wildcard
  //works on object methods
  //doesnt depend on type parameter
  //list param : can be List<Integer> , List<Double> , etc
  public static int countElem(List<?> list){
    for(Object val:list)
      System.out.print(val + " ");
    System.out.println();
    return list.size() + 10;
  }

  //lower bounded wildcard
  //works on list of integer or list of "super class of integer"
  //list param : can be List<Object> , List<Number> or List<Integer>
  public static void addElem(List<? super Integer> list){
    for(int i=1; i <= 10;i++)
      list.add(i);
  }

  public static void main(String[] args){
    List<Number> a = Arrays.asList(2.2,2.4,3.3);
    countElem(a);
    System.out.println(uppersumval(a));
    List<Integer> b = Arrays.asList(1,3,4,9);
    countElem(b);
    System.out.println(uppersumval(b));
    //List<Integer> c = new ArrayList<>();
    List<Number> c = new ArrayList<>();
    addElem(c);
    countElem(c);
  }
}
