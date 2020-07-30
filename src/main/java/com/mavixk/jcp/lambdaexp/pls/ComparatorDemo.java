package com.mavixk.jcp.lambdaexp.pls;


import java.util.function.Function;

interface Comparator<T> {

  public static <U> Comparator<U> comparing(Function<U, Comparable> f) {
    return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
  }

  public default Comparator<T> thenComparing(Comparator<T> cmp) {
    return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
  }

  public default Comparator<T> thenComparing(Function<T, Comparable> f) {
    return thenComparing(comparing(f));
  }

  public int compare(T t1, T t2);
}

class Person {

  int age;
  String fname;
  String lname;

  public Person(int age, String fname, String lname) {
    this.age = age;
    this.fname = fname;
    this.lname = lname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  @Override
  public String toString() {
    return "Person{" +
        "age=" + age +
        ", fname='" + fname + '\'' +
        ", lname='" + lname + '\'' +
        '}';
  }
}

public class ComparatorDemo {

  public static void main(String[] args) {
    Person p1 = new Person(30, "Smith", "Smith");
    Person p2 = new Person(32, "Kasper", "chev");
    Comparator<Person> cmpAge = Comparator.comparing(Person::getAge);
    Comparator<Person> cmpFname = Comparator.comparing(Person::getFname);
    System.out.println(cmpAge.compare(p1, p2));
    testThenComparing();
  }

  /**
   * this method shows comparator chaining
   */
  public static void testThenComparing() {
    //comparator chaining
    Comparator<Person> cmpAge = Comparator.comparing(Person::getAge);
    Comparator<Person> cmpFname = Comparator.comparing(Person::getFname);
    Comparator<Person> cmp = cmpAge.thenComparing(cmpFname);

    Person p1 = new Person(30, "Smith", "Smith");
    Person p2 = new Person(30, "Kasper", "Chev");
    System.out.println(cmp.compare(p1, p2));
  }

  /*
   * this method shows lambda chaining
   * use class method references as Function lambdas
   * pass them to comparator interface
   */
  public static void testLambdaChaining() {

    Comparator<Person> cmp =
        Comparator.comparing(Person::getAge)
            .thenComparing(Person::getFname)
            .thenComparing(Person::getLname);

    Person p1 = new Person(30, "Smith", "Russ");
    Person p2 = new Person(30, "Smith", "Chev");
    System.out.println(cmp.compare(p1,p2));
  }
}
