package array;

public class ArrayTest4 {
	public static void main(String[] args) {
		ArrayClassSelect arrayClassSelect = new ArrayClassSelect(100);
		
		arrayClassSelect.insert(11);
		arrayClassSelect.insert(23);
		arrayClassSelect.insert(45);
		arrayClassSelect.insert(21);
		arrayClassSelect.insert(66);
		arrayClassSelect.insert(44);
		arrayClassSelect.insert(77);
		arrayClassSelect.insert(99);
		arrayClassSelect.insert(88);
		arrayClassSelect.insert(33);
		
		arrayClassSelect.display();
		
		arrayClassSelect.selectSort();
		arrayClassSelect.display();
		
	}
}

class ArrayClassSelect {
	private long[] arr; // 被封装的数组
	private int nElems; // 数组中存在元素的个数，当前长度

	// 通过数组类的构造方法初始化
	public ArrayClassSelect(int maxSize) { // maxSize是数组的最大长度
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

	// 实现选择排序算法,从小到达
	public void selectSort() {
		int outer;
		int inner;
		int min;

		for (outer = 0; outer < nElems - 1; outer++) {
			min = outer; // 每次循环初始化min指向outer的位置，剩下元素中的第1个
			for (inner = outer + 1; inner < nElems; inner++) {
				if (arr[min] > arr[inner]) {
					min = inner;
				}
			} // 每次循环完后，min指向的元素才是真正的最小元素（剩下的元素中）
				// 找到最小元素后，和outer指向的元素交换位置
			long temp = arr[outer];
			arr[outer] = arr[min];
			arr[min] = temp;
		}

	}

}
