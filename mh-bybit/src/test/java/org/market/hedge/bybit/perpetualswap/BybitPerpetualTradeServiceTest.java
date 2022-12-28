package org.market.hedge.bybit.perpetualswap;

import org.eclipse.jetty.util.ajax.JSON;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.market.hedge.MHExchange;
import org.market.hedge.core.Symbol;
import org.market.hedge.dto.trade.MHLimitOrder;
import org.market.hedge.service.StreamingParsingCurrencyPair;
import org.market.hedge.service.marketdata.MHMarketDataService;
import org.market.hedge.service.trade.MHTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class BybitPerpetualTradeServiceTest {

    Logger logger= LoggerFactory.getLogger(BybitPerpetualTradeServiceTest.class);

    @Test
    public void  placeExitLimitOrder() throws IOException {
        MHExchange exchange = new BaseWiremockTest().createExchange();
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHTradeService tradeService=exchange.getTradeService();
        try {
            MHLimitOrder limitOrder=new MHLimitOrder(
                    Order.OrderType.EXIT_BID,
                    new BigDecimal("0.004"),
                    null,null,null,new BigDecimal("16718.6"),parsing.parsing(CurrencyPair.BTC_USDT));
            String orderId= tradeService.placeLimitOrder(limitOrder);
            logger.info(JSON.toString(orderId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  placeLimitOrder() throws IOException {
        MHExchange exchange = new BaseWiremockTest().createExchange();
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHTradeService tradeService=exchange.getTradeService();
        try {
            MHLimitOrder limitOrder=new MHLimitOrder(
                    Order.OrderType.ASK,
                    new BigDecimal("0.01"),
                    null,null,null,new BigDecimal("1200"),parsing.parsing(CurrencyPair.ETH_USDT));
            String orderId= tradeService.placeLimitOrder(limitOrder);
            logger.info(JSON.toString(orderId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cancelAllByInstrument() throws IOException {
        MHExchange exchange = new BaseWiremockTest().createExchange();
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHTradeService tradeService=exchange.getTradeService();
        try {
            Collection<String> collection= tradeService.cancelAllByInstrument(parsing.parsing(CurrencyPair.BTC_USDT));
            //collection.forEach(e->logger.info(JSON.toString(e)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
