package com.mavixk.jcp.annotations;
import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface MyMarker{}

public class MarkerAnnotation {
  @MyMarker
  public static void testcalc() throws NoSuchMethodException {
    Method m = MarkerAnnotation.class.getMethod("testcalc");
    if(m.isAnnotationPresent(MyMarker.class))
      System.out.println("marker annotation is present");
  }

  public static void main(String[] args) throws NoSuchMethodException {
    testcalc();
  }
}
