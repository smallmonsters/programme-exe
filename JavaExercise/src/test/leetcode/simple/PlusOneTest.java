package leetcode.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

  @Test
  void plusOne() {
    assertArrayEquals(new int[]{1, 0}, PlusOne.plusOne(new int[]{9}));
    assertArrayEquals(new int[]{1, 1}, PlusOne.plusOne(new int[]{1, 0}));

  }
}