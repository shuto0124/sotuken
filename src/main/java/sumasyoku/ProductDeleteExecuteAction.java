package sumasyoku;

import java.io.File;

import bean.Products;
import dao.ProductsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ProductDeleteExecuteAction extends Action{
	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		int productNumber = Integer.parseInt(req.getParameter("productNumber"));
		ProductsDao pDao = new ProductsDao();
		Products product= pDao.findByNumber(productNumber);
        if (product == null) {
            req.setAttribute("msg", "対象の商品が見つかりません");
            req.getRequestDispatcher("ProductsManagement.action").forward(req, res);
            return;
        }
        String image = product.getProductImage();
        if (image != null && !image.isEmpty()) {
            String path = req.getServletContext().getRealPath("/images");
            File file = new File(path, new File(image).getName());
            if (file.exists()) {
                file.delete();
            }
        }
		pDao.delete(product);
		req.getRequestDispatcher("product_delete_cmp.jsp").forward(req, res);
	}
}