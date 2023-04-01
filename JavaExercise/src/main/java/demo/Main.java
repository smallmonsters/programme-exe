package demo;

public class Main {
  public static void main(String[] args) {
    MyData myData = new MyData("Bob", 10);
    int a = 10;
    add(a);
    System.out.println(a);
  }

  static void add(int a) {
    a++;
    System.out.println(a);
  }
}

