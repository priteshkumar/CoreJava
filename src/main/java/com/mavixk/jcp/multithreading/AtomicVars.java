package com.mavixk.jcp.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * uses AtomicInteger utility class
 * gets and increments integer value atomically like volatile read/writes
 */
public class AtomicVars {

  private static AtomicInteger atomicInteger = new AtomicInteger(0);

  public static int getInt() {
    return atomicInteger.getAndIncrement();
  }

  public static boolean testAndSet(int expected , int newVal){
    return atomicInteger.compareAndSet(expected,newVal);
  }

  public static void main(String[] args) throws InterruptedException {
    Runnable r1 = () -> {
      testAndSet(0,2);
    };

    Runnable r2 = () -> {
      testAndSet(2,3);
    };

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(getInt());

  }
}
