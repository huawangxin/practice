package day01;
/**
 * 字符串不变对象的测试
 * @author huawangxin
 * 字符串比较时，
 * 
 * @date 2016年10月31日 下午1:38:01
 */
public class StringDemo {
	public static void main(String[] args){
									 //字面量,直接量
			String str = "helloworld";	
			String str2 = "helloworld";	
			String str3 = "helloworld";
			/*
			 * java在编译的时候做了一个优化
			 * 若计算两边的内容都是字面量，则
			 * 会进行计算，将结果生成到编译后的
			 * 字节码文件中，所以在字节码文件中
			 * 我们看到的是如下内容:
			 * String str4 = "helloworld";
			 */
			String str4 = "hello"+"world";
			String a = "hello";
			String str5 = a + "world";
			
			//true
			System.out.println(str == str2);
			//true
			System.out.println(str == str3);
			//true
			System.out.println(str == str4);
			//false
			System.out.println(str == str5);
			
			/**
			 * 双引号说明是字符串，如“12321”表示的是字符串12321（无双引号）；
单引号一般都是引用用的如“ ‘12321’ ”表示的是字符串“12321”.
他们的区别就是如果字符串中有“”，那么就要用‘’代替“”进行表示。
除了以上用法外，‘’还可以表示int类型（char转换过来的），如 int c ='A',结果就是65,'1'=49
			 */
			String s1 = "123abc";
			String s2 = 123 + "abc";
			String s3 = 1+"2"+3+"abc";
			String s4 = 1+2+"3"+"abc";
			String s5 = '1'+2+"3"+"abc";
			String s6 = "1"+'2'+3+"abc";
			//true
			System.out.println(s1==s2);
			//true
			System.out.println(s1==s3);
			//false
			System.out.println(s1==s4);
			//false
			System.out.println(s5);
			System.out.println(s1==s5);
			//true
			System.out.println(s1==s6);
	}
	
}


