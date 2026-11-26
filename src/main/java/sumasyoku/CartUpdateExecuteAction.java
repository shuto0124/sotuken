package sumasyoku;

import bean.Carts;
import bean.Users;
import dao.CartDetailsDao;
import dao.CartsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CartUpdateExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	HttpSession session=req.getSession();
    	int cartDetailNumber = Integer.parseInt(req.getParameter("cartDetailNumber"));
    	int quantity = Integer.parseInt(req.getParameter("quantity"));
    	if (quantity >= 1) {
    		Users users = (Users) session.getAttribute("user");
    		CartDetailsDao cartDetailsDao = new CartDetailsDao();
    		cartDetailsDao.updateQuantity(cartDetailNumber, quantity);
    		CartsDao cartsDao = new CartsDao();
    		Carts carts = cartsDao.getOrCreateCart(users.getUserNumber());
    		cartsDao.updateTotal(carts.getCartNumber());
    	}
    	res.sendRedirect("Cart.action");
    }
}