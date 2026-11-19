package sumasyoku;

import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsersDeleteExecuteAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        request.setCharacterEncoding("UTF-8");
        
        String userNumberStr = request.getParameter("user_number");
        
        int userNumber = Integer.parseInt(userNumberStr);
        
        UsersDao userdao = new UsersDao();
        
        userdao.deleteUser(userNumber);
        
        request.getRequestDispatcher("users_delete_done.jsp").forward(request, response);
    }
}