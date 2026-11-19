package sumasyoku;

import bean.Groups;
import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsersUpdateExecuteAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        request.setCharacterEncoding("UTF-8");
        
        String userName = request.getParameter("user_name");
        
        String userNumberStr = request.getParameter("user_number");
        
        int userNumber = Integer.parseInt(userNumberStr);
        
        Users users= new Users();
        
        users.setUserName(userName);
        
        users.setAccountStatus(request.getParameter("accountStatus"));
        
        users.setPassword(request.getParameter("password"));
        
        users.setUserNumber(userNumber);
        
        Groups group = new Groups();
        group.setGroupNumber(
        	    Integer.parseInt(request.getParameter("groupNumber"))
        	);

        users.setGroups(group);
        
        UsersDao userDAO = new UsersDao();
        
        if (userName == null || userName.isEmpty()) {

            Users user = userDAO.get(userNumber);
            
            request.setAttribute("error", "氏名を入力してください");
            request.setAttribute("user", user);

            
            request.getRequestDispatcher("users_update.jsp").forward(request, response);
            return;
        }

        
        userDAO.save(users);
        

        request.getRequestDispatcher("users_update_done.jsp").forward(request, response);
    }
}