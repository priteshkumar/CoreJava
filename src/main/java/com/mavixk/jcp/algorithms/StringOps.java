package com.mavixk.jcp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringOps {
  public static void main(String[] args){
    StringBuffer sb = new StringBuffer();
    sb.append("hello world");
    String s = "val";
    System.out.println(s.contains("vl"));
    //StringBuilder s = new StringBuilder("test");
    System.out.println(s.toString());
    System.out.println(sb.substring(0,5));
    System.out.println(sb.length());
    System.out.println(sb.capacity());

    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    list.add("xanxong");
    list.add("motor");
    Collections.sort(list);
    System.out.println(list);

    System.out.println("hello".getClass().getSimpleName());
    System.out.println("String" == "String");
    if("hello" instanceof String)
      System.out.println("true");

    System.out.println(new Integer(2).getClass().getSimpleName() == "Integer");
      System.out.println("is integer");

      String[] p = {"abc","2","10"};
      List<String> plist = Arrays.asList(p);
      Collections.sort(plist);
      System.out.println(plist);
      for(String val:p)
        System.out.print(val + " ");

  }

}
