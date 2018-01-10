package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Box;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class DataServlet
 */
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int num1=Box.getSize1();
		int num2=Box.getSize2();
		int num3=Box.getSize3();
		int num4=Box.getSize4();
		int num5=Box.getBlock();
		int freeBox1=Box.getBox1C()-Box.getSize1();
		int freeBox2=Box.getBox2C()-Box.getSize2();
		int freeBox3=Box.getBox3C()-Box.getSize3();
		int box4Size=Box.getSize4();
		int blockNum=Box.getBlock();
		String str = String.format("{\"num1\":%s,\"num2\":%s,\"num3\":%s,\"num4\":%s,\"num5\":%s,\"freeBox1\":%s,\"freeBox2\":%s,\"freeBox3\":%s,\"box4Size\":%s,\"blockNum\":%s}",num1,num2,num3,num4,num5,freeBox1,freeBox2,freeBox3,box4Size,blockNum);	
		JSONObject json = JSONObject.fromObject(str);
		out.println(str);
		out.flush();
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		return;		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
