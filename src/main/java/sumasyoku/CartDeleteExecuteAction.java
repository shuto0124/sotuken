package sumasyoku;

import dao.CartDetailsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class CartDeleteExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	int cartDetailNumber = Integer.parseInt(req.getParameter("cartDetailNumber"));
    	CartDetailsDao cartDetailsDao = new CartDetailsDao();
    	cartDetailsDao.delete(cartDetailNumber);

    	res.sendRedirect("Cart.action");
    }
}