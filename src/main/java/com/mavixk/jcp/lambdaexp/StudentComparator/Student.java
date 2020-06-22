package com.mavixk.jcp.lambdaexp.StudentComparator;

public class Student {

  private String firstname;
  private String lastname;
  private int age;
  private int score;

  public Student(String firstname, String lastname, int age, int score) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;
    this.score = score;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return this.getFirstname() + " " + this.lastname + " " + this.age + " " + this.score;
  }
}
