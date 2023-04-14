package hepler.calculate;

import java.util.Stack;

public class Prefix extends Calculator {
  public Prefix(String s) {
    if (Prefix.verifyPrefixExpression(s)) {
      expression = s;
    }
  }

  @Override
  public int calculate() {
    Stack<Integer> operandStack = new Stack<>(); // 数字栈
    for (int i = expression.length() - 1; i >= 0; i--) {
      if (expression.charAt(i) == ' ') {
        continue;
      } else if (Character.isDigit(expression.charAt(i))) { // 当前字符是数字
        //        todo: 没有判断负数
        int num = 0; // 大于9的数，累加到num
        if (expression.charAt(i - 1) == ' ') { //
          num = Character.digit(expression.charAt(i), 10);
        } else {
          while (i > 0 && expression.charAt(i - 1) != ' ') {
            num = num * 10 + Character.digit(expression.charAt(i), 10);
            i--;
          }
        }
        operandStack.push(num);
      } else { // 当前字符是 运算符
        operandStack.push(applyOperator(operandStack.pop(), operandStack.pop(), expression.charAt(i)));
      }
    }
    return operandStack.peek();
  }

}
