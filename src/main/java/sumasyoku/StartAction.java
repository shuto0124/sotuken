package sumasyoku;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StartAction extends Action {
	
	//今後ログイン情報が残っていればそのままtop画面に行く処理を入れる
	
    public void execute(
        HttpServletRequest req, HttpServletResponse res
    ) throws Exception {
    	req.getRequestDispatcher("start.jsp").forward(req, res);
    }
}