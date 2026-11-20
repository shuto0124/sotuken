package sumasyoku;

import java.io.File;

import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import tool.Action;

public class ProductUpdateExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int productNumber = Integer.parseInt(req.getParameter("productNumber"));
		String productName = req.getParameter("productName");
		String productDescription = req.getParameter("productDescription");
		int productPrice = Integer.parseInt(req.getParameter("productPrice"));
		
		ProductsDao dao = new ProductsDao();
		Products currentProduct = dao.findByNumber(productNumber);
		
		Part part = req.getPart("productImage");
		String productImage = null;
		
		if (part != null && part.getSize() > 0) {
			productImage = part.getSubmittedFileName();
			
			String path = req.getServletContext().getRealPath("/images");
			
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			part.write(path + File.separator + productImage);
		} else if (currentProduct != null) {
			productImage = currentProduct.getProductImage();
		}
		
		
		Products product = new Products();
		product.setProductNumber(productNumber);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);	
		product.setProductImage(productImage);
		
		if (currentProduct != null) {
			product.setProductStock(currentProduct.getProductStock());
		}
		
		boolean isSuccess = dao.save(product);
		
		if (isSuccess) {
			req.getRequestDispatcher("product_update_cmp.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("product_update.jsp").forward(req, res);
		}
	}
}