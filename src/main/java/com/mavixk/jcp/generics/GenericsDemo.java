package com.mavixk.jcp.generics;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class GenericsDemo {
  public static void main(String[] args) {
    Integer[] a = {3, 4, 7, 9, 6};
    swap(a,2,4);
    System.out.println(a.toString());
    for(int val:a)
      System.out.println(val + " ");
    System.out.println();
    List<Integer> list = Arrays.asList(a);
    System.out.println(max(list));
    List<Double> list2 = Arrays.asList(10.34,12.35,9.45,7.21);
    System.out.println(max(list2));
  //  List<Number> list3 = Arrays.asList(32,23,21,39);
    //System.out.println(max(list3));
    testPredicate();
  }

  public static <T extends Comparable<T>> void swap(T[] a, int i,int j){
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static <T extends Comparable<? super T>> T max(List<? extends T> list){
    T maxElement = list.get(0);
    ListIterator<? extends T> listIterator = list.listIterator();
    listIterator.next();
    while(listIterator.hasNext()){
      T val = listIterator.next();
      if(val.compareTo(maxElement) > 0)
        maxElement = val;
    }
    return maxElement;
  }

  public static void testPredicate(){
    Predicate<Integer> testp = (n) -> n % 2 == 0;
    System.out.println(testp.test(20));
  }
}


