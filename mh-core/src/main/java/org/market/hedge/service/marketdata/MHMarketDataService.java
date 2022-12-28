package org.market.hedge.service.marketdata;

import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.market.hedge.core.*;

import java.io.IOException;
import java.util.List;

/**
 * 市场
 * */
public interface MHMarketDataService extends MarketDataService {

    /**
     * 获取盘口行情
     * */
    default OrderBook getOrderBook(ParsingCurrencyPair currencyPair, Object... args) throws IOException {
        throw new NotYetImplementedForExchangeException();
    }

    default Kline getLastKline(ParsingCurrencyPair pair, KlineInterval interval) throws IOException {
        throw new NotYetImplementedForExchangeException();    }

    default List<Kline> getKlines(ParsingCurrencyPair pair, KlineInterval interval, Integer limit) throws IOException {
        throw new NotYetImplementedForExchangeException();    }

    /**
     * 获取单币对最新标记价格和资金费率
     * */
    default PremiumIndex getPremiumIndex(ParsingCurrencyPair pair) throws IOException {
        throw new NotYetImplementedForExchangeException();
    }

    /**
     * 获取全部币对最新标记价格和资金费率
     * */
    default List<PremiumIndex> getAllPremiumIndex() throws IOException {
        throw new NotYetImplementedForExchangeException();
    }

    /**
     * 獲取合約信息.
     * */
    default List<Symbol> getSymbols() throws IOException {
        throw new NotYetImplementedForExchangeException();
    }


}
