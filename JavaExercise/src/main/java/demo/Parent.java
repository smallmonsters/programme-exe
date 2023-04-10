package demo;

public class Parent {
  String name;
  int age;

  public Parent(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Parent() {}

  public void say() {
    System.out.println("parent say method");
  }

}
