package sumasyoku;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	HttpSession session=req.getSession();
    	if (session.getAttribute("user")!=null) {
    		res.sendRedirect("Top.action");
    		return;
    	}
    	req.getRequestDispatcher("login.jsp").forward(req, res);
    }
}
