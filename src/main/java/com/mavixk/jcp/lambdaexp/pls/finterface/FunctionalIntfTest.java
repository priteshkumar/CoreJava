package com.mavixk.jcp.lambdaexp.pls.finterface;

import java.util.function.Predicate;

public class FunctionalIntfTest {

  public static void main(String[] args) {
    testPredicate();
  }

  public static void testPredicate() {
    Predicate<String> stringPredicate = (s) -> s.length() > 10;
    System.out.println(stringPredicate.test("awscloudplatform"));
  }

  /**
   * Functional interface should have only one abstract method
   * default/static methods dont count
   * Object methods do not count
   * @param <T>
   */
  @FunctionalInterface
  interface ParamTest<T> {

    public boolean testParam(T val);

    //default methods dont count
    default boolean testVal(T val){
      return true;
    }

    //Object overridden methods do not count
    boolean equals(Object object);

    /*
    default int hashCode() {
      return 0;
    }*/
  }
}
