package sumasyoku;


import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class RegisterExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	
        HttpSession session = req.getSession();

        int userNumberStr = Integer.parseInt(req.getParameter("userNumber"));
        String passwordStr = req.getParameter("password");
        UsersDao uDao = new UsersDao();
        boolean success = false;
        
        Users users = uDao.get(userNumberStr);
        if (users == null) {
        	String message = "入力された個人番号が間違っています。指定された個人番号を入力してください";
            req.setAttribute("msg", message);
            req.getRequestDispatcher("register.jsp")
    		.forward(req, res);
        } else {
	        String password = users.getPassword();
	        if (password != null) {
	            String message = "入力された個人番号は既に初回登録済みです";
	            req.setAttribute("msg", message);
	            req.getRequestDispatcher("register.jsp")
	    		.forward(req, res);
	        } else {
	        	users.setPassword(passwordStr);
	        	users.setAccountStatus("登録済み");
	        	success = uDao.save(users);
	        	}
        }
        if (success == true) {
            session.setAttribute("user", users);
            res.sendRedirect("registerComplete.jsp"); //完了時に飛ぶ場所
        } else {
        String message = "登録に失敗しました";
        req.setAttribute("msg", message);
        req.getRequestDispatcher("register.jsp")
		.forward(req, res);
        }
    }
}  