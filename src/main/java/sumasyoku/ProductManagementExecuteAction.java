package sumasyoku;

import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ProductsManagementExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	
        int productNumber = Integer.parseInt(req.getParameter("productNumber"));    	
        int productStockNumber = Integer.parseInt(req.getParameter("productStock"));    	
        ProductsDao dao = new ProductsDao();

        Products old = dao.findByNumber(productNumber);
        if (old == null) {
            req.setAttribute("msg", "対象の商品が見つかりません");
            req.getRequestDispatcher("ProductManagement.action").forward(req, res);
            return;
        }
        
        old.setProductStock(productStockNumber);
        dao.save(old);
        res.sendRedirect("ProductsManagement.action");
        
        
    }
}  
