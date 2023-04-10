package kata.kyu6;

import kata.common.Kata;

//NOTE：不知道题目要干嘛，先放这儿
public class ArrayPacking extends Kata {
  public static long arrayPacking(int[] arr) {
    long res = 0;
    for (int i = 0; i < arr.length; i++) {
      long num = ((long) arr[i] << (8 * i));
      res = res | num;
    }
    return res;
  }

  //  public static long arrayPacking(int[] arr) {
//    long s = 0;
//    for (int i = 0; i < arr.length; i++) {
//      s += arr[i] * Math.pow(2, i * 8);
//    }
//    return s;
//  }
  public static void test() {
    System.out.println(ArrayPacking.arrayPacking(new int[]{24, 85, 0}));
    System.out.println(ArrayPacking.arrayPacking(new int[]{1, 1}));

  }
}
