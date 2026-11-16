package sumasyoku;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class AdministratorLoginAction extends Action{
	public void execute(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.getRequestDispatcher("administratorlogin.jsp").forward(request, response);
	}
}