package pend.aurrius.freeboard.connand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Bcommand {

	
		public void execute(HttpServletRequest request, HttpServletResponse response);
}
