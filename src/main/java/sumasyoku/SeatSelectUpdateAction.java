package sumasyoku;


import java.io.PrintWriter;
import java.util.List;

import bean.Tables;
// DAOとBeanのパッケージに合わせて変更する
import dao.TablesDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SeatSelectUpdateAction extends Action {

    @Override
    public void execute(
        HttpServletRequest req,
        HttpServletResponse res
    ) throws Exception {

        // DAOからテーブル情報を取得
        TablesDao tDao = new TablesDao();
        tDao.clearTemporary();
        
        List<Tables> list = tDao.findAll();

        // JSON形式で返すことを指定
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        // JSONデータを作成
        StringBuilder json = new StringBuilder();

        json.append("[");

        for (int i = 0; i < list.size(); i++) {

            Tables table = list.get(i);

            if (i > 0) {
                json.append(",");
            }

            json.append("{");
            json.append("\"tableNumber\":")
                .append(table.getTableNumber())
                .append(",");

            json.append("\"tableType\":\"")
                .append(escapeJson(table.getTableType()))
                .append("\",");

            json.append("\"tableStatus\":\"")
                .append(escapeJson(table.getTableStatus()))
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
            .replace("\"", "\\\"");
    }
}
