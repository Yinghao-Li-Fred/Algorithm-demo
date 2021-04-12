package stack;

import java.util.Stack;

public class StackTest4 {
	public static void main(String[] args) {
		String s = "12<a[b{c}]>";
		char[] sa = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		char ch;
		boolean flag = false; //最后：false，匹配有问题。true： 匹配正确
		for(char c:sa) {
			if(c=='<' || c=='[' || c=='{') {
				stack.push(c);
			}
			
			if(c=='>' || c==']' || c=='}') {
				ch = stack.pop();
				if((ch=='<' && c=='>') || (ch=='[' && c==']') || (ch=='{' && c=='}')) {
					flag = true;
				} else {
					flag = false;
					System.out.println("Character : " + ch + " and character : " + c + " are not matched!");
				}
			}
		}
		if(stack.isEmpty() && flag) {
			System.out.println("all characters matched! ");
		} else { 
			System.out.println("character matching failed! ");
		}
	}
}
