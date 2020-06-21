package com.mavixk.jcp.lambdaexp;

import java.util.function.Function;
import java.util.function.IntFunction;

public class EnclosingScope {
  private static int version=2;

  public static void main(String[] args){
    int outerval = 10;
    IntFunction<Integer> func = (n) -> {
      //outerval++; outerval is captured and is effectively final
      return n + outerval;
    };
    //outerval++; //even this is not allowed
    System.out.println(func.apply(20));
    testEnclosingscope();
  }

  public static void testEnclosingscope(){
    Function<String,Integer> func = (str) ->{
      return str.length() + version; // lambda can access static vars of enclosing scope
    };
    System.out.println(func.apply("jenkins"));
  }
}
