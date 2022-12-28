package org.market.hedge.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symbol {

    /**
     * string 	合約名稱
     */
    String name;
    /**
     * string 	合約名稱
     */
    String alias;
    /**
     * string 	合約狀態
     */
    String status;
    /**
     * string 	基礎貨幣
     */
    String base_currency;
    /**
     * string 	報價貨幣
     */
    String quote_currency;
    /**
     * number 	價格範圍（可以提交價格的小數位數，儘管最終價格可能會四捨五入以符合 價格最小增加或減少數量）
     */
    String price_scale;
    /**
     * string 	taker 手續費
     */
    String taker_fee;
    /**
     * string 	maker 手續費
     */
    String maker_fee;
    /**
     * number 	資金費用結算週期
     */
    String funding_interval;
    /**
     * number 	最小杠桿數
     */
    String min_leverage;
    /**
     * number 	最大杠桿數 (假設在最低風險限額設置時候的最大槓桿數)
     */
    String max_leverage;
    /**
     * string 	杠桿最小增加或減少數量
     */
    String leverage_step;
    /**
     * string 	最小價格
     */
    String min_price;
    /**
     * string 	最大價格
     */
    String max_price;
    /**
     * string 	價格最小增加或減少數量
     */
    String tick_size;
    /**
     * number 	最大交易數量
     */
    String max_trading_qty;
    /**
     * number 	最小交易數量
     */
    String min_trading_qty;
    /**
     * number 	合約數量最小單位
     */
    String qty_step;
    /**
     * string 	PostOnly 訂單最大交易數量
     */
    String post_only_max_trading_qty;

}
