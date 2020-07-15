package com.mavixk.jcp.generics;

import java.util.List;


/**
 * Generic types cannot be used in method overloading
 * because of erasure
 */
public class Overloading {
  public static void print(String param){

  }

  public static void print(Integer param){

  }

  /* this method leads to clash because of erasure
  all generic list types are reduced to List
  public static void print(List<String> param){

  }*/

  public static void print(List<Integer> param){

  }
}
