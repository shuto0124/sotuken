package sumasyoku;

import java.util.List;

import bean.Products;
import bean.Users;
import dao.ProductsDao;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class MenuAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	HttpSession session=req.getSession();
    	UsersDao userDao =new UsersDao();
    	
    	ProductsDao productDao=new ProductsDao();
    	
        List<Products> product = productDao.findAll();
        
    	 
         
         Users users=(Users)session.getAttribute("user");
         
    	userDao.currentPageUpdate(users, "ProductList");
         
    	String backPage = (String) req.getAttribute("backPage");
    	if (backPage == null) {
    		backPage = "menu";
    	}
    	req.setAttribute("backPage", backPage);
    	req.setAttribute("product", product);
    	req.getRequestDispatcher("product_list.jsp").forward(req, res);
    }
}