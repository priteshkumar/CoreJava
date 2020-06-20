package com.mavixk.jcp.lambdaexp;

interface StringFunc {

  String process(String param);
}

public class StringLambdas {

  public static void main(String[] args) {
    testStringLambda();
  }

  /**
   * example of block lambda for string functions
   */
  public static void testStringLambda() {
    StringFunc reverseFunc = (str) -> {
      String result = "";
      for (int i = str.length() - 1; i >= 0; i--) {
        result = result + str.charAt(i);
      }
      return result;
    };
    System.out.println(reverseFunc.process("computer"));
  }
}
