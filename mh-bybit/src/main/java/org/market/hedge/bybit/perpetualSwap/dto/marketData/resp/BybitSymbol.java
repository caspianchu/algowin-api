package org.market.hedge.bybit.perpetualSwap.dto.marketData.resp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BybitSymbol {

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

    @JsonCreator
    public BybitSymbol(
            @JsonProperty("name") String name,
            @JsonProperty("alias") String alias,
            @JsonProperty("status") String status,
            @JsonProperty("base_currency") String base_currency,
            @JsonProperty("quote_currency") String quote_currency,
            @JsonProperty("price_scale") String price_scale,
            @JsonProperty("taker_fee") String taker_fee,
            @JsonProperty("maker_fee") String maker_fee,
            @JsonProperty("funding_interval") String funding_interval,
            @JsonProperty("min_leverage") String min_leverage,
            @JsonProperty("max_leverage") String max_leverage,
            @JsonProperty("leverage_step") String leverage_step,
            @JsonProperty("min_price") String min_price,
            @JsonProperty("max_price") String max_price,
            @JsonProperty("tick_size") String tick_size,
            @JsonProperty("max_trading_qty") String max_trading_qty,
            @JsonProperty("min_trading_qty") String min_trading_qty,
            @JsonProperty("qty_step") String qty_step,
            @JsonProperty("post_only_max_trading_qty") String post_only_max_trading_qty
    ){
        this.name  = name;
        this.alias  = alias;
        this.status  = status;
        this.base_currency  = base_currency;
        this.quote_currency  = quote_currency;
        this.price_scale  = price_scale;
        this.taker_fee  = taker_fee;
        this.maker_fee  = maker_fee;
        this.funding_interval  = funding_interval;
        this.min_leverage  = min_leverage;
        this.max_leverage  = max_leverage;
        this.leverage_step  = leverage_step;
        this.min_price  = min_price;
        this.max_price  = max_price;
        this.tick_size  = tick_size;
        this.max_trading_qty  = max_trading_qty;
        this.min_trading_qty  = min_trading_qty;
        this.qty_step  = qty_step;
        this.post_only_max_trading_qty  = post_only_max_trading_qty;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getStatus() {
        return status;
    }

    public String getBase_currency() {
        return base_currency;
    }

    public String getQuote_currency() {
        return quote_currency;
    }

    public String getPrice_scale() {
        return price_scale;
    }

    public String getTaker_fee() {
        return taker_fee;
    }

    public String getMaker_fee() {
        return maker_fee;
    }

    public String getFunding_interval() {
        return funding_interval;
    }

    public String getMin_leverage() {
        return min_leverage;
    }

    public String getMax_leverage() {
        return max_leverage;
    }

    public String getLeverage_step() {
        return leverage_step;
    }

    public String getMin_price() {
        return min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public String getTick_size() {
        return tick_size;
    }

    public String getMax_trading_qty() {
        return max_trading_qty;
    }

    public String getMin_trading_qty() {
        return min_trading_qty;
    }

    public String getQty_step() {
        return qty_step;
    }

    public String getPost_only_max_trading_qty() {
        return post_only_max_trading_qty;
    }
}
