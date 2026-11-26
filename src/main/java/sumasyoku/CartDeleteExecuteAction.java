package sumasyoku;

import bean.Carts;
import bean.Users;
import dao.CartDetailsDao;
import dao.CartsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CartDeleteExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	HttpSession session=req.getSession();
    	Users users = (Users) session.getAttribute("user");
    	int cartDetailNumber = Integer.parseInt(req.getParameter("cartDetailNumber"));
    	CartDetailsDao cartDetailsDao = new CartDetailsDao();
    	cartDetailsDao.delete(cartDetailNumber);
    	
		CartsDao cartsDao = new CartsDao();
		Carts carts = cartsDao.getOrCreateCart(users.getUserNumber());
		cartsDao.updateTotal(carts.getCartNumber());

    	res.sendRedirect("Cart.action");
    }
}
