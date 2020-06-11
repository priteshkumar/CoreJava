package com.mavixk.jcp;

import java.util.*;

public class Subtyping {

  public static int getSum(List<? extends Number> list) {
    int sum = 0;
    for (Number n : list) {
      sum += n.intValue();
    }
    return sum;

  }

  public static void printList(List<? extends Number> list){
    for(Number n:list)
      System.out.print(n + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(1, 2, 3, 7);
    printList(a);
    //List<Number> b = a; gives compilation error
    //List<Number> != List<Integer> in generics
    //use upperbound wildcard
    List<? extends Number> b = a;
    System.out.println(getSum(b));

    List<Integer> c = new ArrayList<>();
    c.add(3);
    c.add(4);
    List<? extends Number> d = c;
    //below will result in compile error
    //upper bound wildcard cannot be used to add/change elements in list

    //d.add(new Integer(74));

    //lower bound works for element addition/change
    List<? super Integer> e = c;
    e.add(10);

    d = c;
    System.out.println(getSum(d));
  }
}
