package sumasyoku;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ProductListAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	
    	//---------------------------------------------------------------------------
    	//---------------------------------------------------------------------------
    	//-------------------------いったん画面遷移だけ------------------------------
    	//---------------------------------------------------------------------------
    	//---------------------------------------------------------------------------
    	//---------------------------------------------------------------------------
    	String backPage = (String) req.getAttribute("backPage");
    	if (backPage == null) {
    		backPage = "reservation";
    	}
    	req.setAttribute("backPage", backPage);
    	req.getRequestDispatcher("product_list.jsp").forward(req, res);
    }
}