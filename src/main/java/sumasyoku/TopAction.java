package sumasyoku;


import bean.Groups;
import bean.Users;
import dao.GroupsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TopAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	HttpSession session = req.getSession();
    	Users user = (Users)session.getAttribute("user");
    	Groups group = user.getGroups();
    	if (group == null) {
    		GroupsDao gDao = new GroupsDao();
    		group = gDao.createGroup();
    		user.setGroups(group);
    		
    		String Message = gDao.joinGroup(user, group.getGroupNumber());
    		System.out.print(Message);
    	}
    	
    	req.getRequestDispatcher("top.jsp").forward(req, res);
    }
}