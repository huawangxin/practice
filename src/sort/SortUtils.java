package src.sort;

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
	 * 从数列中挑出一个元素，称为“基准” 重新排序数列，
	 * 所有元素比基准值小的摆放在基准前面，所有元素比
	 * 基准值大的摆在基准的后面（相同的数可以到任一边）。
	 * 在这个分割之后，该基准是它的最后位置。这个称为分割（partition）操作。
	 * @param num
	 * @param start
	 * @param end
	 * @return
	 */
	public static int[] quickSort(int[] num,int start,int end){
		if(start<end){
			int base=num[start];
			int i=start,j=end;
			while(num[j]>base&&j>=start){
				j--;
			}
			while(num[i]<base&&i<end){
				i++;
			}
			if(i<=j){
				tempNum=num[i];
				num[i]=num[j];
				num[j]=tempNum;
				i++;
				j--;
			}
			if(start<j){
				num=quickSort(num, start, j);
			}
			if(end>i){
				num=quickSort(num, i, end);
			}
		}
		return num;
	}
	/**
	 * 选择排序
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
}
