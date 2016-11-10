package src.random;

/**
 * 简单抽奖线程
 * @author huawangxin
 *
 * math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
 * math.ceil(x)返回大于参数x的最小整数,即对浮点数向上取整
 * @date 2016年11月10日 下午2:41:36
 */
public class Choujiang {
 public static void main(String[]args){
  double a = Math.random()*10;  a = Math.ceil(a);
  int randomnum = new Double(a).intValue();
  System.out.println(randomnum);
  int b=randomnum;
  if (b==1){
	  System.out.println("您抽到的是一等奖");
  }else if  (b>1|b<4){
	  System.out.println("您抽到的是二等奖");
  }else if  (b>3|b<7){
	  System.out.println("您抽到的是三等奖");
  }else if  (b>6){
	  System.out.println("谢谢参与");  
  }
 } 
}