package com.mavixk.jcp.lambdaexp.pls;

public class JdkComparatorChaining {

  public static void main(String[] args) {
    Person p1 = new Person(30, "Rusty", "Russell");
    Person p2 = new Person(30, "Rusty", "Molnar");

    //use jdk8 default Comparator chaining
    java.util.Comparator<Person> cmp =
        java.util.Comparator.comparing(Person::getAge)
            .thenComparing(Person::getFname)
            .thenComparing(Person::getLname);

    System.out.println(cmp.compare(p1,p2));
    System.out.println(cmp.compare(p2,p1));

  }
}
