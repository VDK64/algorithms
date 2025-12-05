package org.example.leetcode;

import java.util.Objects;

public class Human {
  private int age;

  public Human(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Human human)) {
      return false;
    }
    return age == human.age;
  }

  @Override
  public int hashCode() {
    return Objects.hash(age);
  }

  @Override
  public String toString() {
    return "Human{" +
        "age=" + age +
        '}';
  }
}
