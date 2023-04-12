package hepler;

import java.util.Stack;

public class Calculator {
  public static int calculate(String expression) {
    Stack<Integer> operandStack = new Stack<>(); // 数字栈
    Stack<Character> operatorStack = new Stack<>();// 运算符栈
    for (int i = 0; i < expression.length(); i++) {
      // 判断是否是数字
      if (Character.isDigit(expression.charAt(i))) {
        // 是数字 push 到 operandStack中
        int num = Character.digit(expression.charAt(i), 10);
        while (i < expression.length() - 1 && Character.isDigit(expression.charAt(i + 1))) {
          num = num * 10 + Character.digit(expression.charAt(i + 1), 10);
          i++;
        }
        operandStack.push(num);
      } else {
        // 是运算符 push 到 operatorStack中
        if (operatorStack.empty()) {
          operatorStack.push(expression.charAt(i));
        } else if (hasHigherPriority(expression.charAt(i), operatorStack.peek())) {
          // 当前运算符优先级大于栈顶的运算符 直接push
          operatorStack.push(expression.charAt(i));
        } else {
          // 当前运算符优先级小于等于栈顶的运算符
          operandStack.push(applyOperator(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
          operatorStack.push(expression.charAt(i));
        }
      }
    }

    while (operatorStack.size() != 0) {
      operandStack.push(applyOperator(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
    }

    return operandStack.pop();
  }

  private static boolean hasHigherPriority(char op1, char op2) {
    if (op1 == '*' || op1 == '/') {
      return op2 == '-' || op2 == '+';
    } else {
      return false;
    }
  }

  private static int applyOperator(int num1, int num2, char op) {
    if (op == '+') {
      return num1 + num2;
    } else if (op == '-') {
      return num2 - num1;
    } else if (op == '*') {
      return num1 * num2;
    } else if (op == '/') {
      return num2 / num1;
    } else {
      throw new IllegalArgumentException("Unsupported operator: " + op);
    }
  }

  public static void main(String[] args) {
    String expression = "2+6*2";
    int result = calculate(expression);
    System.out.println(expression + " = " + result);
  }
}


//import java.util.Stack;
//
//public class Calculator {
//  public static int calculate(String expression) {
//    Stack<Integer> operandStack = new Stack<>();
//    Stack<Character> operatorStack = new Stack<>();
//
//    for (int i = 0; i < expression.length(); i++) {
//      char ch = expression.charAt(i);
//      if (ch >= '0' && ch <= '9') {
//        int num = 0;
//        while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
//          num = num * 10 + (expression.charAt(i) - '0');
//          i++;
//        }
//        i--;
//        operandStack.push(num);
//      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
//        while (!operatorStack.isEmpty() && hasHigherPriority(operatorStack.peek(), ch)) {
//          int num2 = operandStack.pop();
//          int num1 = operandStack.pop();
//          char op = operatorStack.pop();
//          operandStack.push(applyOperator(num1, num2, op));
//        }
//        operatorStack.push(ch);
//      } else if (ch == '(') {
//        operatorStack.push(ch);
//      } else if (ch == ')') {
//        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
//          int num2 = operandStack.pop();
//          int num1 = operandStack.pop();
//          char op = operatorStack.pop();
//          operandStack.push(applyOperator(num1, num2, op));
//        }
//        operatorStack.pop();
//      }
//    }
//
//    while (!operatorStack.isEmpty()) {
//      int num2 = operandStack.pop();
//      int num1 = operandStack.pop();
//      char op = operatorStack.pop();
//      operandStack.push(applyOperator(num1, num2, op));
//    }
//
//    return operandStack.pop();
//  }
//
//  private static boolean hasHigherPriority(char op1, char op2) {
//    if (op1 == '*' || op1 == '/') {
//      return true;
//    } else if (op1 == '+' || op1 == '-') {
//      return op2 == '*' || op2 == '/';
//    } else {
//      return false;
//    }
//  }
//
//  private static int applyOperator(int num1, int num2, char op) {
//    if (op == '+') {
//      return num1 + num2;
//    } else if (op == '-') {
//      return num1 - num2;
//    } else if (op == '*') {
//      return num1 * num2;
//    } else if (op == '/') {
//      return num1 / num2;
//    } else {
//      throw new IllegalArgumentException("Unsupported operator: " + op);
//    }
//  }
//
//  public static void main(String[] args) {
//    String expression = "2*(3+4)-5/2";
//    int result = calculate(expression);
//    System.out.println(expression + " = " + result);
//  }
//}

