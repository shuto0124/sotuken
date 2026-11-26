package sumasyoku;


import bean.Carts;
import bean.Users;
import dao.CartDetailsDao;
import dao.CartsDao;
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
        
        CartDetailsDao cartdetaildao = new CartDetailsDao();
        
        Carts cart =  cartsdao.getOrCreateCart(userNumber);
        
        int cartNumber =cart.getCartNumber();
        
        cartdetaildao.save(cartNumber, productNumber,quantity);
        
        cartsdao.updateTotal(cartNumber);
        
        response.sendRedirect("ProductList.action");
    }
}