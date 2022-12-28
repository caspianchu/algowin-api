package org.market.hedge.coinex;

import org.market.hedge.BaseMHExchange;
import org.market.hedge.MHExchange;
import org.market.hedge.MHExchangeSpecification;
import org.market.hedge.coinex.service.CoinexAccountService;
import org.market.hedge.core.TradingArea;
import si.mazi.rescu.SynchronizedValueFactory;

public class CoinexExchange extends BaseMHExchange implements MHExchange {

  @Override
  protected void initServices() {
    this.accountService = new CoinexAccountService(this);
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {
    return null;
  }

  @Override
  public MHExchangeSpecification getDefaultExchangeSpecification(TradingArea tradingArea) {
    MHExchangeSpecification exchangeSpecification = new MHExchangeSpecification(this.getClass());
    exchangeSpecification.setSslUri("https://api.coinex.com");
    exchangeSpecification.setHost("www.coinex.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("Coinex");
    exchangeSpecification.setExchangeDescription("Bitstamp is a crypto-to-crypto exchange.");
    return exchangeSpecification;
  }
}
