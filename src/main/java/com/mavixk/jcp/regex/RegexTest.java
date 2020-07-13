package com.mavixk.jcp.regex;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class RegexTest {

  public static void main(String[] args) {
    String[] passwords = {"  pa ss1#  ","12pass#", "pass12#", "pa1ss#", "1pass#", "1#pass", "pas"
        + "@#s1",
        "pass", "123", "123#", "abcd#", "###", "#12@", "pass123", "p#3","p 312 #"};
    Predicate<String> testPassword = RegexTest::checkPassWord;
    for(String pass:passwords){
      System.out.println(pass + " " + testPassword.test(pass));
    }
  }

  public static boolean checkPassWord(String password) {
    password = password.trim();
    System.out.println(password);
    String letterPattern = ".*[a-zA-Z]+.*";
    String digitPattern = ".*[0-9]+.*";
    String otherCharPattern = ".*[^a-zA-Z0-9].*";
    if (Pattern.matches(letterPattern, password) && Pattern.matches(digitPattern, password)
        && Pattern.matches(otherCharPattern, password)) {
      return true;
    }
    return false;
  }
}
