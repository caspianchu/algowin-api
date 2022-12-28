package org.market.hedge.bybit.perpetualSwap.service;

import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.bybit.perpetualSwap.dto.marketData.resp.BybitSymbol;
import org.market.hedge.core.Symbol;
import org.market.hedge.utils.CopyUtil;

import java.io.IOException;
import java.util.List;

public class BybitPerpetualMarketDataServiceRaw extends BybitPerpetualBaseService{
    public BybitPerpetualMarketDataServiceRaw(BybitExchange exchange) {
        super(exchange);
    }

    public List<Symbol> getSymbolsBase() throws IOException {
        List<BybitSymbol> list=bybit.symbols().getResult();
        return CopyUtil.copyList(list,Symbol.class);
    }


}
