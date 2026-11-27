package sumasyoku;

import java.util.List;

import bean.Tables;
import dao.TablesDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;


public class TableListAction extends Action {

    @Override
    public void execute(
            HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
    	

        try {
            TablesDao dao = new TablesDao();
            
            List<Tables> tables=dao.findAll();
            
            request.setAttribute("tables", tables);

            request.getRequestDispatcher("table_list.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}