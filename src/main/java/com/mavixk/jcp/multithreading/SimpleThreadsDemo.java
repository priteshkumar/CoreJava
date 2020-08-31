package com.mavixk.jcp.multithreading;

public class SimpleThreadsDemo {

  public static void main(String[] args) throws InterruptedException {

    Runnable messageLoop = () -> {
      String[] ciJobs = {
          "jenkins build job",
          "jenkins test job",
          "jenkins deploy job"
      };
      try {
        for (String job : ciJobs) {
          Thread.sleep(3000);
          System.out.println(Thread.currentThread().getName() + " \n" + job);
        }
      } catch (InterruptedException e) {
        System.out.println("jenkins job interrupted");
        return;
      }
    };
    long start = System.currentTimeMillis();
    long timeout = 7 * 1000;
    Thread t =  new Thread(messageLoop);
    t.start();
    while(t.isAlive()){
      System.out.println("waiting on jenkins jobs");
      t.join(1000);
      if((System.currentTimeMillis() - start > timeout) && t.isAlive()){
        t.interrupt();
        t.join();
      }
    }
    System.out.println("finally all jobs done");
  }
}
