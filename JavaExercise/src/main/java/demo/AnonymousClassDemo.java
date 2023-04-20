package demo;

public class AnonymousClassDemo {
  public static void main(String[] args) {
    // 创建一个Animal对象并同时创建一个匿名类
    Parent parent = new Parent() {
      @Override
      public void say() {
        System.out.println("匿名类");
      }
    };
    parent.say();

    Sub sub = new Sub();
    sub.say();
  }

  static class Sub extends Parent {
    @Override
    public void say() {
      System.out.println("正常的匿名类");
    }
  }
}

