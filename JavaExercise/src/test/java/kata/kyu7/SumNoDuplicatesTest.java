package kata.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumNoDuplicatesTest extends DTC {

  @Test
  void sumNoDuplicates() {
    assertEquals(5, SumNoDuplicates.sumNoDuplicates(new int[]{1, 1, 2, 3}), "Incorrect answer for arr = " + Arrays.toString(new int[]{1, 1, 2, 3}));
    assertEquals(6, SumNoDuplicates.sumNoDuplicates(new int[]{1, 2, 3}), "Incorrect answer for arr = " + Arrays.toString(new int[]{1, 2, 3}));
    assertEquals(3, SumNoDuplicates.sumNoDuplicates(new int[]{1, 1, 2, 2, 3}), "Incorrect answer for arr = " + Arrays.toString(new int[]{1, 1, 2, 2, 3}));
  }

  @Test
  public void test01() {
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 3);
    Map<Integer, List<Integer>> collect = intList.stream().collect(Collectors.groupingBy(e -> e % 2));
    System.out.println(collect);
  }
}