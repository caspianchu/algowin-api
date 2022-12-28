package org.market.hedge.bybit.perpetualSwap.service;

import org.knowm.xchange.bybit.BybitAdapters;
import org.knowm.xchange.bybit.dto.BybitResult;
import org.knowm.xchange.dto.Order;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.bybit.perpetualSwap.BybitPerpetualAdapters;
import org.market.hedge.bybit.perpetualSwap.dto.trade.req.BybitPerpetualOrderReq;
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
                        "GoodTillCancel",
                        BybitPerpetualAdapters.getReduceOnly(limitOrder.getType()),
                        "false",
                        BybitPerpetualAdapters.getSideString(limitOrder.getType()),
                        this.nonceFactory,
                        this.signatureCreator);
        if (!placeOrder.isSuccess()) {
            throw BybitAdapters.createBybitExceptionFromResult(placeOrder);
        } else {
            return placeOrder;
        }
    }



}
