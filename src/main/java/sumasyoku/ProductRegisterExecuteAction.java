package sumasyoku;

import java.io.File;

import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import tool.Action;

public class ProductRegisterExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int productNumber = Integer.parseInt(req.getParameter("productNumber"));
		String productName = req.getParameter("productName");
		String productDescription = req.getParameter("productDescription");
		int productPrice = Integer.parseInt(req.getParameter("productPrice"));
		int productStock = Integer.parseInt(req.getParameter("productStock"));
		
		Part part = req.getPart("productImage");
		String productImage = "";
		
		if (part != null && part.getSize() > 0) {
			productImage = part.getSubmittedFileName();
			
			String path = req.getServletContext().getRealPath("/images");
			
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			part.write(path + File.separator + productImage);
		}
		
		Products product = new Products();
		product.setProductNumber(productNumber);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);
		product.setProductStock(productStock);
		product.setProductImage(productImage);

		ProductsDao dao = new ProductsDao();
		boolean isSuccess = dao.save(product);
		
		if (isSuccess) {
			req.getRequestDispatcher("product_register_complete.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("product_register.jsp").forward(req, res);
		}
	}
}