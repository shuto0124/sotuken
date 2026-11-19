package sumasyoku;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsersCreateAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getRequestDispatcher("users_create.jsp").forward(request, response);
    }
}