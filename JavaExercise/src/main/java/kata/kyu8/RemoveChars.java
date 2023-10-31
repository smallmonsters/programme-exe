package kata.kyu8;

/**
 * https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0/train/java
 * <p>
 * 您的目标是创建一个函数来删除字符串的第一个和最后一个字符。给你一个参数，原始字符串。您不必担心少于两个字符的字符串。
 */


public class RemoveChars {
  public static String remove(String str) {
    String x = "";
    for (int i = 1; i < str.length() - 1; i++) {
      x += str.charAt(i);
    }
    return x;
  }
}
