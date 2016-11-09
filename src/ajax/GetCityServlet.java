package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


/**根据传入的城市value返回改城市的区域信息*/
public class GetCityServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//1.获取选中的城市
		String cv = 
			request.getParameter("cv");
		List<City> allCitys = 
			new ArrayList<City>();
		//2.查询对应的区域信息
		if(cv.equals("bj")){
			City c1 = new City("dc","东城");
			City c2 = new City("xc","西城");
			City c3 = new City("sjs","石景山");
			allCitys.add(c1);
			allCitys.add(c2);
			allCitys.add(c3);
		}else if(cv.equals("sh")){
			City c1 = new City("pd","浦东");
			City c2 = new City("ja","静安");
			allCitys.add(c1);
			allCitys.add(c2);
		}else{
			City c1 = new City("by","白云");
			City c2 = new City("py","番禺");
			allCitys.add(c1);
			allCitys.add(c2);
		}
		//3.将集合变成json格式的字符串
		JSONArray arr = 
			JSONArray.fromObject(allCitys);
		String result = 
			arr.toString();
		//4.将区域信息发回去		
		out.print(result);
		out.close();
	}

}
