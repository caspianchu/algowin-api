package org.market.hedge.binance.option;

import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.market.hedge.MHExchange;
import org.market.hedge.MHExchangeFactory;
import org.market.hedge.binance.BinanceExchange;
import org.market.hedge.binance.perpetualSwap.BinancePerpetualMarketDataServiceTest;
import org.market.hedge.core.Direction;
import org.market.hedge.core.ParsingCurrencyPair;
import org.market.hedge.core.TradingArea;
import org.market.hedge.dto.trade.MHLimitOrder;
import org.market.hedge.service.StreamingParsingCurrencyPair;
import org.market.hedge.service.trade.MHTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BinanceOptionTradeServiceTest {

    Logger log= LoggerFactory.getLogger(BinancePerpetualMarketDataServiceTest.class);

    private static final String apiKey="";

    private static final String secretKey="";

    @Test
    public void placeLimitOrder() {
        MHExchange exchange= MHExchangeFactory.INSTANCE.createExchange(BinanceExchange.class
                ,apiKey
                ,secretKey
                , TradingArea.Option);
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHTradeService tradeService=  exchange.getTradeService();
        List<MHLimitOrder> limitOrders=new ArrayList<>();
        limitOrders.add(order1(parsing));
        limitOrders.add(order2(parsing));
        limitOrders.add(order3(parsing));
        limitOrders.add(order4(parsing));
        limitOrders.add(order5(parsing));
        limitOrders.add(order6(parsing));
        limitOrders.add(order7(parsing));
        try {
            tradeService.placeLimitOrders(limitOrders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MHLimitOrder order1 (StreamingParsingCurrencyPair parsing) {
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("20000")
                , Direction.Put);
        MHLimitOrder order1=
                new MHLimitOrder(
                        Order.OrderType.BID,
                        new BigDecimal("0.01") ,
                        null,
                        "11223311",
                        new Date(),
                        new BigDecimal("101.20"),
                        pair);
        return order1;
    }

    public static MHLimitOrder order2 (StreamingParsingCurrencyPair parsing) {
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("20000")
                , Direction.Put);
        MHLimitOrder order1=
                new MHLimitOrder(
                        Order.OrderType.BID,
                        new BigDecimal("0.01") ,
                        null,
                        "11223311",
                        new Date(),
                        new BigDecimal("102.20"),
                        pair);
        return order1;
    }

    public static MHLimitOrder order3 (StreamingParsingCurrencyPair parsing) {
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("20000")
                , Direction.Put);
        MHLimitOrder order1=
                new MHLimitOrder(
                        Order.OrderType.BID,
                        new BigDecimal("0.01") ,
                        null,
                        "11223311",
                        new Date(),
                        new BigDecimal("103.20"),
                        pair);
        return order1;
    }

    public static MHLimitOrder order4 (StreamingParsingCurrencyPair parsing) {
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("20000")
                , Direction.Put);
        MHLimitOrder order1=
                new MHLimitOrder(
                        Order.OrderType.BID,
                        new BigDecimal("0.01") ,
                        null,
                        "11223311",
                        new Date(),
                        new BigDecimal("104.20"),
                        pair);
        return order1;
    }

    public static MHLimitOrder order5 (StreamingParsingCurrencyPair parsing) {
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("20000")
                , Direction.Put);
        MHLimitOrder order1=
                new MHLimitOrder(
                        Order.OrderType.BID,
                        new BigDecimal("0.01") ,
                        null,
                        "11223311",
                        new Date(),
                        new BigDecimal("105.20"),
                        pair);
        return order1;
    }

    public static MHLimitOrder order6 (StreamingParsingCurrencyPair parsing) {
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("20000")
                , Direction.Put);
        MHLimitOrder order1=
                new MHLimitOrder(
                        Order.OrderType.BID,
                        new BigDecimal("0.01") ,
                        null,
                        "11223311",
                        new Date(),
                        new BigDecimal("106.20"),
                        pair);
        return order1;
    }

    public static MHLimitOrder order7 (StreamingParsingCurrencyPair parsing) {
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("20000")
                , Direction.Put);
        MHLimitOrder order1=
                new MHLimitOrder(
                        Order.OrderType.BID,
                        new BigDecimal("0.01") ,
                        null,
                        "11223311",
                        new Date(),
                        new BigDecimal("107.20"),
                        pair);
        return order1;
    }

    @Test
    public void cancelAllByInstrument(){
        MHExchange exchange= MHExchangeFactory.INSTANCE.createExchange(BinanceExchange.class
                ,apiKey
                ,secretKey
                , TradingArea.Option);
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHTradeService tradeService=  exchange.getTradeService();
        ParsingCurrencyPair pair=parsing.parsing(CurrencyPair.BTC_USDT
                ,new Date(1673596800000L)
                ,new BigDecimal("14000")
                , Direction.Call);
        log.info(pair.getParsing());
        try {
            tradeService.cancelAllByInstrument(pair);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
