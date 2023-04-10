package kata.kyu6;

import kata.common.Kata;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/63d1bac72de941033dbf87ae/train/java
 * 数独板验证器，验证数独是否正确
 */
public class SudokuValidator extends Kata {
  private static final Set<Integer> BASE = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

  public static boolean validateByOther(int[][] board) {
    BiFunction<Integer, Integer, Integer>
            rows = (i, j) -> board[i][j],
            cols = (i, j) -> board[j][i],
            boxes = (i, j) -> board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];

    return check(rows) && check(cols) && check(boxes);
  }


  private static boolean check(BiFunction<Integer, Integer, Integer> extract) {
    return IntStream.range(0, 9).boxed()
            .map(i -> IntStream.range(0, 9).boxed()
                    .map(j -> extract.apply(i, j))
                    .collect(Collectors.toSet()))
            .allMatch(set -> set.equals(BASE));
  }

  private static boolean isRight(IntStream intStream) {
    int[] array = intStream.toArray(); // 转换为数组
    return Arrays.stream(array).max().getAsInt() == 9 && Arrays.stream(array).min().getAsInt() == 1 && Arrays.stream(array).sum() == 45;
  }

  public static boolean validate(int[][] board) {
    List<ArrayList<Integer>> boxData = new ArrayList<ArrayList<Integer>>(9);

    ArrayList<ArrayList<Integer>> colData = new ArrayList();
    //    ArrayList<Integer>[] boxData = new ArrayList[9];
    for (int i = 0; i < board.length; i++) {
      int[] row = board[i];
      //      判断行是否正确
      if (isRight(Arrays.stream(row))) {
        for (int j = 0; j < row.length; j++) {
          //          colData.
          //          colData[j].set(i, row[j]);
          //          boxData[i / 3 * 3 + j / 3].set(i % 3 * 3 + j % 3, row[j]);
        }
      } else {
        return false;
      }
    }

    //    for (int i = 0; i < 9; i++) {
    //      ArrayList<Integer> item = colData[i];
    //      System.out.println(item);
    ////      isRight(.stream());
    //    }
    //    Arrays.stream(colData).map()


    //      判断列是否正确 NOTE:这里判断有问题
    //    if (colData[i].length == 9 && !isRight(Arrays.stream(colData[i])) || boxData[i].length == 9 && !isRight(Arrays.stream(boxData[i]))) {
    //      return false;
    //    }
    return true;
  }

  public static void test() {
    System.out.println(SudokuValidator.validate(new int[][]{
            {8, 4, 7, 2, 6, 5, 1, 9, 3},
            {1, 3, 6, 7, 9, 8, 2, 4, 5},
            {9, 5, 2, 1, 4, 3, 8, 6, 7},
            {4, 2, 9, 6, 7, 1, 5, 3, 8},
            {6, 7, 8, 5, 3, 2, 9, 1, 4},
            {3, 1, 5, 4, 8, 9, 7, 2, 6},
            {5, 6, 4, 9, 1, 7, 3, 8, 2},
            {7, 8, 1, 3, 2, 4, 6, 5, 9},
            {2, 9, 3, 8, 5, 6, 4, 7, 1}}));
  }
}
