package sumasyoku;

import bean.Managements;
import dao.ManagementsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UsageTimeListAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


        ManagementsDao managementsDAO = new ManagementsDao();
        
        
        Managements management=managementsDAO.get();
        
        if (management == null) {
        	managementsDAO.createSetting();
        	management=managementsDAO.get();
        }
        
        request.setAttribute("management", management);

        request.getRequestDispatcher("usagetime_list.jsp").forward(request, response);
    }
}