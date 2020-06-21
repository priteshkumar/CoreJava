package com.mavixk.jcp.lambdaexp;

import java.util.function.Function;

public class FunctionLambda {
  public static void main(String[] args){
    String val = "hello";
    testFunctionLambda();
  }

  public static void testFunctionLambda(){
    Function<String,String> func = (str) -> str.toUpperCase();
    System.out.println(func.apply("javacode"));
  }
}
