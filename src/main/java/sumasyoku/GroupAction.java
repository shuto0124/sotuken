package sumasyoku;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GroupAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String actionType = request.getParameter("type");
        
        HttpSession session=request.getSession();
        
        UsersDao userDao =new UsersDao();
        
        Users user=(Users)session.getAttribute("user");
        
        int groupNumber=user.getGroups();

//        if ("join".equals(actionType)) {
//            String groupId = request.getParameter("groupId");
//        } else if ("leave".equals(actionType)) {
//        }
        
        
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("group.jsp").forward(request, response);
    }
}