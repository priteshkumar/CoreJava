package com.mavixk.jcp.lambdaexp.pls.misc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapFilterDemo {
  public static void main(String[] args){
    List<Integer> alist = new ArrayList<>();
    alist.add(10);
    alist.add(20);
    alist.add(30);
    List<Integer> blist = alist.stream().map(val -> val * val).collect(Collectors.toList());
    alist.forEach(System.out::println);
    blist.forEach(System.out::println);
  }
}
