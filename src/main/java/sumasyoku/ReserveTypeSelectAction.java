package sumasyoku;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ReserveTypeSelectAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getRequestDispatcher("reserve_type.jsp").forward(req, res);
	}
}