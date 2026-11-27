package sumasyoku;


import java.util.List;

import bean.Carts;
import bean.Products;
import bean.Users;
import dao.CartDetailsDao;
import dao.CartsDao;
import dao.ProductsDao;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class AddCartAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
    	request.setCharacterEncoding("UTF-8");

        HttpSession session =request.getSession();
    	
        String productNumberStr = request.getParameter("productNumber");
        
        int productNumber = Integer.parseInt(productNumberStr);
        
        String quantityStr =request.getParameter("quantity");
        
        int quantity = Integer.parseInt(quantityStr);
        
        Users user =(Users) session.getAttribute("user");
        
        int userNumber = user.getUserNumber();
        
        CartsDao cartsdao = new CartsDao();
        
    	ProductsDao productDao=new ProductsDao();
    	
    	UsersDao userDao =new UsersDao();
        
        CartDetailsDao cartdetaildao = new CartDetailsDao();
        
        Carts cart =  cartsdao.getOrCreateCart(userNumber);
        
        int cartNumber =cart.getCartNumber();
        
        cartdetaildao.save(cartNumber, productNumber,quantity);
        
        cartsdao.updateTotal(cartNumber);
    	
        List<Products> product = productDao.findAll();
        
    	userDao.currentPageUpdate(user, "ProductList");
    	
    	String backPage = (String) request.getAttribute("backPage");
    	if (backPage == null) {
    		backPage = "reservation";
    	}
    	
    	request.setAttribute("product", product);
    	request.setAttribute("backPage", backPage);
        request.setAttribute("message", "カートに追加しました");
        request.getRequestDispatcher("product_list.jsp")
               .forward(request, response);
    }
}