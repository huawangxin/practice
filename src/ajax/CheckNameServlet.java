package src.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ajax的get提交
 * @author huawangxin
 *
 * 
 * @date 2016年11月9日 下午3:21:05
 */
public class CheckNameServlet extends HttpServlet {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 7746202105447656137L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取传入的要验证的用户名
		String uname = request.getParameter("uname");
		//使用下面这句的解码原因是因为容器
		//默认的解码方式是iso-8859-1【我测试时用的是tomcat设置为gbk】
		//所以，如果修改了容器的默认解码方式，
		//则下面的语句就不需要了 
		uname = new String(uname.getBytes("gbk"),"utf-8");
		System.out.println(uname);
		//根据验证结果返回对应的说明信息
		if(uname.equals("张三")){
			out.print("用户名重复");
		}else{
			out.println("该用户名可以使用");
		}
		out.close();
	}

}
