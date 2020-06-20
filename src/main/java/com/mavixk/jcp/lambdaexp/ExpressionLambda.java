package com.mavixk.jcp.lambdaexp;

//Functional interface
interface TestNum {

  boolean test(int n);
}

public class ExpressionLambda {

  public static void main(String[] args) {
    //expression lambdas
    testExpressionLambdas();
    testBlockLambda();
  }

  public static void testExpressionLambdas() {
    TestNum testEven = (n) -> (n % 2) == 0;
    TestNum testFactor = (n) -> (n % 3) == 0;
    System.out.println(testEven.test(16));
    System.out.println(testFactor.test(27));
    System.out.println(testEven.test(11));
    System.out.println(testFactor.test(7));
  }

  public static void testBlockLambda() {
    TestNum testPerfectSquare = (n) -> {
      boolean result = false;
      for (int i = 2; i <= n / 2; i++) {
        if (i * i == n) {
          return true;
        }
      }
      return result;
    };
    System.out.println(testPerfectSquare.test(49));
    System.out.println(testPerfectSquare.test(50));
  }
}
