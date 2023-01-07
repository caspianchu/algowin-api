package org.market.hedge.deribit.swap;

import org.junit.Test;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.market.hedge.MHExchangeSpecification;
import org.market.hedge.deribit.DeribitExchange;
import org.market.hedge.MHExchange;
import org.market.hedge.MHExchangeFactory;
import org.market.hedge.core.TradingArea;
import org.market.hedge.service.StreamingParsingCurrencyPair;
import org.market.hedge.service.marketdata.MHMarketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DeribitMarketDataTest {

    Logger logger= LoggerFactory.getLogger(DeribitMarketDataTest.class);

    @Test
    public void getDeribitOrderBookTest() throws Exception {
        System.setProperty("https.protocols", "TLSv1.3,TLSv1.2,TLSv1.1,TLSv1,SSLv3");
        System.setProperty("rescu.http.readProxyHost", "127.0.0.1");
        System.setProperty("rescu.http.readProxyPort", "7890");
        MHExchange exchange = MHExchangeFactory.INSTANCE.createExchange(DeribitExchange.class, TradingArea.PerpetualSwap);
        ExchangeSpecification specification=exchange.getDefaultExchangeSpecification();
        specification.setProxyHost("127.0.0.1");
        specification.setProxyPort(7890);
        exchange.applySpecification(specification);
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHMarketDataService marketDataService=exchange.getMarketDataService();
        for (int i=0;i<1;i++){
            try {
                OrderBook orderBook=marketDataService.getOrderBook(parsing.parsing(CurrencyPair.BTC_USDT));
                logger.info(orderBook.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("https.protocols", "TLSv1.3,TLSv1.2,TLSv1.1,TLSv1,SSLv3");
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, null, null);

        SSLSocketFactory factory = (SSLSocketFactory) context.getSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket();

        String[] protocols = socket.getSupportedProtocols();

        System.out.println("Supported Protocols: " + protocols.length);
        for (int i = 0; i < protocols.length; i++) {
            System.out.println(" " + protocols[i]);
        }

        protocols = socket.getEnabledProtocols();

        System.out.println("Enabled Protocols: " + protocols.length);
        for (int i = 0; i < protocols.length; i++) {
            System.out.println(" " + protocols[i]);
        }

        SSLContext context1 = SSLContext.getInstance("TLS");
        context1.init(null, null, null);
        String[] supportedProtocols = context1.getDefaultSSLParameters().getProtocols();
        System.out.println("context1 Protocol: "+Arrays.toString(supportedProtocols));
    }


}
