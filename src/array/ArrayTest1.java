package array;

public class ArrayTest1 {
	public static void main(String[] args) {
		ArrayClass arrayclass = new ArrayClass(100);

		// 新增数组元素
		arrayclass.insert(11);
		arrayclass.insert(23);
		arrayclass.insert(45);
		arrayclass.insert(21);
		arrayclass.insert(66);
		arrayclass.insert(44);
		arrayclass.insert(77);
		arrayclass.insert(99);
		arrayclass.insert(88);
		arrayclass.insert(33);
		
		arrayclass.display();
		
		//删除数据77
		arrayclass.delete(77);
		arrayclass.display();
		
		//查找数据
		System.out.println(arrayclass.find(44));
	}
}

/**
 * 创建一个封装数组的类
 * 
 * @author fred0
 *
 */
class ArrayClass {
	private long[] arr; // 被封装的数组
	private int nElems; // 数组中存在元素的个数，当前长度

	// 通过数组类的构造方法初始化
	public ArrayClass(int maxSize) { // maxSize是数组的最大长度
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

}