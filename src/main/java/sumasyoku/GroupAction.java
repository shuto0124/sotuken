package sumasyoku;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GroupAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//       String actionType = request.getParameter("type");
        
        HttpSession session=request.getSession();
        
        UsersDao userDao =new UsersDao();
        
        Users users=(Users)session.getAttribute("user");
        
        int userNumber = users.getUserNumber();
        
        
//        int groupNumber=users.getGroups().getGroupNumber();
        
        Users user = userDao.get(userNumber);
        
        

//        if ("join".equals(actionType)) {
//            String groupId = request.getParameter("groupId");
//        } else if ("leave".equals(actionType)) {
//        }
        
        
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("group.jsp").forward(request, response);
    }
}