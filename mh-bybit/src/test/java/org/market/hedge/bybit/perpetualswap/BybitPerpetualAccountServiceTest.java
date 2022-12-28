package org.market.hedge.bybit.perpetualswap;

import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.market.hedge.MHExchange;
import org.market.hedge.core.BilateralPositionInfo;
import org.market.hedge.service.StreamingParsingCurrencyPair;
import org.market.hedge.service.account.MHAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BybitPerpetualAccountServiceTest {

    Logger logger= LoggerFactory.getLogger(BybitPerpetualAccountServiceTest.class);

    @Test
    public void getBilateralPosition() throws IOException {
        MHExchange exchange = new BaseWiremockTest().createExchange();
        StreamingParsingCurrencyPair parsing=exchange.getStreamingParsing().parsingCurrencyPair;
        MHAccountService accountService=exchange.getAccountService();
        System.out.println(parsing.parsing(CurrencyPair.ETH_USDT).getParsing());
        try {
            BilateralPositionInfo position= accountService.getBilateralPosition(parsing.parsing(CurrencyPair.ETH_USDT));
            System.out.println(position.getBuyPosition().getAvailable());
            System.out.println(position.getSellPosition().getAvailable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
