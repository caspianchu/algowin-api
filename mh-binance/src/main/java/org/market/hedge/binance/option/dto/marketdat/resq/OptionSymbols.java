package org.market.hedge.binance.option.dto.marketdat.resq;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionSymbols {

    /**
     * "id": "17",    // id
     */
    @JsonProperty("id")
    private Long id;

    /**
     * "symbol": "BTC-200730-9000-C",    // 交易对名称
     */
    @JsonProperty("symbol")
    private String symbol;

    /**
     * "contractId": 1,
     */
    @JsonProperty("contractId")
    private Long contractId;

    /**
     * "underlying": "BTCUSDT",          // 合约标的
     */
    @JsonProperty("underlying")
    private String underlying;

    /**
     * "strikePrice": "50000",           // 行权价
     */
    @JsonProperty("strikePrice")
    private String strikePrice;

    /**
     * "quoteAsset": "USDT",             // 计价资产
     */
    @JsonProperty("quoteAsset")
    private String quoteAsset;

    /**
     * "unit": 1,                        // 兑换比例，一张合约代表的标的数量
     */
    @JsonProperty("unit")
    private String unit;

    /**
     * "minQty": 1,                      // 合约标的最少交易量
     */
    @JsonProperty("minQty")
    private String minQty;

    /**
     * "side": "CALL",                   // 方向: CALL 多, PUT 空
     */
    @JsonProperty("side")
    private String side;

    /**
     * "expiryDate": 1596067200000,    // 交割时间
     */
    @JsonProperty("expiryDate")
    private Long expiryDate;

    /**
     * "makerFeeRate": "0.0002",         // 被动成交手续费率
     */
    @JsonProperty("makerFeeRate")
    private String makerFeeRate;

    /**
     * "takerFeeRate": "0.0004",         // 主动成交手续费率
     */
    @JsonProperty("takerFeeRate")
    private String takerFeeRate;

    /**
     * "maxQty": "100",                  // 最大下单数量
     */
    @JsonProperty("maxQty")
    private String maxQty;

    /**
     * "initialMargin": "0.15",          // 初始保证金率
     */
    @JsonProperty("initialMargin")
    private String initialMargin;

    /**
     * "maintenanceMargin": "0.075",     // 维持保证金率
     */
    @JsonProperty("maintenanceMargin")
    private String maintenanceMargin;

    /**
     * "minInitialMargin": "0.1",        // 最低初始保证金率
     */
    @JsonProperty("minInitialMargin")
    private String minInitialMargin;

    /**
     * "minMaintenanceMargin": "0.05",   // 最低维持保证金率
     */
    @JsonProperty("minMaintenanceMargin")
    private String minMaintenanceMargin;

    /**
     * "priceScale": 2,                  // 价格精度
     */
    @JsonProperty("priceScale")
    private Integer priceScale;

    /**
     * "quantityScale": 0,               // 数量精度
     */
    @JsonProperty("quantityScale")
    private Integer quantityScale;



}
