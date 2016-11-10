package src.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*获取表单提交的信息后，保存到t_emp表中*/
public class AddEmpServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7703266398690556611L;

	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age=Integer.parseInt(request.getParameter("age"));*/
		String name="张三";
		double salary=10000.00;
		int age=25;
		//将以上三个数据放入查询语句中
		//加载驱动
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rs =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//获取连接
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.71.90:1521:orcl","huawangxin","huawangxin");
			//创建命令对象
			ps=con.prepareStatement("insert into t_emp_wangxin values(emp_id_seq_wangxin.nextval,?,?,?)");
			//替换问号
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, age);
		    //执行语句
			int i=ps.executeUpdate();
			String sql = "SELECT * FROM t_emp_wangxin " ;
			ps1=con.prepareStatement(sql);
			rs =ps1.executeQuery() ;
			out.println("<HTML>");
			out.println("<HEAD></HEAD>");
			out.println("<BODY>");
			out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
			out.println("<caption>员工信息列表</caption>");
			out.println("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td></tr>");
			while (rs.next()) {
				int id=rs.getInt("id");
				String name1 = rs.getString("name") ;
				Double salary1=rs.getDouble("salary");
				int age1 = rs.getInt("age") ;
				out.println("<tr><td>"+id+"</td><td>"+name1+"</td><td>"+salary+"</td><td>"+age1+"</td><tr>");
			}
			out.print("</table>");
			out.print("<a href='addEmp.html'>增加员工信息</a>");
			out.println("</BODY>");
			out.println("</HTML>");
			rs.close() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(con!=null){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			out.println("添加成功");
			out.close();
		}
	}
}
