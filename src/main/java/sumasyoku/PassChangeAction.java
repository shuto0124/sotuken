package sumasyoku;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PassChangeAction extends Action {

    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        req.setCharacterEncoding("UTF-8");

        String currentPass = req.getParameter("currentPass");
        String newPass = req.getParameter("newPass");

        if (currentPass == null && newPass == null) {
            req.getRequestDispatcher("pass_change.jsp").forward(req, res);
            return;
        }

        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user");

        if (user == null || currentPass == null || !currentPass.equals(user.getPassword())) {
            req.setAttribute("error", "現在のパスワードが間違っています。");
            req.getRequestDispatcher("pass_change.jsp").forward(req, res);
            return;
        }

        UsersDao dao = new UsersDao();
        dao.changePassword(user, newPass);
        user.setPassword(newPass);

        req.getRequestDispatcher("pass_change_done.jsp").forward(req, res);
    }
}