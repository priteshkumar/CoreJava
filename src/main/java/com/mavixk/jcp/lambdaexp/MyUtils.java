package com.mavixk.jcp.lambdaexp;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyUtils {
  public static Predicate<Integer> odd = (n) -> (n & 1) == 1;
  public static BinaryOperator<Integer> sum = Integer::sum;
  public static BinaryOperator<Integer> max = Integer::max;
  public static BinaryOperator<Integer> min = Integer::min;
  public static Consumer<String> printer = System.out::println;

  public static void main(String[] args) {
    System.out.println(sum.apply(21, 23));
    printer.accept(String.valueOf(sum.apply(21,23)));
    System.out.println(max.apply(21,23));
    System.out.println(odd.test(21));
  }
}
