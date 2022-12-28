package org.market.hedge.bybit.perpetualSwap.dto.trade.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BybitPerpetualPosition {

    /**
     *  number	用戶ID
     */
    String user_id;
    /**
     * 	string	合約類型
     */
    String symbol;
    /**
     * 	string	方向
     */
    String side;
    /**
     * 	number	倉位數量
     */
    String size;
    /**
     * 	number	倉位價值
     */
    String position_value;
    /**
     * 	number	平均開倉價
     */
    String entry_price;
    /**
     * 	number	強平價格
     */
    String liq_price;
    /**
     * 	number	破產價格
     */
    String bust_price;
    /**
     * 	number	逐倉模式下, 值為用戶設置的杠桿；全倉模式下，值為當前風險限額下最大杠桿
     */
    String leverage;
    /**
     * 	number	是否 自動追加保證金
     */
    String auto_add_margin;
    /**
     * 	bool	是否逐倉，true-逐倉 false-全倉
     */
    String is_isolated;
    /**
     * 	number	倉位保證金
     */
    String position_margin;
    /**
     * 	number	預占用平倉手續費
     */
    String occ_closing_fee;
    /**
     * 	number	當日已結盈虧
     */
    String realised_pnl;
    /**
     * 	number	累計已結盈虧
     */
    String cum_realised_pnl;
    /**
     * 	number	可平倉位數量（如果您有多頭頭寸，free_qty 為負數。反之亦然）
     */
    String free_qty;
    /**
     * 	string	止盈止損模式
     */
    String tp_sl_mode;
    /**
     * 	number	風險指示燈等級（1，2，3，4，5）
     */
    String deleverage_indicator;
    /**
     * 	number	未結盈虧
     */
    String unrealised_pnl;
    /**
     * 	integer	風險限額ID
     */
    String risk_id;
    /**
     * 	number	止盈價格
     */
    String take_profit;
    /**
     * 	number	止損價格
     */
    String stop_loss;
    /**
     * 	number	追蹤止損（與當前價格的距離）
     */
    String trailing_stop;
    /**
     * 	integer	Position idx, 用於在不同倉位模式下標識倉位：
     *             0-單向持倉
     * 1-雙向持倉Buy
     * 2-雙向持倉Sell
     */
    String position_idx;
    /**
     * 	string	倉位模式: MergedSingle - 單倉模式 BothSide - 雙倉模式
     */
    String mode;

}
