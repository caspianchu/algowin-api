package org.market.hedge.bybit.perpetualswap;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.knowm.xchange.ExchangeSpecification;
import org.market.hedge.MHExchange;
import org.market.hedge.MHExchangeFactory;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.core.TradingArea;

import java.io.IOException;

public class BaseWiremockTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    public MHExchange createExchange() throws IOException {
        MHExchange exchange =
                MHExchangeFactory.INSTANCE.createExchange(BybitExchange.class,"MXOsEpAU5se3jADHpk","Z26HxejVFgmmnYb7vkXLpruqsPsosA2ZULbi", TradingArea.PerpetualSwap);
        ExchangeSpecification specification = exchange.getDefaultExchangeSpecification();
        specification.setApiKey("9ku2v25eOJBXdQzwfT");
        specification.setSecretKey("TXnjTNZvdX1vFdQokpPzKlu5lL2Pxn5J1JXi");
        specification.setShouldLoadRemoteMetaData(false);
        specification.setProxyHost("127.0.0.1");
        specification.setProxyPort(7890);
        exchange.applySpecification(specification);
        return exchange;
    }

    public void network(){
        String proxyHost = "127.0.0.1";
        String proxyPort = "41091";

        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);

// 对https也开启代理
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
    }

}
