package org.market.hedge.bybit.perpetualSwap.dto.trade.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BybitPerpetualOrderReq {

    //	string	訂單ID
    String order_id;
    //	number	用戶ID
    String user_id;
    //string	合約類型
    String symbol;
    //string	方向
    String side;
    //string	交易記錄類型
    String order_type;
    //number	委托價格
    String price;
    //number	委托數量
    String qty;
    //	string	執行策略
    String time_in_force;
    //	string	訂單狀態
    String order_status;
    //	number	最近一次成交價格
    String last_exec_price;
    //	number	累計成交數量
    String cum_exec_qty;
    //	number	累計成交價值
    String cum_exec_value;
    // 	number	累計成交手續費
    String cum_exec_fee;
    //	bool	是否平倉單 true-平倉 false-開倉
    String reduce_only;
    // 	bool	是否平倉委托 true-平倉 false-開倉
    String close_on_trigger;
    // 	string	機構自定義訂單ID, 最大長度36位，且同一機構下自定義ID不可重復
    String order_link_id;
    // 	string	創建時間
    String created_time;
    // 	string	更新時間
    String updated_time;
    // 	number	止盈價格
    String take_profit;
    // 	number	止損價格
    String stop_loss;
    // 	string	止盈激活價格類型，默認為LastPrice
    String tp_trigger_by;
    // 	string	止損激活價格類型，默認為LastPrice
    String sl_trigger_by;
    // 	integer	Position idx, 用於在不同倉位模式下標識倉位：
    //            0-單向持倉
    //1-雙向持倉Buy
    //2-雙向持倉Sell
    String position_idx;

}
