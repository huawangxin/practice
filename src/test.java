import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class test {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Map<String, Object> zhuxtData=new HashMap<String, Object>();
		String[] zhuxtName=new String[zhuxtData.size()];
		int[] zhuxtNum=new int[zhuxtData.size()];
		zhuxtData.put("鹿城区司法局1111",0);
//		for(int i=1;i<zhuxtData.size();i++){
//			zhuxtName[i]="a";
//		}
		
		Iterator it=zhuxtData.keySet().iterator();
		int i=1;
		Set<Entry<String, Object>> entries = zhuxtData.entrySet();

		for (Entry<String, Object> entry : entries) {
			Object key=entry.getKey();
			Object value=entry.getValue();
			if(i<=zhuxtData.size()){
				zhuxtName[i]="a";
			}
			i++;
//			zhuxtNum[i]
//			System.out.println(entry.getKey()+":"+entry.getValue()); 
//			zhuxtName[i]=entry.getKey();
			i++;
		}
		System.out.println(zhuxtName);
		
	}
}
