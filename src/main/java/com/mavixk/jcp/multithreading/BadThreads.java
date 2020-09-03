package com.mavixk.jcp.multithreading;/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class BadThreads {

  static class Message {

    private static String message;
    private static boolean empty = true;

    public synchronized void put(String msg){
      while(!empty){
        try{
          wait();
        }catch(InterruptedException e){}
      }
      message = msg;
      empty = false;
      notifyAll();
    }

    public synchronized String get(){
      while(empty){
        try{
          wait();
        }catch(InterruptedException e){}
      }
      empty = true;
      notifyAll();
      return message;
    }
  }

  private static Message messageOb = new Message();

  private static class CorrectorThread
      extends Thread {

    public void run() {
      try {
        sleep(1000);
      } catch (InterruptedException e) {
      }
      // Key statement 1:
      //message = "Mares do eat oats.";
      messageOb.put("Mares do eat oats.");
    }
  }

  public static void main(String args[])
      throws InterruptedException {

    Thread t = new CorrectorThread();
    t.start();
    messageOb.put("Mares do not eat oats.");
    ////use join to enforce happens-before-relationship
    //this way statement 1 always occurs before statement 2
    //sleep doesnt enforce this
    //t.join();
    Thread.sleep(2000);
    // Key statement 2:
    System.out.println(messageOb.get());
  }
}
