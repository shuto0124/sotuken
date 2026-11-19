package sumasyoku;


import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsersDeleteAction extends Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String userNumberStr = request.getParameter("user_number");
		
	    int userNumber = Integer.parseInt(userNumberStr);
		
	    UsersDao userdao = new UsersDao();
		
	    Users user = userdao.get(userNumber);
	    
	    request.setAttribute("user", user);
	    

	    request.getRequestDispatcher("users_delete.jsp")
	           .forward(request, response);
	}
}