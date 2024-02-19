package leetcode.simple;

/**
 * https://leetcode.cn/problems/length-of-last-word/
 */

public class LengthOfLastWord {

  //  方法一
  public static int lengthOfLastWord(String s) {
    int count = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ' && count == 0) {
        continue;
      } else if (s.charAt(i) != ' ') {
        count++;
      } else {
        break;
      }
    }
    return count;
  }

  //  方法二
  public static int lengthOfLastWordOther(String s) {
    String[] split = s.split(" ");
    return split[split.length - 1].length();
  }
}
