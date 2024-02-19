package kata.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DTCTest extends DTC {

  @Test
  void testToIndustrial() {
    System.out.print(DTC.toIndustrial(1));
    assertEquals(0.02, DTC.toIndustrial(1));
    assertEquals(0.03, DTC.toIndustrial(2));
    assertEquals(1.75, DTC.toIndustrial(105));

  }

  @Test
  void testToIndustrial1() {
    assertEquals(0.05, DTC.toIndustrial("0:03"));
    assertEquals(0.07, DTC.toIndustrial("0:04"));
    assertEquals(1.75, DTC.toIndustrial("1:45"));

  }

  @Test
  void testToNormal() {
    assertEquals("1:45", DTC.toNormal(1.75));
    assertEquals("53:08", DTC.toNormal(53.13));
    assertEquals("0:20", DTC.toNormal(0.33));
  }
}