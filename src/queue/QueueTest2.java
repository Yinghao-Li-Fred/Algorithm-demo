package queue;

import java.util.ArrayDeque;

public class QueueTest2 {
	public static void main(String[] args) {
		//把双端队列当栈来用
		//把双端队列当普通单项队列来用
		//使用双端队列
		DoubleEndedQueue queue = new DoubleEndedQueue();
		queue.addFirst(1);
		queue.addFirst(2);
		queue.addLast(3);
		queue.addLast(4);
		queue.addLast(5);
		queue.addLast(6);
		queue.addLast(7);
		queue.addLast(8);
		queue.addLast(9);
		queue.addLast(10);
		queue.addLast(11);
		queue.addLast(12);
		queue.addLast(13);
		queue.addLast(14);
		queue.addLast(15);
		queue.addLast(16);
		queue.addLast(17);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.removeFirst());
		}
	}
}


class DoubleEndedQueue {
	private Object[] elements;
	private int maxSize;
	private int head;
	private int tail;
	
	public DoubleEndedQueue() {
		maxSize = 16;
		elements = new Object[16]; // 16=2^4
		head = 0;
		tail = 0; //双端队列只有在空队列时，head==tail，添加数据后再相等，说明队列已满
	}
	
	//取模运算，实现指针在数组中无限循环
	public int getMod(int index) {
		if(index < 0) {
			index = index + maxSize;
		}
		if(index >= maxSize) {
			index = index - maxSize;
		}
		return index;
	}
	
	//头部插入
	public void addFirst(Object data) {
		//head = getMod(head -1);
		head = (head -1) & (maxSize - 1); //将头部指针向左边移动一位
		elements[head] = data;
		if(head == tail) { //队列已满，需要扩容
			expand();
		}
	}
	
	//尾部插入
	public void addLast(Object data) {
		elements[tail] = data;
		tail = getMod(tail + 1); 
		if(tail == head) {
			expand();
		}
	}
	
	//头部移除
	public Object removeFirst() {
		Object removeObj = null;
		if(head != tail) {
			removeObj = elements[head];
			elements[head] = null;
			head = getMod(head + 1);
		}
		return removeObj;
	}
	
	//尾部删除
	public Object removeLast() {
		Object removeObj = null;
		if(head != tail) {
			tail = getMod(tail - 1);
			removeObj = elements[tail];
			elements[tail] = null;
		}
		return removeObj;
	}
	
	//获取头部元素
	public Object peekFirst() {
		if(tail != head) {
			return elements[head];
		} else {
			return null;
		}
	}
	
	//获取尾部元素
	public Object peekLast() {
		if(tail != head) {
			int index = getMod(tail - 1);
			return elements[index];
		} else {
			return null;
		}
	}
	
	//扩容
	public void expand() {
		int newSize = maxSize << 1;
		Object[] newObjArr = new Object[newSize];
		//获取前端插入的数据的个数
		int n = maxSize - head;
		//获取后端插入的数据个数==head
		
		System.arraycopy(elements, head, newObjArr, 0, n); //把前端插入的数据，复制到了新数组的最前面
		System.arraycopy(elements, 0, newObjArr, n, head); //把后端插入的数据，复制到了新数组中前端插入的数据后面
		head = 0;
		tail = maxSize;
		this.maxSize = newSize;
		this.elements = newObjArr;
	}
	
	//取出双端队列的元素个数
	public int getSize() {
		return getMod(tail - head);
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return (head == tail);
	}
	
}
