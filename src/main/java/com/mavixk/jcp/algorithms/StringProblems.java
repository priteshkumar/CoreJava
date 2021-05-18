package com.mavixk.jcp.algorithms;

import java.util.ArrayList;

public class StringProblems {

  public static void main(String[] args) {
    String test = "hello";
    char[] rev = test.toCharArray();

    System.out.println(reverseWords("the sky is blue"));
    System.out.println(reverseWords("  a good   example "));
  String val = solve("       fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq                 ");
  int i = val.length() -1;
  System.out.println(val);
  System.out.println(val.charAt(val.length()-1));
  System.out.println(solve("  a blue    sky   "));

  }

  public static int findWord(String s, int e) {
    int i = -1;
    while (e >= 0) {
      if (e < s.length() && Character.isLetter(s.charAt(e))) {
        i = e;
        e--;
      } else if (i != -1) {
        break;
      } else {
        e--;
      }
    }
    return i;
  }

  public static String solve(String A) {

    String a = A;

    StringBuilder sb = new StringBuilder();
    int end = a.length();

    for (int i = a.length() - 1; i >= 0; i--) {

      if (a.charAt(i) == ' ') {

        if (sb.length() > 0 && end - i > 1) {
          sb.append(' ');
        }

        sb.append(a.substring(i + 1, end));
        end = i;
      }

    }

    //System.out.println(end);
    if (sb.length() > 0 && end > 0) {
      sb.append(' ');
    }

    sb.append(a.substring(0, end));

    return sb.toString();
  }

  public static String reverseWords(String s) {
    StringBuffer sb = new StringBuffer();

    int e = s.length() - 1;
    int i = 0;
    int j = -1;
    while (e >= 0) {

      while (e >= 0 && s.charAt(e) == ' ') {
        e--;
      }
      j = e + 1;
      i = findWord(s, j);
      // System.out.println(sb.toString());
      if (i != -1) {
        if (sb.length() == 0) {
          sb.append(s.substring(i, j));
        } else {
          sb.append(" " + s.substring(i, j));
        }

        i--;
        e = i;
        //System.out.println(sb.toString());
      }
    }

    return sb.toString();
  }
}
