package queue;

public class QueueTest3 {
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(10);
		
		queue.insert(1);
		queue.insert(100);
		queue.insert(23);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
	}
}


class PriorityQueue {
	private int[] elements;
	private int nElms;
	
	public PriorityQueue(int size) {
		elements = new int[size];
		nElms = 0;
	}
	
	//插入数据
	public void insert(int data) {
		if(nElms == 0) {
			elements[nElms++] = data;
		} else {
			int j = nElms - 1;
			while(j>=0 && data>elements[j]) {
				elements[j+1] = elements[j];
				j--;
			}
			elements[j+1] = data;
			nElms++;
		}
	}
	
	public int peek() {
		if(nElms != 0) {
			return elements[nElms - 1];
		} else {
			return -1;
		}
	}
	
	public int remove() {
		int removeData = -1;
		if(nElms != 0) {
			removeData = elements[nElms - 1];
			elements[nElms - 1] = -1;
			nElms--;
		}
		return removeData;
	}
	
	public boolean isEmpty() {
		return nElms == 0;
	}
	
}
