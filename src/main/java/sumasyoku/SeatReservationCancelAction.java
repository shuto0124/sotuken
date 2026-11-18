package sumasyoku;

import java.util.Objects;

import bean.Tables;
import dao.TablesDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SeatReservationCancelAction extends Action {

    @Override
    public void execute(
        HttpServletRequest req,
        HttpServletResponse res
    ) throws Exception {
        HttpSession session = req.getSession();
        
        if (session == null || session.getAttribute("table") == null) {
            res.setStatus(204);
            return;
        }

        Tables sessionTable =(Tables) session.getAttribute("table");
        int tableNumber = sessionTable.getTableNumber();
        
        TablesDao tDao = new TablesDao();
        Tables table = tDao.findByNumber(tableNumber);
        System.out.println("ここha");
        if (sessionTable.getTemporaryEndTime() != null
                && Objects.equals(
                    sessionTable.getTemporaryEndTime(),
                    table.getTemporaryEndTime())
                && "仮予約".equals(table.getTableStatus())) {
        	boolean check = tDao.updateStatus(tableNumber, "空席", null);
        	if (check == true) {
        		session.removeAttribute("table");
        	} else {
        		res.setStatus(204);
                return;
        	}
        }
    }
}