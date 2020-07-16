package com.mavixk.jcp.generics.reflection;

import java.util.ArrayList;
import java.util.List;

public class ReflectionInfo {
  public static void main(String[] args){
    System.out.println(int.class);

    //unbounded wildcard is reifiable type
    List<?> list = new ArrayList<>();
    System.out.println(list.getClass());

    //parametrized types with parameters are non reifiable type
    //because of erasure both have same Class object
    List<String> slist = new ArrayList<>();
    List<Integer> ilist = new ArrayList<>();
    System.out.println(slist.getClass() == ilist.getClass());

    //paramtrized types with bounded wildcards are non reifiable type
    List<? extends Number> nlist = new ArrayList<>();
    System.out.println(nlist.getClass());
  }
}
