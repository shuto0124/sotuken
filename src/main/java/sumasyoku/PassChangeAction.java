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

        HttpSession session = req.getSession();

        Users user = (Users) session.getAttribute("user");

        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");

        // ログインチェック
        if (user == null) {
            res.sendRedirect("Login.action");
            return;
        }

        // 未入力チェック
        if 
        (currentPassword == null || currentPassword.isEmpty()
                || newPassword == null || newPassword.isEmpty()
                || confirmPassword == null || confirmPassword.isEmpty()) {

            req.setAttribute("msg", "すべて入力してください");
            req.getRequestDispatcher("passwordChange.jsp")
               .forward(req, res);
            return;
        }

        // 現在パスワード確認
        if (!user.getPassword().equals(currentPassword)) {

            req.setAttribute("msg", "現在のパスワードが違います");
            req.getRequestDispatcher("passwordChange.jsp")
               .forward(req, res);
            return;
        }

        if (currentPassword.equals(newPassword)) {

            req.setAttribute("msg",
                    "現在と異なるパスワードを入力してください");
            req.getRequestDispatcher("passwordChange.jsp")
               .forward(req, res);
            return;
        }

        // 確認用パスワード確認
        if (!newPassword.equals(confirmPassword)) {

            req.setAttribute("msg",
                    "確認用パスワードが一致しません");
            req.getRequestDispatcher("passwordChange.jsp")
               .forward(req, res);
            return;
        }

        // パスワード更新
        user.setPassword(newPassword);

        UsersDao dao = new UsersDao();

        if (dao.save(user)) {

            session.setAttribute("user", user);
            res.sendRedirect("Top.action");

        } else {

            req.setAttribute("msg",
                    "パスワード変更に失敗しました");
            req.getRequestDispatcher("passwordChange.jsp")
               .forward(req, res);
        }
    }
}