package queue;

public class QueueTest1 {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue(3);
		myQueue.insert(1);
		myQueue.insert(2);
		myQueue.insert(3);
		
		System.out.println(myQueue.peek());
		while(!myQueue.isEmpty()) {
			System.out.println(myQueue.remove());
		}
	}
}


class MyQueue {
	private Object[] eleData;
	private int maxSize;
	private int rear;
	private int front;
	private int nElems;
	
	public MyQueue(int size) {
		this.maxSize = size;
		eleData = new Object[size];
		rear = -1;
		front = 0;
		nElems = 0;
	}
	
	public void insert(Object data) {
		if(nElems == maxSize) {
			System.out.println("This queue is full!");
		} else {
			if((rear+1) == maxSize) {
				rear = -1; 
			}
			eleData[++rear] = data;
			nElems++;
		}
	}
	
	public Object peek() {
		if(nElems == 0) {
			return null;
		}
		return eleData[front];
	}
	
	public Object remove() {
		Object removeObj = null;
		if(nElems != 0) {
			removeObj = eleData[front];
			eleData[front] = null;
			nElems--;
			if((front+1) == maxSize) {
				front = 0;
			} else {
				front++;
			}
		}
		return removeObj;
	}
	
	public boolean isEmpty() {
		return (nElems == 0);
	}
	
	public boolean isFull() {
		return (nElems == maxSize);
	}
	
	public int getSize() {
		return nElems;
	}
}