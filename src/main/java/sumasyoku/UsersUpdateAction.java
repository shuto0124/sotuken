package sumasyoku;


import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsersUpdateAction extends Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String userNumberStr = request.getParameter("user_number");
				
	    int userNumber = Integer.parseInt(userNumberStr);

		
	    UsersDao userDao = new UsersDao();    	
		
	    Users users = userDao.get(userNumber);
	    
	    request.setAttribute("user", users);

	    request.getRequestDispatcher("users_update.jsp")
	           .forward(request, response);
	}
}