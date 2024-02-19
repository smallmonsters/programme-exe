package hepler.calculate;

import hepler.calculate.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
  public String[] prefix;

  @BeforeAll
  public void setUp() {
    prefix = new String[]{"- * + 3 4 5 6"};
  }


  @Test
  void testVerifyPrefixExpression() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    for (int i = 0; i < prefix.length; i++) {
      String expression = prefix[i];
      Method verifyPrefixExpression = Calculator.class.getDeclaredMethod("verifyPrefixExpression", String.class);
      verifyPrefixExpression.setAccessible(true);
      assertTrue((boolean) verifyPrefixExpression.invoke(null, expression), "表达式" + expression + "错误");
      // 以空格开头的表达式，应该抛出 IllegalArgumentException 异常
      assertThrows(IllegalArgumentException.class, () -> {
        try {
          verifyPrefixExpression.invoke(null, expression);
        } catch (InvocationTargetException e) {
          if (e.getCause() instanceof IllegalArgumentException) {
            throw e.getCause();
          } else {
            throw e;
          }
        }
      }, "表达式" + expression + "错误");
    }
  }
}