package com.mavixk.jcp.generics;

public class ArrayCovarianceDemo {
  public static void main(String[] args){
    Object[] a = new Integer[3];
    a[0] = 10;
    a[1] = 20;
    a[2] = "jenkins";//throws ArrayStoreException

  }
}
