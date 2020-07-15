package com.mavixk.jcp.generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcardDemo {
  public static void main(String[] args){
    Object[] a = new StudentV1[3];
    a[0] = new StudentV1(34,31);
    a[1] = new StudentV1(43,30);

    //generates runtime exception ArrayStoreException
    try {
      a[2] = new Object(); //unsafe array type store
      for (Object val : a)
        System.out.println(val);
    } catch(ArrayStoreException e){
      System.out.println("arraystore exception");
      e.printStackTrace();
    }

    List<?> alist = new ArrayList<>();
    //alist.add(new Object()); any Object or subclass of Object cannot be stored here
    alist.add(null); //null add is allowed as it can coerced to any type
  }
}
