package com.mavixk.jcp.algorithms;

public class Atoi {

  public static int atoi(String s) {
    s = s.trim();
    boolean pos = true;
    int i = 0;
    int result = 0;
    if (s.charAt(0) == '-') {
      pos = false;
    }
    if (s.charAt(0) == '+' || s.charAt(0) == '-') {
      i = 1;
    }
    for (; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return result;
      }
      //1234
      try {
        result = Math.addExact(Math.multiplyExact(result, 10),
            pos == true ? (new Integer(s.charAt(i)) - 48) : (new Integer(s.charAt(i)) - 48) * -1);
      } catch (Exception e) {
        return pos == true ? Integer.MAX_VALUE:Integer.MIN_VALUE;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String test = "-42";
    System.out.println(atoi(test));
  }
}
