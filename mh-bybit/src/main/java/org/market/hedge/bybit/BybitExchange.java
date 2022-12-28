package org.market.hedge.bybit;

import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.utils.AuthUtils;
import org.market.hedge.BaseMHExchange;
import org.market.hedge.MHExchange;
import org.market.hedge.MHExchangeSpecification;
import org.market.hedge.bybit.perpetualSwap.service.BybitPerpetualAccountService;
import org.market.hedge.bybit.perpetualSwap.service.BybitPerpetualMarketDataService;
import org.market.hedge.bybit.perpetualSwap.service.BybitPerpetualTradeService;
import org.market.hedge.core.TradingArea;
import org.market.hedge.exception.NullTradingAreaException;

import java.io.IOException;

public class BybitExchange extends BaseMHExchange implements MHExchange {

    @Override
    protected void initServices() {
        switch (mHexchangeSpecification.getTradingArea()) {
            case PerpetualSwap:
                this.mHaccountService = new BybitPerpetualAccountService(this);
                this.mHmarketDataService = new BybitPerpetualMarketDataService(this);
                this.mHtradeService = new BybitPerpetualTradeService(this);
                return;
            default:
                throw new NullTradingAreaException(mHexchangeSpecification.getTradingArea());
        }
    }

    @Override
    public MHExchangeSpecification getDefaultExchangeSpecification(TradingArea tradingArea) {
        MHExchangeSpecification spec = new MHExchangeSpecification(this.getClass().getCanonicalName());
        spec.setHost("www.bybit.com");
        spec.setPort(80);
        spec.setExchangeName("Bybit");
        spec.setExchangeDescription("Bybit Exchange.");
        spec.setTradingArea(tradingArea);
        AuthUtils.setApiAndSecretKey(spec, "bybit");
        this.streamingParsing=new BybitStreamingParsing(tradingArea);
        if (tradingArea == TradingArea.PerpetualSwap) {
            spec.setSslUri("https://api.bybit.com");
            return spec;
        }
        throw new NullTradingAreaException(tradingArea);
    }

    @Override
    public void remoteInit() throws IOException, ExchangeException {
        switch (mHexchangeSpecification.getTradingArea()){
            case PerpetualSwap:
                //exchangeMetaData = ((BybitMarketDataService) marketDataService).getMetadata();
                return;
            default:
        }
    }
}
