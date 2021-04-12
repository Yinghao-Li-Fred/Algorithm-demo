package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackTest2 {
	public static void main(String[] args) {
		HightStack highStack = new HightStack();
		
		highStack.push(1);
		highStack.push(12);
		highStack.push(23);
		highStack.push(2);
		highStack.push(56);
		highStack.push(24);
		highStack.push(18);
		highStack.push(89);
		highStack.push(21);
		highStack.push(87);
		highStack.push(30);
		
		while(!highStack.isEmpty()) {
			System.out.println(highStack.pop());
		}
	}
}


class HightStack {
	private Object[] elemData;
	private int maxSize;
	private int top;
	
	public HightStack() {
		elemData = new Object[10];
		this.maxSize = 10;
		top = -1;
	}
	
	//压栈
	public void push(Object data) {
		if((top + 1) == maxSize) { //栈已满 
			if((maxSize << 1) - Integer.MAX_VALUE > 0) {
				maxSize = Integer.MAX_VALUE;
			} else {
				maxSize = maxSize << 1; //数会变成原来的2倍
			}
			elemData = Arrays.copyOf(elemData, maxSize);
		}
		elemData[++top] = data;
	}
	
	//获取栈顶元素
	public Object peek() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		return elemData[top];
	}
	
	//出栈
	public Object pop() {
		Object object = peek();
		elemData[top] = null;
		this.top--;
		return object;
	}
	
	//判断是否为空栈
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//判断满栈
	public boolean isFull() {
		return (top == (maxSize -1));
	}
}
