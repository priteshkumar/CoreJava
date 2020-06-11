package com.mavixk.jcp;

public class BoundedGenericMethod {

  //type parameter is bounded by Comparable<T>
  //this allows comparison among with primitive/non primitive types
  public static <T extends Comparable<T>> int findElements(T[] a, T elem){
    int count = 0;
    for(T val: a){
      if(val.compareTo(elem) > 0)
        count++;
    }
    return count;
  }

  public static void main(String[] args){
    Integer[] a = new Integer[]{23,34,21,79,94};
    System.out.println(findElements(a,35));
    String[] b = new String[]{"hello","devops","aws","jenkins"};
    System.out.println(findElements(b,"hello"));
  }
}
