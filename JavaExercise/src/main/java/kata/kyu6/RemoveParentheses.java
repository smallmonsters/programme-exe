package kata.kyu6;

import kata.common.Kata;

/**
 * https://www.codewars.com/kata/5f7c38eb54307c002a2b8cc8/train/java
 * 去掉括号中的内容
 *"example(unwanted thing)example" ===》"exampleexample"
 * 除括号外，字符串中只能出现字母和空格。不要担心其他括号，如“[]”和“{}”，因为这些永远不会出现
 * 可以有多个括号。
 * 括号可以嵌套
 * */
public class RemoveParentheses extends Kata {
  public static String removeParentheses(String str) {
    while(str.contains("(")){
      str = str.replaceAll("\\([^()]*\\)","");
    }
    return str;
  }

  public static void test() {
    System.out.println(RemoveParentheses.removeParentheses("(first group) (second group) (third group)"));
    System.out.println(RemoveParentheses.removeParentheses("a(b(c()))"));
  }
}
