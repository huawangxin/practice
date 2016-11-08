package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckName2Servlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取post方式提交的中文
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uname = 
			request.getParameter("uname");
		System.out.println(uname);
		if(uname.equals("张三")){
			out.print("用户名重复");
		}else{
			out.print("用户名可以使用");
		}
		out.close();
	}

}
