package src.ajax;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * json格式转换
 * @author huawangxin
 *
 * 
 * @date 2016年11月9日 下午4:22:43
 */
public class TestJSON {

	public static void main(String[] args) {
		
	}
	/**
	 * java对象,java集合等-->Java字符串
	 */
	public static String f1(Object object){
		JSONObject jsonObject=JSONObject.fromObject(object);
		String result=jsonObject.toString();
		return result;
	}
	/**
	 * json字符串->java对象
	 * eg:{\"age\":22,\"id\":1,\"name\":\"张三\",\"salary\":2000}
	 * class属性返回的是Employee类型的描述信息
	 */
	public static Object f2(String str){
		JSONObject jsonObj=JSONObject.fromObject(str);
		Employee emp=(Employee)JSONObject.toBean(jsonObj,Employee.class);
		return emp;
	}
	/**
	 * json字符串-->java集合
	 * 
	 * eg:[{\"age\":22,\"id\":1,\"name\":\"张三\",\"salary\":2000},{\"age\":21,\"id\":2,\"name\":\"李四\",\"salary\":5000},{\"age\":20,\"id\":3,\"name\":\"王五\",\"salary\":8000}]
	 */
	@SuppressWarnings("unchecked")
	public static List<?> f3(String str){
		JSONArray arr=JSONArray.fromObject(str);
		List<Employee> list=(List<Employee>)JSONArray.toCollection(arr, Employee.class);
		return list;
	}
}
