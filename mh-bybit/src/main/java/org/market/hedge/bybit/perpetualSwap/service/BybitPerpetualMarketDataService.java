package org.market.hedge.bybit.perpetualSwap.service;

import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.core.Symbol;
import org.market.hedge.service.marketdata.MHMarketDataService;

import java.io.IOException;
import java.util.List;

public class BybitPerpetualMarketDataService extends BybitPerpetualMarketDataServiceRaw  implements MHMarketDataService {
    public BybitPerpetualMarketDataService(BybitExchange exchange) {
        super(exchange);
    }

    @Override
    public List<Symbol> getSymbols() throws IOException {
        return super.getSymbolsBase();
    }
}
