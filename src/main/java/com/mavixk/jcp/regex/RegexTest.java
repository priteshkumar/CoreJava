package com.mavixk.jcp.regex;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

  public static void main(String[] args) {
    String[] passwords = {"  pa ss1#  ", "12pass#", "pass12#", "pa1ss#", "1pass#", "1#pass", "pas"
        + "@#s1",
        "pass", "123", "123#", "abcd#", "###", "#12@", "pass123", "p#3", "p 312 #"};
    Predicate<String> testPassword = RegexTest::checkPassWord;
    /*for(String pass:passwords){
      System.out.println(pass + " " + testPassword.test(pass));
    }*/

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 0; i < n; i++) {
      //scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      String val = scan.nextLine();
      // sb.append(val + "\n");
      printFields(val);
      scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      //checkPattern(val);
      // System.out.println(checkCaseInsensitive(val));

    }
    scan.close();
    //System.out.println(sb.toString());
    //findHackerrank("hackerrank is good");

    // printFields("1-897-2638277");
    //System.out.println(checkCaseInsensitive("I like code and #hackerRank"));
  }

  public static void printFields(String val) {
    String p = "([0-9]{1,3})[\\s-]([0-9]{1,3})[\\s-]([0-9]{4,10})";
    Pattern s = Pattern.compile(p);
    Matcher m = s.matcher(val);
    int c = m.groupCount();
    if (m.find() == true) {
      System.out.println(
          "CountryCode=" + m.group(1) + ",LocalAreaCode=" + m.group(2) + ",Number=" + m.group(3));
    }
  }

  /*
  It must begin with either an underscore, _ (ASCII value ), or a period, . (ASCII value ).
The first character must be immediately followed by one or more digits in the range  through .
After some number of digits, there must be  or more English letters (uppercase and/or lowercase).
It may be terminated with an optional _ (ASCII value ).
 Note that if it's not terminated with an underscore,
 then there should be no characters after the sequence of  or more English letters.

   */
  public static void checkPattern(String val) {
    String p = "^[_.]{1}[0-9]+[a-zA-Z]*[_]?$";
    if (Pattern.matches(p, val) == true) {
      System.out.println("VALID");
    } else {
      System.out.println("INVALID");
    }
  }

  public static boolean checkCaseInsensitive(String val) {
    System.out.println(val);
    Pattern p = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(val);
    if (m.find() == true) {
      return true;
    } else {
      return false;
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

  public static void findHackerrank(String val) {
    String a = "^hackerrank";
    String b = "hackerrank$";
    Pattern c = Pattern.compile(a);
    Pattern d = Pattern.compile(b);
    Matcher e = c.matcher(val);

    Matcher f = d.matcher(val);
    boolean s = e.find();
    boolean u = f.find();

    if (s && u) {
      System.out.println("0");
    } else if (s) {
      System.out.println("1");
    } else if (u) {
      System.out.println("2");
    } else {
      System.out.println("-1");
    }
  }

}
