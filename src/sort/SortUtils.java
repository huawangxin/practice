package src.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序工具类
 * @author huawangxin
 *
 * 
 * @date 2016年11月3日 下午1:37:00
 */
public class SortUtils {

	public static void main(String[] args) {
		int[] num={1,4,5,3,2};
		num=SortUtils.mergeSort(num,0,4);
		System.out.println();
	}
	/**
	 * 私有构造方法，禁止实例化  
	 */
	private SortUtils() {
		super();
	}
	/**
	 * 静态变量
	 */
	private static int tempNum=0;
	/**
	 * 冒泡排序
	 * 
	 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最
	 * 后一对。在这一点，最后的元素应该会是最大的数。
	 * @param num
	 * @return
	 */
	public static int[] bubbleSort(int[] num){
		for(int i=0;i<num.length-1;i++){
			for(int j=i+1;j<num.length;j++){
				if(num[i]>num[j]){
					tempNum=num[i];
					num[i]=num[j];
					num[j]=tempNum;
				}
			}
		}
		return num;
	}
	/**
	 * 快速排序
	 * 
	 * 从数列中挑出一个元素，称为“基准” 重新排序数列， 所有元素比基准值小的摆放在基准前面，所有元素比
	 * 基准值大的摆在基准的后面（相同的数可以到任一边）。 在这个分割之后，该基准是它的最后位置。这个称为分割（partition）操作。
	 * 
	 * @param num
	 * @param start
	 * @param end
	 * @return
	 */
	public static int[] quickSort(int[] num, int start, int end) {
		if (start < end) {
			int base = num[start];
			int i = start, j = end;
			while (num[j] > base && j >= start) {
				j--;
			}
			while (num[i] < base && i < end) {
				i++;
			}
			if (i <= j) {
				tempNum = num[i];
				num[i] = num[j];
				num[j] = tempNum;
				i++;
				j--;
			}
			if (start < j) {
				num = quickSort(num, start, j);
			}
			if (end > i) {
				num = quickSort(num, i, end);
			}
		}
		return num;
	}
	/**
	 * 简单选择排序
	 * 
	 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
	 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
	 * @param num
	 * @return
	 */
	public static int[] selectSort(int[] num){
		for(int i=0;i<num.length;i++){
			int k=i;
			for(int j=i+1;j<num.length;j++){
				if(num[k]>num[j]){
					k=j;
				}
			}
			tempNum=num[i];
			num[i]=num[k];
			num[k]=tempNum;
		}
		return num;
	}
	/**
	 * 堆排序 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
	 * 定义如下：具有n个元素的序列（h1,h2,…,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,…,n/2)时称之为堆。
	 * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树
	 * 可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，
	 * 这时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们
	 * 作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组
	 * 成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
	 * 
	 * @author huawangxin
	 * @param a
	 */
	public static int[] heapSort(int[] a) {
		int arrayLength = a.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxHeap(a, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			tempNum = a[0];
			a[0] = a[arrayLength - 1 - i];
			a[arrayLength - 1 - i] = tempNum;
		}
		return a;
	}
	/*
	 * 建堆函数
	 */
	private static void buildMaxHeap(int[] data, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 如果右子节点的值较大
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大的子节点的值
				if (data[k] < data[biggerIndex]) {
					// 交换他们
					tempNum = data[k];
					data[k] = data[biggerIndex];
					data[biggerIndex] = tempNum;
					// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	/**
	 * 直接插入排序
	 * 
	 * 从第一个元素开始，该元素可以认为已经被排序
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
	 * @param num
	 * @return
	 */
	public static int[] insertSort(int[] num){
		for(int i=1;i<num.length;i++){
			tempNum=num[i];
			for(int j=i;tempNum<num[j-1];j--){
				num[j]=num[j-1];
				num[j-1]=tempNum;
			}
		}
		return num;
	}
	/**
	 * 归并排序
	 * 
	 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
	 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置
	 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
	 * 重复步骤3直到某一指针达到序列尾
	 * 将另一序列剩下的所有元素直接复制到合并序列尾
	 * @param num
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] mergeSort(int[] num,int left,int right){
		if(left<right){
			int center=(left+right)/2;
			mergeSort(num, left, center);
			mergeSort(num, center+1, right);
			merge(num, left, center, right);
		}
		return num;
	}
	private static int[] merge(int[] data,int left,int center,int right){
		int [] tmpArr=new int[data.length];  
	    int mid=center+1;  
	    //third记录中间数组的索引  
	    int third=left;  
	    int tmp=left;  
	    while(left<=center&&mid<=right){  
	        //从两个数组中取出最小的放入中间数组  
	        if(data[left]<=data[mid]){  
	            tmpArr[third++]=data[left++];  
	        }else{  
	            tmpArr[third++]=data[mid++];  
	        }  
	    }  
	    //剩余部分依次放入中间数组  
	    while(mid<=right){  
	        tmpArr[third++]=data[mid++];  
	    }  
	    while(left<=center){  
	        tmpArr[third++]=data[left++];  
	    }  
	    //将中间数组中的内容复制回原数组  
	    while(tmp<=right){  
	        data[tmp]=tmpArr[tmp++];  
	    }
		return data;
	}
	/**
	 * 基数排序
	 * 
	 * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
	 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
	 * @return
	 * @huawangxin
	 */
	public static int[] radixSort(int[] num) {
		// 首先确定排序的趟数;
		int max = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		int time = 0;
		// 判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}
		// 建立10个队列;
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		// 进行time次分配和收集;
		for (int i = 0; i < time; i++) {
			// 分配数组元素;
			for (int j = 0; j < num.length; j++) {
				// 得到数字的第time+1位数;
				int x = num[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(num[j]);
				queue.set(x, queue2);
			}
			int count = 0;// 元素计数器;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					num[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
		return num;
	}
}
