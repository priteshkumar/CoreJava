package com.mavixk.jcp.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * synchronized statement is internal entity also called intrinsic lock/monitor it provides
 * exclusive access to a shared object's field every object is associated with intrinsic lock
 * establishes happens before relationship
 */
public class SynchronizedStmtDemo {

  private String lastname;
  private int count;
  private List<String> nameList = new ArrayList<>();

  public static void main(String[] args) throws InterruptedException {
    SynchronizedStmtDemo synchronizedStmtDemo = new SynchronizedStmtDemo();
    synchronizedStmtDemo.testSynchronized();
  }

  /**
   * synchronized is structured lock it acquires/releases lock implicitly , even in case of
   * exception
   *
   * @param name
   */
  public void addName(String name) {
    synchronized (this) { //acquire lock
      lastname = name;
      count++;
    }//release lock
    nameList.add(name);
  }

  public void testSynchronized() throws InterruptedException {
    Runnable task1 = () -> {
      this.addName("jenkins");
    };

    Runnable task2 = () -> {
      this.addName("docker");
    };

    Thread t1 = new Thread(task1);
    Thread t2 = new Thread(task2);
    t1.start();
    t2.start();

    t1.join();
    t2.join();
    System.out.println(this.lastname + " " + this.count);
    System.out.println(this.nameList);
  }
}
