package hepler.calculate;

public abstract class Calculator {
  public String expression;

  /**
   * 验证前缀表达式
   *
   * @param s 表达式
   * @return boolean
   */
  protected static boolean verifyPrefixExpression(String s) {
    if (s.startsWith(" ") || s.endsWith(" ")) {
      throw new IllegalArgumentException("表达式格式错误: " + s);
    } else {
      return true;
    }

    //    String regex = "^[-+*/]\\s-?\\d+(\\.\\d+)?(\\s-?\\d+(\\.\\d+)?)?$";
    //    if (s.matches(regex)) {
    //      return true;
    //    } else {
    //      throw new IllegalArgumentException("表达式格式错误: " + s);
    //    }
  }


  public boolean hasHigherPriority(char op1, char op2) {
    if (op1 == '*' || op1 == '/') {
      return op2 == '-' || op2 == '+';
    } else {
      return false;
    }
  }

  //  计算表达式的值
  public abstract int calculate();

  /**
   * 中缀表达式转前缀表达式
   *
   * @param infix 中缀表达式
   * @return {@link String} 中缀表达式
   */
  public String infixToPrefix(String infix) {
    return "";
  }

  public int applyOperator(int num1, int num2, char op) {
    if (op == '+') {
      return num1 + num2;
    } else if (op == '-') {
      return num1 - num2;
    } else if (op == '*') {
      return num1 * num2;
    } else if (op == '/') {
      return num1 / num2;
    } else {
      throw new IllegalArgumentException("Unsupported operator: " + op);
    }
  }
}
