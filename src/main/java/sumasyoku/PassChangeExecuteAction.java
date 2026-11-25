package sumasyoku;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PassChangeExecuteAction extends Action {

    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        HttpSession session = req.getSession();

        Users user =
                (Users) session.getAttribute("user");

        String currentPassword =
                req.getParameter("currentPassword");

        String newPassword =
                req.getParameter("newPassword");

        String confirmPassword =
                req.getParameter("confirmPassword");

        // 現在のパスワード確認
        if (!user.getPassword().equals(currentPassword)) {

            req.setAttribute("msg",
                    "現在のパスワードが違います");

            req.getRequestDispatcher("pass_change.jsp")
               .forward(req, res);
            return;
        }

        // 確認用パスワード確認
        if (!newPassword.equals(confirmPassword)) {

            req.setAttribute("msg",
                    "確認用パスワードが一致しません");

            req.getRequestDispatcher("pass_change.jsp")
               .forward(req, res);
            return;
        }

        // パスワード更新
        user.setPassword(newPassword);

        UsersDao dao = new UsersDao();

        dao.save(user);

        session.setAttribute("user", user);

        res.sendRedirect("Top.action");
    }
}