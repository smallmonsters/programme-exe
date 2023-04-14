package hepler;

import java.util.Stack;

// note:计算前缀表达式的值
public class PrefixEvaluation {
  static int evaluatePrefix(String prefix) {
    // 创建一个栈，用于存储操作数
    Stack<Integer> stack = new Stack<>();

    // 从右到左扫描前缀表达式
    for (int i = prefix.length() - 1; i >= 0; i--) {
      char ch = prefix.charAt(i);

      // 如果是数字，直接入栈
      if (Character.isDigit(ch)) {
        int operand = Character.getNumericValue(ch);
        stack.push(operand);
      }
      // 如果是运算符，弹出栈中的两个操作数，计算结果并压入栈中
      else {
        int operand1 = stack.pop();
        int operand2 = stack.pop();

        switch (ch) {
          case '+':
            stack.push(operand1 + operand2);
            break;
          case '-':
            stack.push(operand1 - operand2);
            break;
          case '*':
            stack.push(operand1 * operand2);
            break;
          case '/':
            stack.push(operand1 / operand2);
            break;
          default:
            throw new IllegalArgumentException("Invalid operator: " + ch);
        }
      }
    }

    // 返回最终结果
    return stack.pop();
  }

  public static void main(String[] args) {
    String prefix = "-*+3456";
    int result = evaluatePrefix(prefix);
    System.out.println("Prefix expression: " + prefix);
    System.out.println("Result: " + result);
  }
}
