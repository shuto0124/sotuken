package sumasyoku;


import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	
        HttpSession session = req.getSession();

        int userNumberStr = Integer.parseInt(req.getParameter("userNumber"));
        String passwordStr = req.getParameter("password");
        UsersDao uDao = new UsersDao();
        Users users = uDao.login(userNumberStr, passwordStr);

        if (users != null) {
            session.setAttribute("user", users);
            res.sendRedirect("Top.action"); //完了時に飛ぶ場所
        } else {
        String message = "ログインに失敗しました。個人番号またはパスワードが正しくありません。";
        req.setAttribute("msg", message);
        req.getRequestDispatcher("login.jsp")
		.forward(req, res);
        }
    }
}  