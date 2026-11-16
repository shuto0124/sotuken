package sumasyoku;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ManegementsAction extends Action{
	public void execute(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.getRequestDispatcher("manegements.jsp").forward(request, response);
	}
}