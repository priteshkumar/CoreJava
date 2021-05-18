package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermute {

  public static void main(String[] args) {
    System.out.println(find_permutation("ABC"));
  }

  public static List<String> find_permutation(String S) {
    // Code here



    List<String> res = new ArrayList<String>();
    //StringBuilder out = new StringBuilder();
    char[] buffer = new char[S.length()];
    boolean[] flags = new boolean[S.length()];
    return permute(S, res, 0, 0, buffer, flags);
  }

  public static List<String> permute(String s, List<String> res, int index, int bindex,
      char[] buffer,
      boolean[] flags) {

    if (bindex == s.length()) {
      String val = String.valueOf(buffer);
      System.out.println(val);
      res.add(val);
      return res;
    }

    /*if (index >= s.length()) {
      return res;
    }*/

    // A B C
    for (int i = 0; i < s.length(); i++) {

      if (flags[i] == false) {
        flags[i] = true;

        buffer[bindex] = s.charAt(i);
        res = permute(s, res, i + 1, bindex + 1, buffer, flags);
        flags[i] = false;
      }

    }
    return res;

  }
}
