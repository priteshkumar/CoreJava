package com.mavixk.jcp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class LowerBoundDemo {
  public static void main(String[] args){
    List<Integer> a = Arrays.asList(1,2,3,4,7);
    List<Integer> b = new ArrayList<>();
    copyData(a,b);
    printElements(b);
    List<String> c = Arrays.asList("jenkins","aws","ansible","docker","kubernetes");
    List<String> d = new ArrayList<>();
    copyData(c,d);
    printElements(d);
  }

  public static void printElements(List<?> list){
    for(Object val: list)
      System.out.print(val + " ");
    System.out.println();
  }

  /**
   * upper bound/lower bound demo for copydata function
   * src uses <? extends T> for data read
   * dst uses <? super T> for data write
   * @param src
   * @param dst
   * @param <T>
   */
  public static <T> void copyData(List<? extends T> src, List<? super T> dst){
    ListIterator<? extends T> listIterator = src.listIterator();
    while(listIterator.hasNext()){
      T val = listIterator.next();
      dst.add(val);
    }
  }
}
