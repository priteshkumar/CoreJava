package com.mavixk.jcp.multithreading;

import static java.lang.Thread.yield;

public class Thread1 {

  public static void main(String[] args) {
    Thread t1 = new Thread(new SendMessage());
    t1.start();
  }

  /**
   * demo runnable object to be passed to Thread constructor
   * sleep method call can be interrupted by interrupt
   * throws InterruptedException
   * An interrupt can terminate the sleep
   * On interrupt simply return
   */
  static class SendMessage implements Runnable {

    @Override
    public void run() {
      for(int i=0; i < 5;i++){
        try {
          Thread.sleep(3000);//sleep throws interrupted exception
          System.out.println(i);
        } catch (InterruptedException e) {
          e.printStackTrace();
          return;
        }
        //yield();
      }
    }
  }
}
