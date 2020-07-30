package com.mavixk.jcp.lambdaexp.pls;

import java.util.ArrayList;
import java.util.List;

public class IterableLambda {

  public static void main(String[] args) {

    List<String> alist = new ArrayList<>();
    alist.add("jenkins");
    alist.add("docker");
    alist.add("aws");
    alist.add("chef");
    alist.add("github");

    //pass println consumer to forEach
    //alist.forEach(System.out::println);
    alist.forEach((s) -> System.out.println(s));
    alist.removeIf((s) -> s.equals("chef"));
    System.out.println("######removed chef######");
    alist.forEach((s) -> System.out.println(s));

    System.out.println("#####transform all to upper case#####");
    alist.replaceAll((s) -> s.toUpperCase());
    alist.forEach(System.out::println);

    testSortComparator();
  }

  public static void testSortComparator() {
    List<Person> personList = new ArrayList<>();
    personList.add(new Person(32, "Rusty", "Russell"));
    personList.add(new Person(30, "Ulrich", "Drepper"));
    personList.sort(java.util.Comparator.comparing(Person::getAge).thenComparing(Person::getFname));
    personList.forEach(System.out::println);
  }
}
