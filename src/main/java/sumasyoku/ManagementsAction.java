package sumasyoku;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ManagementsAction extends Action{
	public void execute(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.getRequestDispatcher("managements.jsp").forward(request, response);
	}
}