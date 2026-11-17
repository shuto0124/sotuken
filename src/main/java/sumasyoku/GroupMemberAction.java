
package sumasyoku;

import java.io.PrintWriter;
import java.util.List;

import bean.Users;
import dao.UsersDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GroupMemberAction extends Action {

    @Override
    public void execute(
        HttpServletRequest req,
        HttpServletResponse res
    ) throws Exception {

        // ログイン中のユーザー情報をセッションから取得
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        Users loginUser = (Users) session.getAttribute("user");

        // ログインユーザーのグループ番号を取得
        int groupNumber = loginUser.getGroups().getGroupNumber();

        // DAOから同じグループのメンバーを取得
        UsersDao uDao = new UsersDao();
        List<Users> list = uDao.gGetAll(groupNumber);

        // JSON形式で返すことを指定
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        // JSONデータを作成
        StringBuilder json = new StringBuilder();

        json.append("[");

        for (int i = 0; i < list.size(); i++) {

            Users member = list.get(i);

            if (i > 0) {
                json.append(",");
            }

            json.append("{");

            json.append("\"userName\":\"")
                .append(escapeJson(member.getUserName()))
                .append("\"");

            json.append("}");
        }

        json.append("]");

        // JSONデータを画面に返す
        PrintWriter out = res.getWriter();
        out.print(json.toString());
        out.flush();
    }

    // JSONに含める文字列の特殊文字を処理
    private String escapeJson(String value) {

        if (value == null) {
            return "";
        }

        return value
            .replace("\\", "\\\\")
            .replace("\"", "\\\"")
            .replace("\n", "\\n")
            .replace("\r", "\\r");
    }
}