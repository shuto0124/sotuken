package sumasyoku;


import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsersCreateExecuteAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        request.setCharacterEncoding("UTF-8");

        String userNumberStr = request.getParameter("user_number");
        
        int userNumber = Integer.parseInt(userNumberStr);
        
        String userName = request.getParameter("user_name");
        
        Users users= new Users();
        
        users.setUserNumber(userNumber);
        
        users.setUserName(userName);
        
        users.setPassword(null);
        
        users.setAccountStatus("未登録");
        
        users.setGroups(null);
        
        UsersDao userDao = new UsersDao();
        
        
        if (userName == null || userName.isEmpty() || userNumber <= 0) {
            
            request.setAttribute("error", "個人番号と氏名を入力してください");
            
            request.getRequestDispatcher("users_create.jsp").forward(request, response);
            return;
        } 
        
        
        userDao.save(users);
        
        request.getRequestDispatcher("users_create_done.jsp").forward(request, response);
    }
}