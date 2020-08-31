package com.mavixk.jcp.lambdaexp.pls;

import java.util.ArrayList;
import java.util.List;

public class IterableLambda {

  public static void main(String[] args) {
    //pass println consumer to forEach
    //alist.forEach(System.out::println);
    testConvertValues();
    System.out.println("call testforEach");
    testForEach();
    System.out.println("call testRemoveIf");
    testRemoveIf();
    System.out.println("call testReplaceAll");
    testReplaceAll();
    System.out.println("call testComparator");
    testSortComparator();
  }

  public static void testForEach(){
    List<String> alist = new ArrayList<>();
    alist.add("jenkins");
    alist.add("docker");
    alist.add("aws");
    alist.forEach(s -> System.out.println(s));
  }

  public static void testRemoveIf(){
    List<String> alist = new ArrayList<>();
    alist.add("jenkins");
    alist.add("docker");
    alist.add("github");
    alist.add("aws");

    alist.removeIf(s -> s.charAt(0) == 'a');
    alist.forEach(System.out::println);
  }

  public static void testReplaceAll(){
    List<String> alist = new ArrayList<>();
    alist.add("jenkins");
    alist.add("docker");
    alist.replaceAll(s -> s.toUpperCase());
    alist.forEach(System.out::println);
  }

  public static void testSortComparator() {
    List<Person> personList = new ArrayList<>();
    personList.add(new Person(32, "Rusty", "Russell"));
    personList.add(new Person(30, "Ulrich", "Drepper"));
    personList.sort(java.util.Comparator.comparing(Person::getAge).thenComparing(Person::getFname));
    personList.forEach(System.out::println);
  }

  public static void testConvertValues(){
    List<Person> personList = new ArrayList<>();
    personList.add(new Person(32, "Rusty", "Russell"));
    personList.add(new Person(30, "Ulrich", "Drepper"));
    List<Integer> ilist = new ArrayList<>();
    personList.forEach((p) -> {
      Integer val = Integer.valueOf(p.getAge()) + 100;
      ilist.add(val);
    });
    System.out.println(ilist);
  }
}
