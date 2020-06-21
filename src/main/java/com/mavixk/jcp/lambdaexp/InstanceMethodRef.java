package com.mavixk.jcp.lambdaexp;


import java.util.function.Function;

class MyIntOps {

  Integer setBits(Integer val) {
    int count = 0;
    for (int i = 0; i < 31; i++) {
      if ((val & 1) == 1) {
        count++;
      }
      val = val >> 1;
    }
    return count;
  }
}

public class InstanceMethodRef {

  public static Integer IntOp(Function<Integer, Integer> func, Integer val) {
    return func.apply(val);
  }

  public static void main(String[] args) {
    MyIntOps intOps = new MyIntOps();
    //pass instance method as lambda
    System.out.println(IntOp(intOps::setBits,4));
    System.out.println(IntOp(intOps::setBits,7));
    System.out.println(IntOp(intOps::setBits,9));
    System.out.println(IntOp(intOps::setBits,31));
  }
}
