package array;

public class ArrayTest2 {
	public static void main(String[] args) {
		OrderArray orderArray = new OrderArray(100);
		
		orderArray.insert(15);
		orderArray.insert(44);
		orderArray.insert(55);
		orderArray.insert(22);
		orderArray.insert(36);
		orderArray.insert(99);
		orderArray.insert(88);
		orderArray.insert(67);
		orderArray.insert(62);
		orderArray.insert(78);
		orderArray.insert(23);
		orderArray.insert(14);
		orderArray.insert(89);
		orderArray.insert(56);
		orderArray.insert(58);
		orderArray.insert(82);
		orderArray.insert(13);
		
		orderArray.display();
		
		System.out.println(orderArray.find(22));
	}
}


class OrderArray {
	private long arr[];
	private int nElems;
	
	public OrderArray(int maxSize) {
		arr = new long[maxSize];
		nElems = 0;
		}
	
	//插入新的数据项
	public void insert(long data) {
		//找到插入数据的位置
		int i;
		for(i=0; i<nElems; i++) {
			if(arr[i] > data) 
				break;
		}
		
		//找到和没找到
		if(i < nElems) { //找到插入位置的情况
			for(int j = nElems; j>i; j--) {
				if(j < arr.length) arr[j] = arr[j-1];
			}
			arr[i] = data;
			nElems++;
		} else { //没找到
			if(nElems < arr.length) arr[nElems] = data;
			nElems++;
		}
	}
	
	//遍历
	public void display() {
		for(int i=0; i<nElems; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
	
	//查找某个指定的元素，二分查找算法,返回找到数据在数组中的索引值,没找到返回数组当前长度
	public int find(long searchData) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curint; //对数组进行二分的时候，处在中间的元素对应的索引值
		
		while(true) {
			curint = (lowerBound + upperBound) / 2;
			if(arr[curint] == searchData) {
				return curint;
			} else if (lowerBound > upperBound) {
				//数组中没有找到指定元素
				return nElems;
			} else {
				if(arr[curint] > searchData) {
					upperBound = curint - 1;
				} else {
					lowerBound = curint + 1;
				}
			}
		}
	}
	
	//删除指定的某一个元素
	public void delete(long data) {
		int i = find(data);
		if(i < nElems) {
			for(int j=i; j<nElems; j++) {
				arr[j] = arr[j+1];
			}
			nElems--;
		}
	}
	
	
	
	
	
}

