package sumasyoku;

import java.util.List;

import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ProductsManagementAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	
        ProductsDao pDao = new ProductsDao();
        List<Products> productList = pDao.findAll();  
        
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("product_management.jsp").forward(req, res);
    }
}  
