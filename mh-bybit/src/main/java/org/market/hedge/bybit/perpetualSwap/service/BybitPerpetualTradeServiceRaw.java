package org.market.hedge.bybit.perpetualSwap.service;

import org.knowm.xchange.bybit.BybitAdapters;
import org.knowm.xchange.bybit.dto.BybitResult;
import org.knowm.xchange.dto.Order;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.bybit.perpetualSwap.BybitPerpetualAdapters;
import org.market.hedge.bybit.perpetualSwap.dto.trade.req.BybitPerpetualOrderReq;
import org.market.hedge.core.TimeInForce;
import org.market.hedge.dto.trade.MHLimitOrder;

import java.io.IOException;

public class BybitPerpetualTradeServiceRaw extends BybitPerpetualBaseService{
    public BybitPerpetualTradeServiceRaw(BybitExchange exchange) {
        super(exchange);
    }

    public BybitResult<BybitPerpetualOrderReq> placeOrder(MHLimitOrder limitOrder) throws IOException {
        BybitResult<BybitPerpetualOrderReq> placeOrder =
                this.bybit.placeOrder(
                        this.apiKey,
                        limitOrder.getParsingCurrencyPair().getParsing(),
                        "Limit",
                        limitOrder.getOriginalAmount().toPlainString(),
                        limitOrder.getLimitPrice().toPlainString(),
                        byTimeInForce(limitOrder.getTimeInForce()),
                        BybitPerpetualAdapters.getReduceOnly(limitOrder.getType()),
                        "false",
                        // 持仓模式 0-單向持倉 1-雙向持倉Buy 2-雙向持倉Sell
                        0,
                        BybitPerpetualAdapters.getSideString(limitOrder.getType()),
                        this.nonceFactory,
                        this.signatureCreator);
        if (!placeOrder.isSuccess()) {
            throw BybitAdapters.createBybitExceptionFromResult(placeOrder);
        } else {
            return placeOrder;
        }
    }

    /**
     *             //- `GoodTillCancel`一直有效至取消
     *             //- `ImmediateOrCancel`立即成交或取消
     *             //- `FillOrKill`完全成交或取消
     *             //- `PostOnly`被動委托
     * * * */
    public String byTimeInForce(TimeInForce timeInForce){
        switch (timeInForce){
            case IOC:
                return "ImmediateOrCancel";
            case FOK:
                return "FillOrKill";
            case PO:
                return "PostOnly";
            case GTC:
            default:
                return "GoodTillCancel";

        }
    }



}
