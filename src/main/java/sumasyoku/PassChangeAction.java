package sumasyoku;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PassChangeAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();

        Users user = (Users) session.getAttribute("users");

        String currentPassword =
                req.getParameter("currentPassword");

        String newPassword =
                req.getParameter("newPassword");

        String confirmPassword =
                req.getParameter("confirmPassword");

        // 未入力チェック
        if (currentPassword == null || currentPassword.isEmpty()
                || newPassword == null || newPassword.isEmpty()
                || confirmPassword == null || confirmPassword.isEmpty()) {

            req.setAttribute("error", "すべて入力してください");
            req.getRequestDispatcher("passwordChange.jsp")
                    .forward(req, res);
            return;
        }

        // 現在のパスワード確認
        if (!user.getPassword().equals(currentPassword)) {

            req.setAttribute("error", "現在のパスワードが違います");
            req.getRequestDispatcher("passwordChange.jsp")
                    .forward(req, res);
            return;
        }

        // 新旧同一チェック
        if (currentPassword.equals(newPassword)) {

            req.setAttribute("error",
                    "現在と異なるパスワードを入力してください");
            req.getRequestDispatcher("passwordChange.jsp")
                    .forward(req, res);
            return;
        }

        // 確認用パスワードチェック
        if (!newPassword.equals(confirmPassword)) {

            req.setAttribute("error",
                    "確認用パスワードが一致しません");
            req.getRequestDispatcher("passwordChange.jsp")
                    .forward(req, res);
            return;
        }

        UsersDao dao = new UsersDao();

        user.setPassword(newPassword);

        boolean result = dao.save(user);

        if (result) {

            session.setAttribute("users", user);

            req.setAttribute("message",
                    "パスワードを変更しました");

            req.getRequestDispatcher("top.jsp")
                    .forward(req, res);

        } else {

            req.setAttribute("error",
                    "パスワード変更に失敗しました");

            req.getRequestDispatcher("passwordChange.jsp")
                    .forward(req, res);
        }
    }
}