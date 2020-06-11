package com.mavixk.jcp.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface SingleAnno{
  int value() default 10;  //field name should be "value"
}


public class SingleValuedAnnotation {

  //no need of specifying field named "value"
  //annotation just contains one field with name "value"
  @SingleAnno(100)
  public static void testcalc(){
    try{
      Method m = SingleValuedAnnotation.class.getMethod("testcalc");
      SingleAnno anno = m.getAnnotation(SingleAnno.class);
      System.out.println(anno.value());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    testcalc();
  }
}
