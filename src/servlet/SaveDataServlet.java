package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Myutil;

/**
 * Servlet implementation class SaveDataServlet
 */
public class SaveDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time=request.getParameter("time");
		String sumNum =request.getParameter("sumNum");		
		String path = request.getParameter("path");
		String B1C = request.getParameter("B1C");
		String B2C = request.getParameter("B2C");
		String B3C = request.getParameter("B3C");
		String speedP1 = request.getParameter("speedP1");
		String speedP2 = request.getParameter("speedP2");
		String speedCom= request.getParameter("speedCom");
		String consumerNum = request.getParameter("consumerNum");
		String speedCon= request.getParameter("speedCon");

		String str=String.format("{'B1C':%s,'B2C':%s,'B3C':%s,'speedP1':%s,'speedP2':%s,'speedCom':%s,'consumerNum':%s,'speedCon':%s,'time':%s,'sumNum':%s}", B1C,B2C,B3C,speedP1,speedP2,speedCom,consumerNum,speedCon,time,sumNum);
		Myutil.addSrring2File(path, str+"\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
