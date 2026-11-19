package sumasyoku;

import java.util.List;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsersListAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


        UsersDao userDAO = new UsersDao();
        

        List<Users> users = userDAO.findAll();

        request.setAttribute("users", users);

        request.getRequestDispatcher("users_list.jsp").forward(request, response);
    }
}
