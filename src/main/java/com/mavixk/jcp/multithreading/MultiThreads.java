package com.mavixk.jcp.multithreading;

/**
 * 2 threads demo
 */
public class MultiThreads extends Thread {

  private String name;

  public MultiThreads(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    Thread[] threads = {new MultiThreads("thread1"), new MultiThreads("thread2")};
    for(Thread t:threads)
      t.start();
  }

  public void run() {
    for (int i = 0; i <= 5; i++) {
      System.out.println(i);
      yield();
    }
  }
}
