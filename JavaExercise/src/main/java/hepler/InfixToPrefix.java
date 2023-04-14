package hepler;

import java.util.Stack;

public class InfixToPrefix {
  // 返回运算符的优先级
  static int precedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

  // note:中缀表达式转前缀表达式 代码有问题
  static String infixToPrefix(String infix) {
    // 创建两个栈，一个用于运算符，一个用于操作数
    Stack<Character> operatorStack = new Stack<>();
    Stack<String> operandStack = new Stack<>();

    // 从右到左扫描中缀表达式
    for (int i = infix.length() - 1; i >= 0; i--) {
      char ch = infix.charAt(i);

      // 如果是右括号，直接入栈
      if (ch == ')') {
        operatorStack.push(ch);
      }
      // 如果是左括号，弹出运算符栈中的运算符，直到遇到右括号
      else if (ch == '(') {
        while (!operatorStack.isEmpty() && operatorStack.peek() != ')') {
          char operator = operatorStack.pop();
          String operand1 = operandStack.pop();
          String operand2 = operandStack.pop();
          String result = operator + operand1 + operand2;
          operandStack.push(result);
        }
        operatorStack.pop(); // 弹出右括号
      }
      // 如果是运算符，判断其优先级，将其压入栈中
      else if (Character.isDigit(ch) || Character.isLetter(ch)) {
        // 如果是数字或字母，直接入栈
        operandStack.push(String.valueOf(ch));
      } else {
        while (!operatorStack.isEmpty() && precedence(ch) < precedence(operatorStack.peek())) {
          char operator = operatorStack.pop();
          String operand1 = operandStack.pop();
          String operand2 = operandStack.pop();
          String result = operator + operand1 + operand2;
          operandStack.push(result);
        }
        operatorStack.push(ch);
      }
    }

    // 处理剩余的运算符
    while (!operatorStack.isEmpty()) {
      char operator = operatorStack.pop();
      String operand1 = operandStack.pop();
      String operand2 = operandStack.pop();
      String result = operator + operand1 + operand2;
      operandStack.push(result);
    }

    // 返回最终结果
    return operandStack.pop();
  }

  public static void main(String[] args) {
    String infix = "(3+4)×5-6";
    String prefix = infixToPrefix(infix);
    System.out.println("Infix expression: " + infix);
    System.out.println("Prefix expression: " + prefix);
  }
}
