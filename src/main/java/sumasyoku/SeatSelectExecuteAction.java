package sumasyoku;

import java.time.LocalDateTime;

import bean.Tables;
// DAOとBeanのパッケージに合わせて変更する
import dao.TablesDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SeatSelectExecuteAction extends Action {
    public void execute(
            HttpServletRequest req, HttpServletResponse res
        ) throws Exception {
            HttpSession session = req.getSession();
                            
            TablesDao tDao = new TablesDao();
            int tableNumberStr = Integer.parseInt(req.getParameter("tableNumber"));
            Tables table = tDao.findByNumber(tableNumberStr);
            if (table != null) {
      
                String status = table.getTableStatus();
                if ("空席".equals(status)) {
                	String newStatus = "仮予約";
                	
                	 LocalDateTime now = LocalDateTime.now();
                     LocalDateTime temporaryEndTime = now.plusMinutes(1);
                	
                	boolean check = tDao.updateStatus(tableNumberStr,newStatus,temporaryEndTime);
                	if(check == true) {
                		table = tDao.findByNumber(tableNumberStr);
                		session.setAttribute("table", table);
                	} else {
                		System.out.println("仮予約失敗");
                	}
                	
                	req.getRequestDispatcher("product_list.jsp")
            		.forward(req, res);
                
            } else {
            	System.out.println("ぬる");
            String message = "エラー";
            req.setAttribute("msg", message);
            req.getRequestDispatcher("SeatSelect.action")
    		.forward(req, res);
            }
        }
    }
}
