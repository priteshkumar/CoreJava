package com.mavixk.jcp.lambdaexp.StudentComparator;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

  /**
   * <p>generate comparison lambda based on extractor function
   *
   * @param f   key extractor which extracts comparable key from U
   * @param <U> parameter type
   * @return a comparator for U based on key extracted by f
   */
  public static <U> Comparator<U> comparing(Function<U, Comparable> f) {
    return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
  }

  public int compare(T t1, T t2);

  public default Comparator<T> thenComparing(Comparator<T> cmp) {
    return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
  }

  public default Comparator<T> thenComparing(Function<T,Comparable> f) {
    return thenComparing(comparing(f));
  }
}
