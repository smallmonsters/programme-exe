package kata.kyu6;


/**
 * https://www.codewars.com/kata/585d7d5adb20cf33cb000235/java
 * <p>
 * 有一个包含一些数字的数组。所有的数字都是相等的，只有一个不一样。试着找到它!
 * 它保证数组至少包含3个数字。
 * <p>
 * 测试包含一些非常大的数组，所以要考虑性能。
 */
public class FindUniq {
  public static double findUniq(double[] arr) {
    if (arr[0] == arr[1]) {
      for (int i = 2; i < arr.length; i++) {
        if (arr[i] != arr[0]) return arr[i];
      }
    } else {
      return arr[0] == arr[2] ? arr[1] : arr[0];
    }
    return 0;
  }
}
