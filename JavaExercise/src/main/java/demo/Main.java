package demo;

import hepler.StaticLinkedList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    //    testSubArr();
    //    testGenericsArr();
    testStaticLinkedList();
    Parent parent = new Parent();

    Method method = parent.getClass().getMethod("say");
    method.invoke(parent);
  }

  //  note:数组子类demo
  private static void testSubArr() {
    //    ---------demo1--------
    Parent[] parents1 = new Parent[2];
    parents1[0] = new Sub();
    //    ---------demo2--------
    Parent[] parents2 = new Sub[2];  //  可以将子类型的对象存储在父类型的数组中
    parents2[0] = new Sub();
    parents2[1] = new Sub();
    //    parents2[1] = new Parent(); // 编译时报错 finished with non-zero exit value 1
    //    parents3[0] = new Sub2(); // 编译时报错 finished with non-zero exit value 1
    for (int i = 0; i < parents2.length; i++) {
      // parents2[i].speak();  //parents2 的类型是Parent，没有speak方法
      ((Sub) parents2[i]).speak(); // 强制转化
    }
    //    ---------demo3--------
    //    Sub[] sub1 = new Parent[2]; // 不能这么写
    //    ---------demo4--------
    Sub[] sub1 = new Sub[2];
    //    sub1[0] = new Parent(); // 不能这么写
  }

  // note:泛型数组demo

  static void testGenericsArr() {
    new Double(3.14);
    Integer[] integers = new Integer[10];
    //    List<Integer>[] array = new List<Integer>[10];  // 编译时警告：无法创建泛型数组
    //    ArrayList<Integer>[] boxData = new ArrayList[9];  // 编译时警告：未经检查或不安全的操作
    //    List myList = new ArrayList();
    //    myList.add(12);
    //    myList.add("22");
    //    int a = (int) myList.get(0);
    //    int b = (int) myList.get(1); // 运行时报错：finished with non-zero exit value 1


    System.out.println("是否回打印"); // 上面代码有警告，但是还是会输出
  }

  //  note: 静态链表demo
  static void testStaticLinkedList() {
    StaticLinkedList node = new StaticLinkedList();
    node.add(12);
    node.add(13);
    node.add(14);
    System.out.println(node.getNode(1));
  }

}

