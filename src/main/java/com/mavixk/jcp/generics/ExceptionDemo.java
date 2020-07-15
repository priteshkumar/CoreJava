package com.mavixk.jcp.generics;

//generic class cannot extend throwable
//below is invalid
//class InvalidPassException<T> extends RuntimeException

public class ExceptionDemo extends Exception{
  public static void main(String[] args){
    try{
      throw new ExceptionDemo();
    }catch(ExceptionDemo e){ //this cannot have type arguments
      e.printStackTrace();
    }
  }
}
