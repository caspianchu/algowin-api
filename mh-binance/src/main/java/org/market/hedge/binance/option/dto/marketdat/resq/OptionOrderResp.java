package org.market.hedge.binance.option.dto.marketdat.resq;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
 *         "orderId": 4612288550799409153,  // 订单号
 *         "symbol": "ETH-220826-1800-C",   // 交易对
 *         "price": "100",                  // 订单价格
 *         "quantity": "0.01",              // 订单数量
 *         "side": "BUY",                   // 订单方向
 *         "type": "LIMIT",                 // 订单类型
 *         "reduceOnly": false,             // 仅减仓
 *         "postOnly": false,               // 仅做maker
 *         "clientOrderId": "1001",         // 用户订单id
 *         "mmp": false                     // 做市商保护
 *     }
 * * * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionOrderResp {

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("price")
    private String price;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("side")
    private String side;

    @JsonProperty("type")
    private String type;

    @JsonProperty("reduceOnly")
    private Boolean reduceOnly;

    @JsonProperty("postOnly")
    private Boolean postOnly;

    @JsonProperty("clientOrderId")
    private String clientOrderId;

    @JsonProperty("mmp")
    private Boolean mmp;

}
