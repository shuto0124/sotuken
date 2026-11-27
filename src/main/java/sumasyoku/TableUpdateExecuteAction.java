package sumasyoku;

import dao.TablesDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class TableUpdateExecuteAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        request.setCharacterEncoding("UTF-8");
        
        String tableNumberStr = request.getParameter("tableNumber");
        
        int tableNumber = Integer.parseInt(tableNumberStr);
        
        String tableStatus = request.getParameter("tableStatus");
        
        if (tableStatus != null) {
            tableStatus = "利用停止中";
        }
        
        if (tableStatus == null) {
            tableStatus = "空き";
        }
        
        
        TablesDao tablesDao = new TablesDao();
        
        tablesDao.updateStatus(tableNumber,tableStatus,null);
        
        
        request.getRequestDispatcher("table_update_done.jsp").forward(request, response);
    }
}