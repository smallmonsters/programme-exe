package leetcode.simple;

/**
 * https://leetcode.cn/problems/plus-one/
 */

public class PlusOne {
  public static int[] plusOne(int[] digits) {
    int[] arr = new int[digits.length + 1];
    arr[0] = 1;
    digits[digits.length - 1] = digits[digits.length - 1] + 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] == 10) {
        arr[i + 1] = digits[i] = 0;
        if (i != 0) {
          digits[i - 1] = digits[i - 1] + 1;
        }
      } else {
        arr[i + 1] = digits[i];
      }
    }
    return digits[0] == 0 ? arr : digits;
  }

  public static int[] plusOneBetter(int[] digits) {
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      digits[i] = (digits[i] + 1) % 10;
      if (digits[i] != 0) {
        return digits;
      }
    }
    digits = new int[len + 1];
    digits[0] = 1;
    return digits;
  }
}
