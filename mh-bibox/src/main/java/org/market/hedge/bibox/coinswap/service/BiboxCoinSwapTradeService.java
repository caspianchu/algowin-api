package org.market.hedge.bibox.coinswap.service;

import org.knowm.xchange.Exchange;
import org.market.hedge.core.ParsingCurrencyPair;
import org.market.hedge.dto.trade.MHLimitOrder;
import org.market.hedge.service.trade.MHTradeService;

import java.io.IOException;
import java.util.Collection;

public class BiboxCoinSwapTradeService extends BiboxCoinSwapTradeServiceRaw implements MHTradeService {
    /**
     * Constructor
     *
     * @param exchange
     */
    public BiboxCoinSwapTradeService(Exchange exchange) {
        super(exchange);
    }

    @Override
    public String placeLimitOrder(MHLimitOrder limitOrder) throws IOException {
        return placeBiboxLimitOrder(limitOrder).toString();
    }

    @Override
    public Collection<String> cancelAllByInstrument(ParsingCurrencyPair parsingCurrencyPair) throws IOException {
        cancelAllBibox(parsingCurrencyPair);
        return null;
    }
}
