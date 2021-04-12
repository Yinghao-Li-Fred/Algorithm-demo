package array;

public class ArrayTest6 {
	public static void main(String[] args) {
		//一般的二维数组，浪费内存空间，读数据效率高： 空间换时间
		long[][] arr = new long[9][7]; //占用63个内存空间
		arr[1][1] = 3;
		arr[3][0] = 1;
		arr[3][1] = 4;
		arr[4][2] = 7;
		arr[5][5] = 5; //一般这种数组在输出显示时效率高
		
		for(int i = 0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}

		//对稀疏数组进行压缩
		Node[] nodes = new Node[6];
		nodes[0] = new Node(9, 7, 5);
		nodes[1] = new Node(1, 1, 3);
		nodes[2] = new Node(3, 0, 1);
		nodes[3] = new Node(3, 1, 4);
		nodes[4] = new Node(4, 2, 7);
		nodes[5] = new Node(5, 5, 5);
		
		System.out.println("-----------------------");
		
		for(int i=0; i<nodes[0].getRow(); i++) {
			for(int j=0; j<nodes[0].getCol(); j++) {
				//判断当前(i,j)坐标是否有值，没有输出0
				int k;
				for(k=1; k < nodes.length; k++) {
					if(nodes[k].getRow()==i && nodes[k].getCol()==j)
						 break;
				}
				
				if(k < nodes.length) { //证明这里存在有效内容值
						System.out.print (nodes[k].getVal() + "  ");
				} else {
						System.out.print("0" + "  ");
				}
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}
}

class Node {
	private int row;
	private int col;
	private long val;
	
	public Node(int row, int col, long val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public long getVal() {
		return val;
	}
	
}




