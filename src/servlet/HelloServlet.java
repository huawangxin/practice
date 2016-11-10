package src.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class HelloServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1688840628760030434L;

	public void service(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = 
			response.getWriter();
		String tname = 
			request.getParameter("tname");
		String tpwd = 
			request.getParameter("tpwd");
		out.println(
			"tname:"+tname+"<br>tpwd:"+tpwd+"<br>hobby:");
		String[]  hobbys = 
			request.getParameterValues("c1");
		if(hobbys!=null){
			for(String s:hobbys){
				out.println(s+"&nbsp;");
			}
		}
		String gender = 
			request.getParameter("s1");
		out.println("<br>gender:"+gender);
		out.close();
	}
}
