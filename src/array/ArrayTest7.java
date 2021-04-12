package array;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest7 {
	public static void main(String[] args) {
		MyArrayList arrayList = new MyArrayList();
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		arrayList.add("4");
		arrayList.add("5");
		arrayList.add("6");
		arrayList.add("7");
		arrayList.add("8");
		arrayList.add("9");
		arrayList.add("10");
		arrayList.add("11");

		arrayList.display();
		
		arrayList.delete("8");
		arrayList.display();
	}
}

class MyArrayList {
	private Object[] arr;
	private int nElems; // 当前数组真实长度

	public MyArrayList() {
		arr = new Object[10];
		nElems = 0;
	}

	// 实现插入数据项，注意要实现arr数组的自动扩容
	public void add(Object o) {
		// 判断nElems有没有越界
		if (nElems == arr.length) {
			arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
		}
		arr[nElems++] = o;
	}

	// 遍历
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	// 查找指定元素,找到了返回索引，找不到返回-1
	public int find(Object o) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (o.equals(arr[i])) {
				break;
			}
		}
		if (i < nElems) {
			return i;
		} else {
			return -1;
		}
	}
	
	//删除指定元素
	public void delete(Object o) {
		int i = find(o);
		if(i != -1) {
			System.arraycopy(arr, i+1, arr, i, nElems-1-i);
			nElems--;
		}
	}
	
	
	

}