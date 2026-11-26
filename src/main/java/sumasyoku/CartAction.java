package sumasyoku;

import java.util.List;

import bean.CartDetails;
import bean.Carts;
import bean.Users;
import dao.CartDetailsDao;
import dao.CartsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CartAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	HttpSession session=req.getSession();
    	Users user = (Users) session.getAttribute("user");
    	if (user == null) {
    	    res.sendRedirect("login.jsp");   // ログインし直してもらう
    	    return;
    	}
    	CartsDao cartsDao = new CartsDao();
    	Carts carts = cartsDao.getOrCreateCart(user.getUserNumber());
    	int cartNumber = carts.getCartNumber();
    	CartDetailsDao cartDetailsDao = new CartDetailsDao();
    	List<CartDetails> cartList = cartDetailsDao.findByCartNumber(cartNumber);  
    	
    	req.setAttribute("cartTotal", carts.getCartTotal());
        req.setAttribute("cartList", cartList);
        req.getRequestDispatcher("cart.jsp").forward(req, res);
    }
}  
