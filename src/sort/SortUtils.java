package sort;

/**
 * 排序工具类
 * @author huawangxin
 *
 * 
 * @date 2016年11月3日 下午1:37:00
 */
public class SortUtils {

	public static void main(String[] args) {
		
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
	@SuppressWarnings("unused")
	private static int tempNum=0;
	/**
	 * 冒泡排序
	 * @param num
	 * @return
	 */
	public static int[] bubbleSort(int[] num){
		for(int i=0;i<num.length-1;i++){
			for(int j=i+1;j<num.length;j++){
				if(num[i]>num[j]){
					tempNum=num[i];
					num[i]=num[j];
					num[j]=num[i];
				}
			}
		}
		return num;
	}
	

}
