package demo;

import kata.kyu6.Main;

import javax.xml.namespace.QName;

public class MyData<T> {
  String name;
  int age;
  private T data;

  public MyData(String name, int age) {
    this.name = name;
    this.age = age;

    Object[] a = new Object[]{1, "2", false, null, "1.2L"};
//    Text[] b = new Text[]{new Text("a"), new Button("b")};
  }

  public MyData() {
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  class Text {
    public String value;

    public Text(String s) {
      this.value = s;
    }
  }

  class Button extends Text {
    public String type;

    public Button(String s) {
      super(s);
    }
  }
}
