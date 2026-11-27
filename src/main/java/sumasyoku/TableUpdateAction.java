package sumasyoku;

import bean.Tables;
import dao.TablesDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;


public class TableUpdateAction extends Action {

    @Override
    public void execute(
            HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
    	

        try {
            int tableNumber=Integer.parseInt(request.getParameter("id"));
            
            TablesDao dao = new TablesDao();
            
            Tables table=dao. findByNumber(tableNumber);
            
            request.setAttribute("table", table);

            request.getRequestDispatcher("table_update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}