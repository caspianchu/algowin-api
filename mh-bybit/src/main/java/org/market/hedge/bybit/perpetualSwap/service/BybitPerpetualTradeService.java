package org.market.hedge.bybit.perpetualSwap.service;

import org.knowm.xchange.bybit.dto.BybitResult;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.bybit.perpetualSwap.dto.trade.req.BybitPerpetualOrderReq;
import org.market.hedge.core.ParsingCurrencyPair;
import org.market.hedge.dto.trade.MHLimitOrder;
import org.market.hedge.service.trade.MHTradeService;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class BybitPerpetualTradeService extends BybitPerpetualTradeServiceRaw implements MHTradeService {
    public BybitPerpetualTradeService(BybitExchange exchange) {
        super(exchange);
    }

    @Override
    public String placeLimitOrder(MHLimitOrder limitOrder) throws IOException {
        BybitResult<BybitPerpetualOrderReq> order = this.placeOrder(limitOrder);
        return ((BybitPerpetualOrderReq)order.getResult()).getOrder_id();
    }

    @Override
    public Collection<String> cancelAllByInstrument(ParsingCurrencyPair parsingCurrencyPair) throws IOException {
        BybitResult<List<String>> result=bybit.cancelAll(this.apiKey,
                parsingCurrencyPair.getParsing(),
                this.nonceFactory,
                this.signatureCreator);
        return result.getResult();
    }

}
