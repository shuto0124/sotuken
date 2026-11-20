package sumasyoku;

import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ProductDeleteAction extends Action{
	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		int productNumber = Integer.parseInt(req.getParameter("productNumber"));
		ProductsDao pDao = new ProductsDao();
		Products product= pDao.findByNumber(productNumber);
		req.setAttribute("product", product);
		req.getRequestDispatcher("product_delete.jsp").forward(req, res);
	}
}