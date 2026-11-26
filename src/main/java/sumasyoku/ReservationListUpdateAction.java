package sumasyoku;

import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import bean.GroupOrderInfo;
import bean.Groups;
import bean.OrderDetails;
import bean.OrderInfo;
import bean.OrderProduct;
import bean.Orders;
import bean.Reservations;
import dao.GroupsDao;
import dao.OrderDetailsDao;
import dao.OrdersDao;
import dao.ReservationsDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ReservationListUpdateAction extends Action {

    @Override
    public void execute(HttpServletRequest req,
                        HttpServletResponse res) throws Exception {
    	
    	OrdersDao oDao = new OrdersDao();
    	OrderDetailsDao oDDao = new OrderDetailsDao();
    	List<Orders> oList = new ArrayList<>();
    	List<OrderDetails> oDList = new ArrayList<>();
    	GroupsDao gDao = new GroupsDao();
    	ReservationsDao rDao = new ReservationsDao();
    	
    	
    	
    	oList = oDao.findAll();//注文を全件取得
    	List<OrderInfo> oIList = new ArrayList<>();
    	for (Orders order: oList) { 			//注文を一軒ずつ処理
    		int orderNumber = order.getOrderNumber(); 			//注文番号を取得
    		oDList = oDDao.oGetAll(orderNumber);  				//注文番号の注文詳細を取得
    		List<OrderProduct> oPList = new ArrayList<>();     
    		for (OrderDetails od:oDList) {        				//注文詳細を1件ずつ処理
    			String productName = od.getProducts().getProductName();   //商品名
    			int quantity = od.getOrderQuantity();                     //個数
    			int subtotal = od.getOrderSubtotal();					   //小計	
    			OrderProduct oP = new OrderProduct();   
    			oP.setProductName(productName);
    			oP.setQuantity(quantity);
    			oP.setSubtotal(subtotal);
    			
    			oPList.add(oP);       //注文された商品の情報をリスト化
    		}
    		int userNumber = order.getUsers().getUserNumber();  //個人番号
    		int groupNumber = order.getUsers().getGroups().getGroupNumber();   //グループ番号
    		int totalAmount = order.getTotalAmount();           //合計金額
    		OrderInfo oI = new OrderInfo();
    		
    		oI.setUserNumber(userNumber);
    		oI.setGroupNumber(groupNumber);
    		oI.setOrderNumber(orderNumber);
    		oI.setTotalAmount(totalAmount);
    		oI.setProducts(oPList);                 //注文された商品の情報
    		
    		oIList.add(oI);                  //個人の注文内容をリスト化    		
    		
    	}
    	
    	List<GroupOrderInfo> gOIList = new ArrayList<>();  //グループごとの注文情報リスト
    	for (OrderInfo oI : oIList) {                      //個人の注文内容を一軒ずつ取得
    		int groupNumber = oI.getGroupNumber();        //取り出した個人のグループ番号を取得
    		GroupOrderInfo gOI = null;                     
    		
    		for (GroupOrderInfo group: gOIList) {				//グループごとの注文情報から１件ずつ取得
    			if(group.getGroupNumber() == groupNumber) {		//既に情報のあるグループなら
    				gOI = group;								
    				break;
    			}
    		}
    		
    		if (gOI == null) {					//まだ登録されていないグループなら
 
    			gOI = new GroupOrderInfo();		//グループの情報を作成する
    			
    			      
    			Groups group = gDao.get(groupNumber);         //グループ番号からグループを取得
    			
    			gOI.setGroupNumber(group.getGroupNumber());			
    			gOI.setMemberCount(group.getMemberCount());
    			
    			
    			Reservations rV = rDao.gFind(groupNumber);

    			if (rV != null) {
    			    LocalTime time = rV.getTimeLimit();
    			    gOI.setUsageTime(time.toString());
    			} else {
    			    gOI.setUsageTime("-");
    			}
    			
    			gOI.setStatus("調理中");
    			
    			
    	        gOI.setOrders(new ArrayList<>());			//個人の注文を追加するリスト

    	        gOIList.add(gOI);
    	    }
    		
    		gOI.setTotalAmount(                                    //合計金額を更新
    			    gOI.getTotalAmount() + oI.getTotalAmount()
    			);
    		
    	    gOI.getOrders().add(oI);                          // 注文情報を追加
    		} 
    	
    	//GsonをつかってJSONに変更
        Gson gson = new Gson();
        String json = gson.toJson(gOIList);

        //JSP側にJSONを渡す
        res.setContentType("application/json; charset=UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setHeader("Cache-Control", "no-store");

        PrintWriter out = res.getWriter();
        out.print(json);
        out.flush();		
    }
}

