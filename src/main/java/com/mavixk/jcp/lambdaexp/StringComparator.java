package com.mavixk.jcp.lambdaexp;

import java.util.Comparator;

public class StringComparator {

  public static void main(String[] args) {

    Comparator<String> comp = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    };

    //use lambda to implement comparator
    Comparator<String> compLambda = (s1, s2) -> Integer.compare(s1.length(), s2.length());
    System.out.println(compLambda.compare("jenkins", "aws"));
    System.out.println(compLambda.compare("git", "docker"));
  }

}
