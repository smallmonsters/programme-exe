package kata.kyu7;

/**
 * https://www.codewars.com/kata/559cc2d2b802a5c94700000c/train/java
 * arr包含[4,8,6]，那么输出应该是2，因为需要向数组中添加两个数字(5和7)，使其成为从4到8的连续数字数组
 */

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Consecutive {
  public static int consecutive(int[] arr) {
    if (arr.length == 0 || arr.length == 1) return 0;
    arr = Arrays.stream(arr).sorted().toArray();
    return arr[arr.length - 1] - arr[0] + 1 - arr.length;
  }

  public static void test() {
    System.out.println(Consecutive.consecutive(new int[]{4, 8, 6}));

  }
}
