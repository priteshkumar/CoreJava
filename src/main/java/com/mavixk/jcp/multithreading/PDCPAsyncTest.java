package com.mavixk.jcp.multithreading;

import static edu.rice.pcdp.PCDP.finish;
import static edu.rice.pcdp.PCDP.async;
import static edu.rice.pcdp.PCDP.forall;

import java.util.concurrent.atomic.AtomicReference;


public class PDCPAsyncTest {

  public static void main(String[] args) {
    //testSetup();
    //testForall();
    testAsyncForall();
    testAsyncForallreversed();
  }

  public static void testForall() {
    AtomicReference ref = new AtomicReference();
    finish(() -> {
      forall(0, 1000, (k) -> {
        ref.compareAndSet(null, k);
        System.out.println(k + " " + ref.get());
      });
    });
    System.out.println(ref.get());
  }

  public static void testAsyncForall() {
    finish(() -> {
      AtomicReference ref = new AtomicReference();
      async(() -> {
        System.out.println("init val " + ref.get());
      });
      System.out.println("spawn forall tasks");
      forall(0, 1000, (k) -> {
        ref.compareAndSet(null, k);
       // System.out.println(k + " " + ref.get());
      });
    });
    //System.out.println(ref.get());
  }

  public static void testAsyncForallreversed() {
    finish(() -> {
      AtomicReference ref = new AtomicReference();
      forall(0, 1000, (k) -> {
        ref.compareAndSet(null, k);
        //System.out.println(k + " " + ref.get());
      });
      async(() -> {
        System.out.println("init val " + ref.get());
      });
    });
    //System.out.println(ref.get());
  }

  public static void testSetup() {
    finish(() -> {
      AtomicReference ref = new AtomicReference();
      async(() -> {
        System.out.println(ref.get());
        System.out.println("this is inside async");
      });
    });
  }
}
