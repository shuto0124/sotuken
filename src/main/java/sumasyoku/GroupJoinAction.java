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
        String result = dao.joinGroup(user, groupNumber);
        
        UsersDao uDao = new UsersDao();
        user = uDao.get(user.getUserNumber());
        if (user != null) {
            session.setAttribute("user", user);
        }
        
        if ("満員".equals(result)) {
       	 request.setAttribute("error", "グループが満員です");
       	 request.getRequestDispatcher("group.jsp").forward(request, response);
       	 return;
        }else if ("グループが見つからない".equals(result)) {
       	 request.setAttribute("error", "グループが見つかりませんでした");
       	 request.getRequestDispatcher("group.jsp").forward(request, response);
       	 return;
        }
        
//        request.setAttribute("user", user);

        response.sendRedirect("Group.action");
    }
}