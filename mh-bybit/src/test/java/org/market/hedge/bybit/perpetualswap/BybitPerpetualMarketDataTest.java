package org.market.hedge.bybit.perpetualswap;

import com.github.tomakehurst.wiremock.common.Json;
import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.ajax.JSON;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.market.hedge.MHExchange;
import org.market.hedge.MHExchangeFactory;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.bybit.perpetualSwap.dto.marketData.resp.BybitSymbol;
import org.market.hedge.core.Symbol;
import org.market.hedge.core.TradingArea;
import org.market.hedge.service.StreamingParsingCurrencyPair;
import org.market.hedge.service.marketdata.MHMarketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class BybitPerpetualMarketDataTest {

    Logger logger= LoggerFactory.getLogger(BybitPerpetualMarketDataTest.class);

    @Test
    public void  getSymbols() throws IOException {
        MHExchange exchange = new BaseWiremockTest().createExchange();
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHMarketDataService marketDataService=exchange.getMarketDataService();
        try {
            List<Symbol> list= marketDataService.getSymbols();
            list.forEach(e->logger.info(JSON.toString(e)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testNetwork(){
        new BaseWiremockTest().network();
        try {
            //建立连接
            URL url = new URL("https://api.bybit.com/v2/public/symbols");
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //获取输入流
            InputStream input = httpUrlConn.getInputStream();
            //将字节输入流转换为字符输入流
            InputStreamReader read = new InputStreamReader(input, "utf-8");
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(read);
            // 读取返回结果
            String data = br.readLine();
            while(data!=null)  {
                System.out.println(data);
                data=br.readLine();
            }
            // 释放资源
            br.close();
            read.close();
            input.close();
            httpUrlConn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
