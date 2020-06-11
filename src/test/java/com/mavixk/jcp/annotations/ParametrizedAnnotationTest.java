package com.mavixk.jcp.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Testparams {

  String[] value();
}

public class ParametrizedAnnotationTest {

  @Test
  @Testparams({"malam", "aba", "abba", "abcd"})
  public void testPalindrome() {

   // System.out.println(System.getenv());
    System.out.println(System.getProperties());
    System.out.println(System.getProperty("user.dir"));
    try {
      Class<?> c = ParametrizedAnnotationTest.class;
      Method method = c.getMethod("testPalindrome");
      Testparams testparams = method.getAnnotation(Testparams.class);
      //System.out.println(testparams.value());
      for (String s : testparams.value()) {
        System.out.println(s + " is palindrome: " + isPalindrome(s));
      }

    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  public boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
