package com.mavixk.jcp.lambdaexp.pls.finterface;

@FunctionalInterface
interface Predicate<T> {

  public boolean test(T t);

  default public Predicate<T> and(Predicate<T> other) {
    return (t) -> test(t) && other.test(t);
  }
}

public class PredicateDemo {
  public static void main(String[] args){
    Predicate<String> p1 = (s) -> s.length() < 20;
    Predicate<String> p2 = (s) -> s.length() > 5;
    Predicate<String> p = p1.and(p2);

    System.out.println(p.test("Jenkins"));
    System.out.println(p.test("aws"));
    System.out.println(p.test("Docker"));
  }
}
