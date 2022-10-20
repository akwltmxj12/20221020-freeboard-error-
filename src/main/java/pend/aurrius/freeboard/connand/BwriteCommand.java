package pend.aurrius.freeboard.connand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pend.aurrius.freeboard.dao.BoardDao;

public class BwriteCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("title");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao();
		dao.write(bname, btitle, bcontent, bcontent, 0);
		
		
		
		
		
		
		
		
		
	}

}
