package com.mavixk.jcp.multithreading;

/**
 * Demo class extending Thread
 * Override run method
 * Thread class implements Runnable interface
 */
public class Thread2 extends Thread {

  public static void main(String[] args) {
    Thread2 t1 = new Thread2();
    t1.start();
  }

  public void run() {
    for(int i=0; i < 10;i++){
      try {
        Thread.sleep(4000);
        System.out.println(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }
    }
  }
}
