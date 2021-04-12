package array;

public class ArrayTest5 {
	public static void main(String[] args) {
		ArrayClassInsert arrayClassInsert = new ArrayClassInsert(100);
		
		arrayClassInsert.insert(11);
		arrayClassInsert.insert(6);
		arrayClassInsert.insert(18);
		arrayClassInsert.insert(21);
		arrayClassInsert.insert(45);
		arrayClassInsert.insert(23);
		arrayClassInsert.insert(89);
		arrayClassInsert.insert(85);
		arrayClassInsert.insert(56);
		arrayClassInsert.insert(98);
		
		arrayClassInsert.display();
		
		arrayClassInsert.insertSort();
		arrayClassInsert.display();
		
	}
}


class ArrayClassInsert {
	private long[] arr; // 被封装的数组
	private int nElems; // 数组中存在元素的个数，当前长度

	// 通过数组类的构造方法初始化
	public ArrayClassInsert(int maxSize) { // maxSize是数组的最大长度
		arr = new long[maxSize]; // 初始化被封装的数组
		nElems = 0;
	}

	// 新增数据项，数组元素
	public void insert(long data) {
		arr[nElems] = data;
		nElems++;
	}

	// 查找某一特定的数据项,找到了返回true
	public boolean find(long searchData) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (searchData == arr[i]) {
				break;
			} 
		}

		if (i == nElems) {
			return false; // 没找到指定的数据元素
		} else {
			return true;
		}

	}

	// 删除指定的数据项
	public void delete(long targetData) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (targetData == arr[i]) {
				break;
			}
		}

		if (i == nElems) {
			System.out.println("didn't find the elements: " + targetData);
		} else {
			for (int j = i; j < nElems; j++) {
				arr[j] = arr[j + 1]; // 删除元素，并且后面的元素向前移一位
			}
			nElems--;
		}

	}

	// 遍历数据结构中的各个数据项
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	//实现插入排序算法,从小到大
	public void insertSort() {
		int outer;
		int inner;
		long temp;
		
		for(outer = 1; outer < nElems; outer++) {
			inner = outer;
			temp = arr[outer];
			
			while(inner > 0 && arr[inner - 1] > temp) {
				arr[inner] = arr[inner - 1];
				--inner;
			}
			arr[inner] = temp;
		}
	}
	
	
	
	
	

}
