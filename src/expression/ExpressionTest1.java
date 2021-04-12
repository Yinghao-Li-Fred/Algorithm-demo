package expression;

import java.util.Stack;

public class ExpressionTest1 {
	public static void main(String[] args) {
		String ex = "(1+2)*2-1";
		System.out.println(ex);
		double rs = midToRear(ex);
		System.out.println(rs);
	}

	// 实现整个中缀表达式向后缀表达式转换
	public static Double midToRear(String input) {
		// 初始化两个栈,s1放运算符，s2放中间结果
		Stack<Character> s1 = new Stack<>();
		Stack<Object> s2 = new Stack<>();

		// 从左到右扫描表达式
		int len = input.length();
		char c;
		char temChar;
		Double number; // 临时存放操作数
		int lastIndex = -1;
		for (int i = 0; i < len; i++) {
			c = input.charAt(i);
			if (Character.isDigit(c)) { // 如果是数字，表示扫描到一个操作数
				lastIndex = getLastIndex(input, i); // getLastIndex()：获取操作数后面的符号对应在整个表达式中的索引值
				number = Double.parseDouble(input.substring(i, lastIndex));
				i = lastIndex - 1;
				System.out.print(number + " ");
				s2.push(number);
			} else if (isOperator(c)) { // 如果是操作符+-*/
				while (!s1.isEmpty() && s1.peek() != '(' && priorityCompare(c, s1.peek()) <= 0) {
					System.out.print(s1.peek() + " ");
					// s2.push(s1.pop());
					// 在这个循环里进行计算
					double num2 = (double) s2.pop();
					double num1 = (double) s2.pop();
					s2.push(cal(num1, num2, s1.pop()));
				}
				s1.push(c);
			} else if (c == '(') {
				s1.push(c);
			} else if (c == ')') {
				while ((temChar = s1.pop()) != '(') { // !!! 当s1.pop()='('时，删除
					System.out.print(temChar + " ");
					// s2.push(temChar);
					double num2 = (double) s2.pop();
					double num1 = (double) s2.pop();
					s2.push(cal(num1, num2, temChar));
				}
			} else {
				// 其他情况什么都不做
			}
		}
		while (!s1.isEmpty()) {
			System.out.println(s1.peek() + " ");
			// s2.push(s1.pop());
			double num2 = (double) s2.pop();
			double num1 = (double) s2.pop();
			s2.push(cal(num1, num2, s1.pop()));
		}
		return (Double) s2.pop();
	}

	// 实现计算的方法
	public static double cal(double num1, double num2, char op) {
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			if (num2 == 0)
				throw new IllegalArgumentException("devisor can not be zero!");
			return num1 / num2;
		default:
			return 0;
		}
	}

	// 定义一个比较优先级的方法，op1---op2:<-1,=0,>1
	public static int priorityCompare(char op1, char op2) {
		if (op1 == '+' || op1 == '-') {
			return (op2 == '*' || op2 == '/') ? -1 : 0;
		}
		if (op2 == '+' || op2 == '-') {
			return (op1 == '*' || op1 == '/') ? 1 : 0;
		}
		return 1;
	}

	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		} else {
			return false;
		}
	}

	public static int getLastIndex(String input, int start) {
		int len = input.length();
		char c;
		int rs = -1;
		for (int i = start; i < len; i++) {
			c = input.charAt(i);
			if (c == '.') {
				continue;
			} else if (!Character.isDigit(c)) {
				rs = i;
				break;
			} else if (i == len - 1) {
				rs = len;
			}
		}
		return rs;
	}

}
