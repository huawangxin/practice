package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


public class GetEmpServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Employee e1 = new Employee(1,"张三",2000,20);
		JSONObject jsonObj = 
			JSONObject.fromObject(e1);
		String str = jsonObj.toString();
		out.print(str);
		out.close();
	}

}
