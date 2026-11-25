package sumasyoku;


import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ProductDetailAction extends Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String productNumberStr = request.getParameter("product_number");
		
		String backPage=request.getParameter("backPage");
				
	    int productNumber = Integer.parseInt(productNumberStr);

		
	    ProductsDao productDao = new ProductsDao();    	
		
	    Products product = productDao.findByNumber(productNumber);
	    
	    request.setAttribute("product", product);
	    
	    request.setAttribute("backPage", backPage);

	    request.getRequestDispatcher("product_detail.jsp")
	           .forward(request, response);
	}
}