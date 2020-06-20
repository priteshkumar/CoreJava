package com.mavixk.jcp.lambdaexp;

import java.util.function.Predicate;

public class LambdaArguments {

  public static void main(String[] args) {

    Predicate<String> testPalindrome = (str) -> {
      boolean result = true;
      for (int i = 0; i < str.length() / 2; i++) {
        if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
          result = false;
          break;
        }
      }
      return result;
    };

    System.out.println(stringOp(testPalindrome,"malam"));
    System.out.println(stringOp(testPalindrome,"packer"));
  }

  /**
   * block lambda passed as function argument
   * @param predFunc
   * @param param
   * @param <T>
   * @return
   */
  public static <T> boolean stringOp(Predicate<T> predFunc, T param) {
    return predFunc.test(param);
  }
}
