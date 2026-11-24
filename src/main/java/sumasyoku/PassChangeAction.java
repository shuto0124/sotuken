package sumasyoku;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import bean.Users;
import dao.UsersDao;
import tool.Action;

public class PassChangeAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setCharacterEncoding("UTF-8");

        String currentPass = req.getParameter("currentPass");
        String newPass = req.getParameter("newPass");

        if (currentPass != null && newPass != null) {
            UsersDao dao = new UsersDao();
            Users sessionUser = (Users) req.getSession().getAttribute("user");
            Users dbUser = dao.get(sessionUser.getUserNumber());

            if (dbUser == null || !currentPass.equals(dbUser.getPassword())) {
                req.setAttribute("error", "現在のパスワードが間違っています");
            } else {
                dao.updatePassword(dbUser, newPass);
                req.getSession().setAttribute("user", dao.get(sessionUser.getUserNumber()));
                req.setAttribute("message", "パスワードを変更しました");
            }
        }

        req.getRequestDispatcher("passwordchange.jsp").forward(req, res);
    }
}