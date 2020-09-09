package com.mavixk.jcp.multithreading;

//volatile prevents thread interference
//memory consistency errors can still happen
public class TestVolatile {
  private static volatile int val;

  public static synchronized void setVal(){
    val = val + 1;
  }

  public static synchronized int getVal(){
    return val;
  }

  public static void main(String[] args){
    Runnable r1 = () -> {
      //val = val + 1;
      setVal();
    };

    Runnable r2 = () -> {
      System.out.println(val);
    };

    new Thread(r1).start();
    new Thread(r2).start();
  }
}
