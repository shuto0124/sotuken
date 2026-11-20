package sumasyoku;

import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ProductUpdateAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int productNumber = Integer.parseInt(req.getParameter("productNumber"));
		
		ProductsDao dao = new ProductsDao();
		Products product = dao.findByNumber(productNumber);
		
		req.setAttribute("product", product);
		
		req.getRequestDispatcher("product_update.jsp").forward(req, res);
	}
}