package sumasyoku;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	
        HttpSession session = req.getSession();

        if (session != null) {
            session.invalidate();
        }
        res.sendRedirect("login.jsp");
    }
}  