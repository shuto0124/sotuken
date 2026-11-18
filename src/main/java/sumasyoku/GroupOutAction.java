package sumasyoku;

import bean.Users;
import dao.GroupsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GroupOutAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        GroupsDao dao = new GroupsDao();
        
        // DAOにある exitGroupメソッド を呼び出す
        dao.exitGroup(user);
       

        response.sendRedirect("Group.action");
    }
}