package com.mavixk.jcp.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumerTest {

  private static Queue<String> q = new LinkedList<>();

  public static void main(String[] args) throws InterruptedException {
    Runnable r1 = () -> {
      while (true) {
        String val = "testproducer";
        while (q.isEmpty() == false) {
          //System.out.println("busy loop");
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        q.add(val);
      }
    };

    Runnable r2 = () -> {
      int k = 0;
      while (true) {
        while (q.isEmpty() == true) {
          //System.out.println("empty q");
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(++k + " " + q.poll());
      }
    };

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("exited both threads");
  }
}
