import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testMap {

	public static void main(String[] args) {
		Map<String,Object> zhuxtData=new HashMap<String, Object>();
		zhuxtData.put("1号", 1);
		zhuxtData.put("2号", 2);
		zhuxtData.put("3号", 3);
		zhuxtData.put("4号", 4);
		zhuxtData.put("5号", 5);
		//集合方式实现数组
		List<String> nameList=new ArrayList<String>();//[2号, 5号, 4号, 3号, 1号]
		List<Integer> numList=new ArrayList<Integer>();//[2, 5, 4, 3, 1]
		for (Map.Entry<String, Object> entry : zhuxtData.entrySet()) {
			nameList.add(entry.getKey());
			numList.add(Integer.valueOf(entry.getValue()+""));
		}
		int size1 = nameList.size();  
		String[] zhuxtName = (String[])nameList.toArray(new String[size1]);
		int size2 = numList.size();  
		Integer[] array_num = (Integer[])numList.toArray(new Integer[size2]);
		int[] zhuxtNum = new int[array_num.length];
		for(int i=0; i < array_num.length; i ++)
		{
			zhuxtNum[i] = array_num[i].intValue();
		}
		System.out.println(Arrays.toString(zhuxtNum));
	}

}
