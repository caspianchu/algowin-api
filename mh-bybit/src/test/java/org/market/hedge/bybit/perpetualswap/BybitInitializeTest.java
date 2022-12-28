package org.market.hedge.bybit.perpetualswap;

import org.junit.Test;
import org.knowm.xchange.ExchangeSpecification;
import org.market.hedge.MHExchange;
import org.market.hedge.MHExchangeFactory;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.core.TradingArea;

public class BybitInitializeTest {

    @Test
    public void initialize() {
        MHExchange exchange = MHExchangeFactory.INSTANCE.createExchange(BybitExchange.class,"MXOsEpAU5se3jADHpk","Z26HxejVFgmmnYb7vkXLpruqsPsosA2ZULbi", TradingArea.PerpetualSwap);
        ExchangeSpecification specification = exchange.getDefaultExchangeSpecification();
        specification.setShouldLoadRemoteMetaData(false);
        //todo 代理vpn
//            specification.setProxyHost("127.0.0.1");
//            specification.setProxyPort(7890);
        exchange.applySpecification(specification);
    }

}
