package com.mavixk.jcp.algorithms.recursion;

public class TimingTest implements Comparable<TimingTest>{
  int val;
  boolean isEntry;

  public TimingTest(int a,boolean flag){
    this.val = a;
    this.isEntry = flag;
  }

  @Override
  public int compareTo(TimingTest o) {
    return this.val - o.val;
  }
}
