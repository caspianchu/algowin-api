package org.market.hedge.dto.trade;

import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.instrument.Instrument;
import org.market.hedge.core.ParsingCurrencyPair;
import org.market.hedge.core.TimeInForce;

import java.math.BigDecimal;
import java.util.Date;

public class MHLimitOrder extends LimitOrder {

    protected final ParsingCurrencyPair parsingCurrencyPair;

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    protected TimeInForce timeInForce;

    public ParsingCurrencyPair getParsingCurrencyPair() {
        return parsingCurrencyPair;
    }

    public MHLimitOrder(OrderType type, BigDecimal originalAmount, Instrument instrument, String id, Date timestamp, BigDecimal limitPrice, ParsingCurrencyPair parsing) {
        super(type, originalAmount, instrument, id, timestamp, limitPrice);
        this.timeInForce=TimeInForce.GTC;
        this.parsingCurrencyPair = parsing;
    }

    public MHLimitOrder(OrderType type, BigDecimal originalAmount, BigDecimal cumulativeAmount, Instrument instrument, String id, Date timestamp, BigDecimal limitPrice, ParsingCurrencyPair parsing) {
        super(type, originalAmount, cumulativeAmount, instrument, id, timestamp, limitPrice);
        this.timeInForce=TimeInForce.GTC;
        this.parsingCurrencyPair = parsing;
    }

    public MHLimitOrder(OrderType type, BigDecimal originalAmount, Instrument instrument, String id, Date timestamp, BigDecimal limitPrice, BigDecimal averagePrice, BigDecimal cumulativeAmount, BigDecimal fee, OrderStatus status, ParsingCurrencyPair parsing) {
        super(type, originalAmount, instrument, id, timestamp, limitPrice, averagePrice, cumulativeAmount, fee, status);
        this.timeInForce=TimeInForce.GTC;
        this.parsingCurrencyPair = parsing;
    }

    public MHLimitOrder(OrderType type, BigDecimal originalAmount, Instrument instrument, String id, Date timestamp, BigDecimal limitPrice, BigDecimal averagePrice, BigDecimal cumulativeAmount, BigDecimal fee, OrderStatus status, String userReference, ParsingCurrencyPair parsing) {
        super(type, originalAmount, instrument, id, timestamp, limitPrice, averagePrice, cumulativeAmount, fee, status, userReference);
        this.timeInForce=TimeInForce.GTC;
        this.parsingCurrencyPair = parsing;
    }

    public MHLimitOrder(OrderType type, BigDecimal originalAmount, Instrument instrument, String id, Date timestamp, BigDecimal limitPrice,
                        TimeInForce timeInForce,ParsingCurrencyPair parsing) {
        super(type, originalAmount, instrument, id, timestamp, limitPrice);
        this.timeInForce=timeInForce;
        this.parsingCurrencyPair = parsing;
    }

    public MHLimitOrder(OrderType type, BigDecimal originalAmount, BigDecimal cumulativeAmount, Instrument instrument, String id, Date timestamp, BigDecimal limitPrice,
                        TimeInForce timeInForce, ParsingCurrencyPair parsing) {
        super(type, originalAmount, cumulativeAmount, instrument, id, timestamp, limitPrice);
        this.timeInForce=timeInForce;
        this.parsingCurrencyPair = parsing;
    }

    public MHLimitOrder(OrderType type, BigDecimal originalAmount,
                        Instrument instrument, String id,
                        Date timestamp, BigDecimal limitPrice,
                        BigDecimal averagePrice, BigDecimal cumulativeAmount,
                        BigDecimal fee, OrderStatus status, String userReference,
                        TimeInForce timeInForce, ParsingCurrencyPair parsing) {
        super(type, originalAmount, instrument, id, timestamp, limitPrice, averagePrice, cumulativeAmount, fee, status, userReference);
        this.timeInForce=timeInForce;
        this.parsingCurrencyPair = parsing;
    }

}
