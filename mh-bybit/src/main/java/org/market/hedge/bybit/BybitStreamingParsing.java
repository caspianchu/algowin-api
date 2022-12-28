package org.market.hedge.bybit;

import org.knowm.xchange.currency.CurrencyPair;
import org.market.hedge.core.ParsingCurrencyPair;
import org.market.hedge.core.StreamingParsing;
import org.market.hedge.core.TradingArea;

public class BybitStreamingParsing extends StreamingParsing {
    public BybitStreamingParsing(TradingArea tradingArea) {
        super(tradingArea);
    }

    @Override
    public ParsingCurrencyPair instancePerpetualSwap(CurrencyPair currencyPair, Object... args) {
        String base= currencyPair.base.toString().toUpperCase();
        String counter= currencyPair.counter.toString().toUpperCase();
        return new ParsingCurrencyPair(base+counter ,currencyPair, args);

    }

}
