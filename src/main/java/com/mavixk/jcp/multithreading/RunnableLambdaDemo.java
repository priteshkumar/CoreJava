package com.mavixk.jcp.multithreading;

/**
 * Runnable is a functional interface lambda expression can be used
 */
public class RunnableLambdaDemo {

  public static void main(String[] args) {
    Runnable task = () -> {
      System.out.println(Thread.currentThread().getName());
    };

    //pass task block lambda to thread construction
    new Thread(task).start();
    System.out.println("done");
    testThreadSleep();
  }

  public static void testThreadSleep() {
    Runnable task = () -> {
      try {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println("child thread sleep done");
      } catch (InterruptedException e) {
        return;
      }
    };
    new Thread(task).start();
    System.out.println("child thread done");
  }
}
