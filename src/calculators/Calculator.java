package calculators;

import java.math.BigInteger;

/**
 * 百亿计算器
 * 
 * @author huawangxin
 *
 * 2016年11月8日 下午11:01:38
 */
public class Calculator {

	public static void main(String[] args) {
		int x=Integer.MAX_VALUE;
		int y=Integer.MIN_VALUE;
		BigInteger xBigInteger=BigInteger.valueOf((long)x);
		BigInteger yBigInteger=BigInteger.valueOf((long)y);
		System.out.println("x+y="+add(xBigInteger,yBigInteger));
	}
	public static BigInteger add(BigInteger x,BigInteger y){
		return x.add(y);
	}
	public static BigInteger subtract(BigInteger x,BigInteger y){
		return x.subtract(y);
	}
	public static BigInteger multiply(BigInteger x,BigInteger y){
		return x.multiply(y);
	}
	public static BigInteger divide(BigInteger x,BigInteger y){
		return x.divide(y);
	}
}
