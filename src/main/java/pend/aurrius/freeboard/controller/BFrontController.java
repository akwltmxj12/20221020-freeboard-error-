package pend.aurrius.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pend.aurrius.freeboard.connand.Bcommand;
import pend.aurrius.freeboard.connand.BwriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("utf-8");   // 이걸 하지않으면 글자가깨짐.
				
				String uri = request.getRequestURI(); 		// 클라이언트가 요청한 URI 전부 가져오기
				String conPath = request.getContextPath();
				String comm = uri.substring(conPath.length()); // 전체 URI에서 context 경로 길이만큼 빼기
				
				Bcommand command = null;
				
				
				if(comm.equals("/write.do")) {					
					System.out.println("write.do 요청!");
					
					 command = new BwriteCommand();	
					 command.execute(request, response); 
					
					 
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/list.do");
					 dispatcher.forward(request, response);
					
				} else if(comm.equals("/list.do")) {
					System.out.println("list.do 요청!");
					
					
				 command = new BwriteCommand();	// 상속받았으므로 임포트하지않아도된다.
				 command.execute(request, response); 
				 // request객체에 글 리스트가 셋팅됨
				 
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
				 dispatcher.forward(request, response);
				}
				
				  	
		
		
	}
	

}
