package array;

public class ArrayTest3 {
	public static void main(String[] args) {
		
		ArrayClassBub arrayClassBub = new ArrayClassBub(100);
		
		arrayClassBub.insert(15);
		arrayClassBub.insert(44);
		arrayClassBub.insert(55);
		arrayClassBub.insert(22);
		arrayClassBub.insert(36);
		arrayClassBub.insert(99);
		arrayClassBub.insert(88);
		arrayClassBub.insert(67);
		arrayClassBub.insert(62);
		arrayClassBub.insert(78);
		arrayClassBub.insert(23);
		arrayClassBub.insert(14);
		arrayClassBub.insert(89);
		arrayClassBub.insert(56);
		arrayClassBub.insert(58);
		arrayClassBub.insert(82);
		arrayClassBub.insert(13);
		
		arrayClassBub.display();
		
		arrayClassBub.bubSort();
		arrayClassBub.display();
	}
}



class ArrayClassBub {
	private long[] arr; // 被封装的数组
	private int nElems; // 数组中存在元素的个数，当前长度

	// 通过数组类的构造方法初始化
	public ArrayClassBub(int maxSize) { // maxSize是数组的最大长度
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
	
	//实现冒泡排序法,为无序数组排序，从小到大
	public void bubSort() {
		int outer;
		int inner;
		for(outer = nElems - 1; outer > 0 ; outer--) {
			for(inner = 0; inner < outer; inner++) {
				if(arr[inner] > arr[inner + 1]) { //前面元素大于后面元素，交换位置
					long temp = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = temp;
				}
			}
			inner = 0; //下一轮循环让inner回到第一个元素
		}
	}
}