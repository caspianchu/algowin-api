package org.market.hedge.coinex.service;

import org.knowm.xchange.Exchange;
import org.market.hedge.coinex.dto.account.CoinexBalanceInfo;

import java.io.IOException;
import java.util.Map;

public class CoinexAccountServiceRaw extends CoinexBaseService {

  protected CoinexAccountServiceRaw(Exchange exchange) {
    super(exchange);
  }

  public Map<String, CoinexBalanceInfo> getCoinexBalances() throws IOException {
    //        return
    // coinex.getWallet(signatureCreator,apiKey,exchange.getNonceFactory()).getBalances();
    return null;
  }
}
