package sumasyoku;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginExecuteAction extends Action {
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	
        HttpSession session = req.getSession();

        
        } else {
        String message = "ログインに失敗しました。IDまたはパスワードが正しくありません。";
        req.setAttribute("msg", message);
        req.getRequestDispatcher("login.jsp")
		.forward(req, res);
        }
    }
}  