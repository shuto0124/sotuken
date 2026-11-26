package sumasyoku;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ReservationListAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getRequestDispatcher("reservation_list.jsp").forward(request, response);
    }
}