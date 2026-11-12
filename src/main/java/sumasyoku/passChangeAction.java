package gakutiru
;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PasswordChangeAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        

        
        request.getRequestDispatcher("passhen.jsp").forward(request, response);
    }
}