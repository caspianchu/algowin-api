package org.market.hedge.bybit.perpetualSwap.service;

import org.knowm.xchange.bybit.service.BybitDigest;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.service.BaseService;
import org.knowm.xchange.utils.nonce.CurrentTimeIncrementalNonceFactory;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.bybit.perpetualSwap.BybitPerpetualAuthenticated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author chuxianbo
 */
public class BybitPerpetualBaseService implements BaseService {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected final String apiKey;
    protected final String secretKey;
    protected final BybitPerpetualAuthenticated bybit;
    protected final ParamsDigest signatureCreator;
    protected final SynchronizedValueFactory<Long> nonceFactory;

    public BybitPerpetualBaseService(BybitExchange exchange) {
        this.nonceFactory = new CurrentTimeIncrementalNonceFactory(TimeUnit.MILLISECONDS);
        this.bybit = ExchangeRestProxyBuilder.forInterface(BybitPerpetualAuthenticated.class, exchange.getExchangeSpecification()).build();
        this.apiKey = exchange.getExchangeSpecification().getApiKey();
        this.secretKey=exchange.getExchangeSpecification().getSecretKey();
        this.signatureCreator =BybitDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());

    }

}
