package hepler.calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixTest {

  @Test
  void calculate() {
    Prefix prefix1 = new Prefix("- * + 3 4 5 6");
    Prefix prefix2 = new Prefix("+ + 2 * 3 - 7 4 / 8 4");
    assertEquals(29, prefix1.calculate());
    assertEquals(13, prefix2.calculate());
  }
}