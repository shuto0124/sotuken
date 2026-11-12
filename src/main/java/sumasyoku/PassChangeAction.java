package sumasyoku
;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class PassChangeAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("passhen.jsp").forward(request, response);
    }
}