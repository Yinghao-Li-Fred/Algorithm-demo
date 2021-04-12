package stack;

public class StackTest1 {
	public static void main(String[] args) {
		LowerStack lowerStack = new LowerStack(3);
		lowerStack.push(1);
		lowerStack.push(2);
		lowerStack.push(3);
		
		System.out.println(lowerStack.peek());
		
		while(!lowerStack.isEmpty()) {
			System.out.println(lowerStack.pop());
		}
		
		System.out.println(lowerStack.isEmpty());
	}
}

//模拟栈的数据结构
class LowerStack {
	private long[] elemData; //栈的内部封装的数组，用来保存数据
	private int maxSize; //栈的长度
	private int top; //栈顶指针，空栈是-1
	
	public LowerStack( int size) {
		this.maxSize = size;
		elemData = new long[size];
		top = -1;
	}
	
	//实现压栈
	public void push(long data) {
		//判断栈是否已满
		if(top != (maxSize - 1)) {
			elemData[++top] = data;
		}
	}
	
	//实现出栈
	public long pop() {
		return elemData[top--];
	}
	
	//读栈，不删除元素
	public long peek() {
		return elemData[top];
	}
	
	//判断空栈
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//判断满栈
	public boolean isFull() {
		return (top == (maxSize - 1));
	}
}
