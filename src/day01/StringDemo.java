package day01;
/**
 * �ַ����������Ĳ���
 * @author Administrator
 *
 */
public class StringDemo {
	public static void main(String[] args){
									 //������,ֱ����
			String str = "helloworld";	
			String str2 = "helloworld";	
			String str3 = "helloworld";
			/*
			 * java�ڱ����ʱ������һ���Ż�
			 * ���������ߵ����ݶ�������������
			 * ����м��㣬��������ɵ�������
			 * �ֽ����ļ��У��������ֽ����ļ���
			 * ���ǿ���������������:
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


