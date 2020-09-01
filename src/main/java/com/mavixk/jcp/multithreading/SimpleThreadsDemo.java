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
          System.out.println(Thread.currentThread().getState());
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
    //checks periodically if messageloop is alive
    //wait for 1 second
    //if timeout passed and still alive , interrupt messageloop
    //exit
    while(t.isAlive()){
      System.out.println("waiting on jenkins jobs");
      System.out.println(t.getState());
      t.join(1000);
      if((System.currentTimeMillis() - start > timeout) && t.isAlive()){
        t.interrupt();
        t.join();
      }
    }
    System.out.println("finally all jobs done");
  }
}
