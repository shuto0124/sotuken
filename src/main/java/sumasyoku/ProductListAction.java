package sumasyoku;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class ProductListAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	HttpSession session=req.getSession();
    	UsersDao uDao =new UsersDao();
    	
 
   
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	ここからうえ-----------------------------------------
    	 
         
         Users users=(Users)session.getAttribute("user");
         
    	uDao.currentPageUpdate(users, "ProductList");
         
    	String backPage = (String) req.getAttribute("backPage");
    	if (backPage == null) {
    		backPage = "reservation";
    	}
    	req.setAttribute("backPage", backPage);
    	req.getRequestDispatcher("product_list.jsp").forward(req, res);
    }
}