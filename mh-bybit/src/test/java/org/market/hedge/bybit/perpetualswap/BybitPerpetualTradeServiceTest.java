package org.market.hedge.bybit.perpetualswap;

import org.eclipse.jetty.util.ajax.JSON;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.market.hedge.MHExchange;
import org.market.hedge.bybit.perpetualSwap.service.BybitPerpetualAccountService;
import org.market.hedge.core.PositionMode;
import org.market.hedge.dto.trade.MHLimitOrder;
import org.market.hedge.service.StreamingParsingCurrencyPair;
import org.market.hedge.service.trade.MHTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

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
                    new BigDecimal("0.001"),
                    null,null,null,new BigDecimal("16670"),parsing.parsing(CurrencyPair.BTC_USDT));
            String orderId= tradeService.placeLimitOrder(limitOrder);
            logger.info(JSON.toString(orderId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {"limitPrice":20823.8,"orderFlags":[],"originalAmount":0.01,"parsingCurrencyPair":{"parsing":"BTCUSDT"},"remainingAmount":0.01,"type":"ASK","userReference":"114469872"}
     * * * */
    @Test
    public void  placeLimitOrder1() throws IOException {
        MHExchange exchange = new BaseWiremockTest().createExchange();
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHTradeService tradeService=exchange.getTradeService();
        try {
            MHLimitOrder limitOrder=new MHLimitOrder(
                    Order.OrderType.BID,
                    new BigDecimal("0.01"),
                    null,null,null,new BigDecimal("20800"),parsing.parsing(CurrencyPair.BTC_USDT));
            String orderId= tradeService.placeLimitOrder(limitOrder);
            logger.info(JSON.toString(orderId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 切換倉位模式
     * 該接口可以切換USDT永續和反向交割的倉位模式。單倉模式下，只能在單方向下持倉
     * 雙倉模式下，可以同時在兩個方向持倉。
     * 切換規則:
     *
     * 配置生效的優先級：symbol 配置 > coin 配置 > 系统默认配置
     * 目前系統默認配置：單向持倉模式
     * 如果請求參數中是按照coin的配置參數（此coin=settleCoin），則僅對該settleCoin下無持倉無委託單的symbol進行批量設置，並且未來新上線基於該settleCoin的結算的symol也是該模式。*
     * * * */
    @Test
    public void  positionMode() throws IOException {
        MHExchange exchange = new BaseWiremockTest().createExchange();
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        BybitPerpetualAccountService accountService= (BybitPerpetualAccountService) exchange.getAccountService();
        accountService.switchMode(parsing.parsing(CurrencyPair.BTC_USDT), PositionMode.MergedSingle);
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
