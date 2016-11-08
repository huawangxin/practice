package exam;

/**
 * 
 * @author huawangxin
 *
 * 2016年11月8日 下午10:46:00
 */
public class JudgeBoolean {

	public static void main(String[] args) {
		boolean bool=true;
		if(bool=false){
			System.out.println("a");
		}else if(bool){
			System.out.println("boolc");
		}else if(!bool){
			System.out.println("!boolc");
			System.out.println(bool=false);
		}else {
			System.out.println("d");
		}
	}

}
