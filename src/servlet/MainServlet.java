package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MyController;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int B1C =Integer.parseInt(request.getParameter("B1C"));
		int B2C = Integer.parseInt(request.getParameter("B2C"));
		int B3C = Integer.parseInt(request.getParameter("B3C"));
		int speedP1 = Integer.parseInt(request.getParameter("speedP1"));
		int speedP2 = Integer.parseInt(request.getParameter("speedP2"));
		int speedCom= Integer.parseInt(request.getParameter("speedCom"));
		int consumerNum = Integer.parseInt(request.getParameter("consumerNum"));
		int speedCon= Integer.parseInt(request.getParameter("speedCon"));
		
		
		//MyController.crun(3,3,20,1,3,1,3,1,1,1,10);  // 3,3,1,100数据在第box3堆积       ->失败   (如果不启动消费者线程则成功  )  ->更改buffer模式后成功
		//MyController.crun(3,3,20,1,10,1,10,1,1,1,1);  // 10,10,1,1数据在box4 堆积           ->失败              				->更改buffer模式后成功
		//MyController.crun(3,3,20,1,3,1,3,1,10,1,10);    // 1,1,3,3  数据在box1和box2堆积    ->成功	  ->更改buffer模式后(伪成功)	
		System.out.println("------------------------系统运行---------------------------------");
		MyController.crun( B1C, B2C, B3C, 1, speedP1, 1, speedP2, 1,speedCom,consumerNum, speedCon);
		//System.out.println(B1C);
		//request.getRequestDispatcher("index.html").forward(request,response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
