package leetcode.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLastWordTest {
  @org.junit.jupiter.api.Test
  void lengthOfLastWord() {
    assertEquals(5, LengthOfLastWord.lengthOfLastWord("Hello World"));
    assertEquals(4, LengthOfLastWord.lengthOfLastWord("  fly me  to  the moon  "));
    assertEquals(1, LengthOfLastWord.lengthOfLastWord("a"));
  }
}