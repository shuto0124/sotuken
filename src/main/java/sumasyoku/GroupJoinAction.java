package sumasyoku;

import bean.Users;
import dao.GroupsDao;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GroupJoinAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        int groupNumber = Integer.parseInt(request.getParameter("groupId"));

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        GroupsDao dao = new GroupsDao();
        dao.joinGroup(user, groupNumber);
        
        UsersDao uDao = new UsersDao();
        user = uDao.get(user.getUserNumber());
        if (user != null) {
            session.setAttribute("user", user);
        }
        
//        request.setAttribute("user", user);

        response.sendRedirect("Group.action");
    }
}