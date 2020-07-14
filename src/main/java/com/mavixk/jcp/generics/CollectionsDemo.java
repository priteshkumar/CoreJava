package com.mavixk.jcp.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CollectionsDemo {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(23, 24, 22, 21, 26);
    Predicate<Integer> predicate = (n) -> n % 2 != 0;
    System.out.println(count(list, predicate));
    List<String> stringList = Arrays.asList("jasper", "crarc", "malam", "abba");
    Predicate<String> stringPredicate = (str) -> {
      for (int i = 0; i < str.length() / 2; i++) {
        if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
          return false;
        }
      }
      return true;
    };
    System.out.println(count(stringList, stringPredicate));
  }

  public static <T> int count(List<T> list, Predicate<T> predicate) {
    int count = 0;
    for (T val : list) {
      if (predicate.test(val) == true) {
        count++;
      }
    }
    return count;
  }
}
