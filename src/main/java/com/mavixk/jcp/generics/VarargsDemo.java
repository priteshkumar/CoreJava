package com.mavixk.jcp.generics;

import java.util.Arrays;

public class VarargsDemo {
  public static void main(String[] args){
    Object[] a = pair("jenkins");
    System.out.println(Arrays.toString(a));
    try {
      Integer[] b = pair(20);
      System.out.println(Arrays.toString(b));
    }catch(ClassCastException e){
      e.printStackTrace();
    }
  }

  public static <T> T[] pair(T t){
    return arrayOf(t,t);
  }

  @SafeVarargs
  public static <T> T[] arrayOf(T ... values){
    return values;
  }
}
