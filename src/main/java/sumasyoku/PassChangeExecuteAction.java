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
    	
    	String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");

        HttpSession session = req.getSession();
        Users sessionUser = (Users) session.getAttribute("user");

        if (sessionUser == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        if (currentPassword != null && newPassword != null && confirmPassword != null) {
            if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                req.setAttribute("error", "すべての項目を入力してください。");
                req.getRequestDispatcher("password_change.jsp").forward(req, res);
                return;
            }
         // 確認用パスワード確認
            if (!newPassword.equals(confirmPassword)) {
                req.setAttribute("error", "新しいパスワードと確認用パスワードが一致しません。");
                req.getRequestDispatcher("password_change.jsp").forward(req, res);
                return;
            }
         // 現在のパスワード確認
            UsersDao dao = new UsersDao();
            Users dbUser = dao.get(sessionUser.getUserNumber());

            if (dbUser == null || dbUser.getPassword() == null || !currentPassword.equals(dbUser.getPassword())) {
                req.setAttribute("error", "現在のパスワードが間違っています。");
                req.getRequestDispatcher("password_change.jsp").forward(req, res);
                return;
            }

            dbUser.setPassword(newPassword);
            boolean updated = dao.save(dbUser);

            if (updated) {
                session.setAttribute("user", dao.get(sessionUser.getUserNumber()));   
                session.setAttribute("flashMessage", "パスワードを変更しました。");
                
                res.sendRedirect("top.jsp");
                return;
            } else {
                req.setAttribute("error", "パスワードの変更に失敗しました。");
            }
        }

        req.getRequestDispatcher("password_change.jsp").forward(req, res);
    }

}