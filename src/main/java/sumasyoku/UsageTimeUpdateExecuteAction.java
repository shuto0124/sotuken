package sumasyoku;

import java.time.LocalTime;

import bean.Managements;
import dao.ManagementsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsageTimeUpdateExecuteAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        request.setCharacterEncoding("UTF-8");
        
        String reservationDurationStr = request.getParameter("reservationDuration");
        
        String systemStarttimeStr = request.getParameter("systemStarttime");
        
        String systemEndtimeStr = request.getParameter("systemEndtime");
        
        int reservationDuration = Integer.parseInt(reservationDurationStr);
        
        LocalTime systemStarttime = LocalTime.parse(systemStarttimeStr);
        
        LocalTime systemEndtime = LocalTime.parse(systemEndtimeStr);
        
        ManagementsDao managementDao = new ManagementsDao();
        
        managementDao.setDurationTime(reservationDuration);
        
        managementDao.setStartTime(systemStarttime);
        
        managementDao.setEndTime(systemEndtime);

        
        if (reservationDurationStr == null || reservationDurationStr.isEmpty()) {

            Managements management=managementDao.get();
            
            request.setAttribute("error", "利用時間を入力してください");
            request.setAttribute("management", management);
            
            request.getRequestDispatcher("usagetime_list.jsp").forward(request, response);
            return;
        }
        
        request.getRequestDispatcher("usagetime_update_done.jsp").forward(request, response);
    }
}